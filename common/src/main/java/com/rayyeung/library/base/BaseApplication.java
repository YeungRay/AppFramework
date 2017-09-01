package com.rayyeung.library.base;


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
    }


}
