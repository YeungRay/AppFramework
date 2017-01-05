package com.baishan.greendaodemo.di.component;

import android.app.Activity;

import com.baishan.greendaodemo.di.FragmentScope;
import com.baishan.greendaodemo.di.module.FragmentModule;

import dagger.Component;

/**
 * Created by RayYeung on 2017/1/4.
 */

@FragmentScope
@Component(dependencies = AppComponent.class,modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();
}
