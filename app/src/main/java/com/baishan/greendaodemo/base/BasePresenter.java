package com.baishan.greendaodemo.base;

/**
 * Created by RayYeung on 2016/9/22.
 */
public interface BasePresenter<V extends BaseView> {

    void attachView(V view);
    void detachView();

}
