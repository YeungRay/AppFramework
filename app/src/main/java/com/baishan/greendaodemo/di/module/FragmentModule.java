package com.baishan.greendaodemo.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.baishan.greendaodemo.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by RayYeung on 2017/1/4.
 */
@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
