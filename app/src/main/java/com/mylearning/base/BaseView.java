package com.mylearning.base;

import com.mylearning.presenter.MVPPresenter;

public interface BaseView <T extends MVPPresenter> {
    void showProgress();
    void hideProgress();
    void setPresenter(T presenter);
}
