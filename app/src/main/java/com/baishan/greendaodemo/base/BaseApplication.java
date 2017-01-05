package com.baishan.greendaodemo.base;

import android.app.Application;

import com.baishan.greendaodemo.di.component.AppComponent;
import com.baishan.greendaodemo.di.component.DaggerAppComponent;
import com.baishan.greendaodemo.di.module.AppModule;
import com.baishan.greendaodemo.di.module.DbModule;

/**
 * Created by RayYeung on 2016/9/6.
 */
public class BaseApplication extends Application {

    public static BaseApplication getInstance() {
        return instance;
    }

    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    public static AppComponent getAppComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .dbModule(new DbModule(instance))
                .build();
    }
}
