package com.mylearning.activity;

import com.mylearning.base.BaseView;
import com.mylearning.model.EmployeeViewModel;
import com.mylearning.presenter.MVPPresenter;

import java.util.List;

import retrofit2.Response;

public interface MainActivityContract {

    interface MainActivityView extends BaseView<Presenter> {
       void updateView(List<EmployeeViewModel> employeeData);
    }
    interface Presenter extends MVPPresenter {

        void getAllEmployee();

        void clearAll();
    }


}
