package com.baishan.greendaodemo.di.module;

import android.app.Activity;

import com.baishan.greendaodemo.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by RayYeung on 2016/9/23.
 */
@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity(){
        return activity;
    }
}
