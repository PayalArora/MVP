package com.mylearning.model;

import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.library.baseAdapters.BR;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mylearning.R;
import com.squareup.picasso.Picasso;

public class EmployeeViewModel extends BaseObservable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("employee_name")
    @Expose
    private String employeeName;
    @SerializedName("employee_salary")
    @Expose
    private String employeeSalary;
    @SerializedName("employee_age")
    @Expose
    private String employeeAge;
    @SerializedName("profile_image")
    @Expose
    private String profileImage;

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Bindable
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
        notifyPropertyChanged(BR.employeeName);
    }

    @Bindable
    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
        notifyPropertyChanged(BR.employeeSalary);
    }

    @Bindable
    public String getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
        notifyPropertyChanged(BR.employeeAge);
    }

    @Bindable
    public String getProfileImage() {
        return profileImage;


    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
        notifyPropertyChanged(BR.profileImage);
    }

    @BindingAdapter({"android:src"})
    public static void loadImage(ImageView view, String imageUrl) {
        if (imageUrl != null) {
        Picasso.with(view.getContext()).load(imageUrl).placeholder(R.drawable.ic_launcher_background).into(view);
    }}
}