package com.rayyeung.library.http;


import android.os.Handler;
import android.os.Looper;

import com.rayyeung.library.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 *
 */
public class HttpClient {

    public static Retrofit mRetrofit;
    private static Handler mDelivery;

    public static Retrofit getRetrofit(String url) {
        if (mRetrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (BuildConfig.DEBUG) {
                okhttp3.logging.HttpLoggingInterceptor loggingInterceptor = new okhttp3.logging.HttpLoggingInterceptor();
                loggingInterceptor.setLevel(okhttp3.logging.HttpLoggingInterceptor.Level.BODY);
                //设置 Debug Log 模式
                builder.addInterceptor(loggingInterceptor);
            }
            OkHttpClient okHttpClient = builder.build();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return mRetrofit;
    }

    public static Handler getDelivery() {
        if (mDelivery == null) {
            mDelivery = new Handler(Looper.getMainLooper());
        }
        return mDelivery;
    }
}
