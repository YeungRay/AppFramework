package com.baishan.greendaodemo.http;

import android.text.TextUtils;

import com.baishan.greendaodemo.utils.ToastUtils;

import rx.Subscriber;

/**
 * Created by Administrator
 * on 2016/5/18.
 */
public abstract class SubscriberCallBack<T> extends Subscriber<ResultResponse<T>> {


    public SubscriberCallBack() {
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(final Throwable e) {
        e.printStackTrace();
//        AppClient.getDelivery().post(() -> {
//            if (e instanceof SocketTimeoutException) {
//                ToastUtils.showToast("网络连接超时");
//            } else if (e instanceof SocketException) {
//                if (e instanceof ConnectException) {
//                    ToastUtils.showToast("网络未连接");
//                } else {
//                    ToastUtils.showToast("网络错误");
//                }
//            }
//            onError();
//        });
    }

    @Override
    public void onNext(ResultResponse response) {

        if (response.Code == 200) {
            onSuccess((T) response.Result);
        } else {
            if (response.Code == 400&& !TextUtils.isEmpty(response.Message)) {
                ToastUtils.showToast(response.Message);
            }
            onFailure(response);
        }


    }

    protected abstract void onSuccess(T response);

    protected void onError() {
    }

    protected void onFailure(ResultResponse response) {
    }

}
