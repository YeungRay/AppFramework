package com.baishan.greendaodemo.di.module;

import com.baishan.greendaodemo.base.BaseApplication;
import com.baishan.greendaodemo.di.ContextLife;
import com.baishan.greendaodemo.http.ApiService;
import com.baishan.greendaodemo.http.AppClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by RayYeung on 2016/9/23.
 */
@Module
public class AppModule {


    private BaseApplication application;

    public AppModule(BaseApplication application) {
        this.application = application;
    }

    @Singleton
    @Provides
    @ContextLife
    BaseApplication provideApplicationContext(){
        return application;
    }

    @Singleton
    @Provides
    ApiService provideApiService(){
        return AppClient.getApiService();
    }
}
