package com.mylearning.activity;

import android.util.Log;

import com.mylearning.model.DataManager;
import com.mylearning.model.EmployeeViewModel;
import com.mylearning.networking.APICallback;
import com.mylearning.networking.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivityIml implements MainActivityContract.Presenter {
    DataManager dataManager;
    MainActivityContract.MainActivityView mView;

    MainActivityIml(MainActivityContract.MainActivityView mainActivityView, DataManager dataManager) {
        this.dataManager = dataManager;
        this.mView = mainActivityView;
        mView.setPresenter(this);
    }

    @Override
    public void getAllEmployee() {
        mView.showProgress();
        RetrofitClientInstance.getEmployeeResponse(new APICallback() {
            @Override
            public void onResponse(Call<?> call, Response<?> response, int requestCode) {
                mView.hideProgress();
                Log.d("EMPLOYEE DATA", "Response : " + response.body());
                List<EmployeeViewModel> employeeViewModel = (List<EmployeeViewModel>) response.body();
                dataManager.setEmployeeViewModel(employeeViewModel);
                mView.updateView(dataManager.getEmployeeViewModel());
            }

            @Override
            public void onFailure(Call<?> call, Throwable t, int requestCode) {
                mView.hideProgress();
            }
        }, 1);
    }

    @Override
    public void clearAll() {
        dataManager.getEmployeeViewModel().clear();
    }
}
