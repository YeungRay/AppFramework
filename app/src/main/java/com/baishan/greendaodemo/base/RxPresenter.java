package com.baishan.greendaodemo.base;

import com.baishan.greendaodemo.http.ApiService;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by RayYeung on 2016/9/23.
 */
public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    @Inject
    protected ApiService apiService;
    protected T mView;
    protected CompositeSubscription mCompositeSubscription;

    //rxjava取消注册，以避免内存泄露
    protected void unSubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    protected void addSubscribe(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }
}
