package com.mylearning.networking;

import android.widget.Toast;

import com.mylearning.activity.MainActivity;
import com.mylearning.model.EmployeeViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.mylearning.BuildConfig.BASE_URL;

public class RetrofitClientInstance {
    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static void getEmployeeResponse(final APICallback apiCallback, final int requestCode) {
        EmployeeDataInterface service = RetrofitClientInstance.getInstance().create(EmployeeDataInterface.class);

        Call<List<EmployeeViewModel>> call = service.getAllEmployee();
        call.enqueue(new Callback<List<EmployeeViewModel>>() {
            @Override
            public void onResponse(Call<List<EmployeeViewModel>> call, Response<List<EmployeeViewModel>> response) {
                apiCallback.onResponse(call, response, requestCode);
            }

            @Override
            public void onFailure(Call<List<EmployeeViewModel>> call, Throwable t) {
                apiCallback.onFailure(call, t, requestCode);
            }
        });
    }
}
