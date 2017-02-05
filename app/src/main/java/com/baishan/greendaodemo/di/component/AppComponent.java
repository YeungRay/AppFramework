package com.baishan.greendaodemo.di.component;

import com.baishan.greendaodemo.base.BaseApplication;
import com.baishan.greendaodemo.dao.AnimalDao;
import com.baishan.greendaodemo.dao.UserDao;
import com.baishan.greendaodemo.di.ContextLife;
import com.baishan.greendaodemo.di.module.AppModule;
import com.baishan.greendaodemo.di.module.DbModule;
import com.baishan.greendaodemo.http.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by RayYeung on 2016/9/23.
 */
@Singleton
@Component(modules = {AppModule.class, DbModule.class})
public interface AppComponent {

    @ContextLife
    BaseApplication getContext();

    UserDao getUserDao();

    AnimalDao getAnimalDao();

    ApiService getApiService();

}
