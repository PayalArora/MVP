package com.mylearning.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.mylearning.MyApplication;
import com.mylearning.R;
import com.mylearning.adapter.EmployeeListAdapter;
import com.mylearning.model.EmployeeViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract.MainActivityView {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    private MainActivityContract.Presenter mPresenter;
    ProgressDialog mProgressDialog;
    EmployeeListAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MainActivityIml(this, MyApplication.get(this).getDataManager());
        initData();
        mPresenter.getAllEmployee();


    }

    private void initData() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mMainAdapter = new EmployeeListAdapter(this);
        recyclerView.setAdapter(mMainAdapter);
    }

    @Override
    public void updateView(List<EmployeeViewModel> employeeData) {
       mMainAdapter.updateData(employeeData);
    }

    @Override
    public void showProgress() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("Loading");
        mProgressDialog.show();
    }

    @Override
    public void hideProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    @Override
    public void setPresenter(MainActivityContract.Presenter presenter) {
    mPresenter = presenter;
    }
}
