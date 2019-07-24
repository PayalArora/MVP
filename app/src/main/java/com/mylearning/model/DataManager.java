package com.mylearning.model;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager mDataManager;
    private List<EmployeeViewModel> employeeViewModel;

    public List<EmployeeViewModel> getEmployeeViewModel() {
        return employeeViewModel;
    }

    public void setEmployeeViewModel(List<EmployeeViewModel> employeeViewModel) {
        this.employeeViewModel = employeeViewModel;
    }

    DataManager() {
        employeeViewModel = new ArrayList<>();
    }

    public static DataManager getInstance() {
        if (mDataManager == null) {
            mDataManager = new DataManager();
        }
        return mDataManager;
    }

}
