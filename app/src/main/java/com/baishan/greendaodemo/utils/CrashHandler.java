package com.baishan.greendaodemo.utils;

import com.orhanobut.logger.Logger;

/**
 * Created by RayYeung on 2017/2/17.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger.e((Exception) e);
    }
}
