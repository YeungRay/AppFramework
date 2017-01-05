package com.baishan.greendaodemo.di.component;

import android.app.Activity;

import com.baishan.greendaodemo.di.ActivityScope;
import com.baishan.greendaodemo.di.module.ActivityModule;
import com.baishan.greendaodemo.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by RayYeung on 2016/9/23.
 */
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
@ActivityScope
public interface ActivityComponent {

    Activity getActivty();

    void inject(MainActivity activity);

}
