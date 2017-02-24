package com.baishan.greendaodemo.base;

import com.baishan.greendaodemo.di.component.AppComponent;
import com.baishan.greendaodemo.di.component.DaggerAppComponent;
import com.baishan.greendaodemo.di.module.AppModule;
import com.baishan.greendaodemo.di.module.DbModule;
import com.baishan.greendaodemo.utils.CrashHandler;

/**
 * Created by RayYeung on 2016/9/6.
 */
public class BaseApplication extends ActivityManagerApplication {

    public static BaseApplication getInstance() {
        return instance;
    }

    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Thread.setDefaultUncaughtExceptionHandler(new CrashHandler());
    }

    public static AppComponent getAppComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .dbModule(new DbModule(instance))
                .build();
    }
}
