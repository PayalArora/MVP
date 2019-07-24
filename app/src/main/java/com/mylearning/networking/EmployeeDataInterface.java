package com.mylearning.networking;

import com.mylearning.model.EmployeeViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeDataInterface {

    @GET("v1/employees")
    Call<List<EmployeeViewModel>> getAllEmployee();
}