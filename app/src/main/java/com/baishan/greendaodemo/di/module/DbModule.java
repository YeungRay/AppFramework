package com.baishan.greendaodemo.di.module;

import android.content.Context;

import com.baishan.greendaodemo.dao.AnimalDao;
import com.baishan.greendaodemo.dao.DaoMaster;
import com.baishan.greendaodemo.dao.DaoSession;
import com.baishan.greendaodemo.dao.UserDao;
import com.baishan.greendaodemo.db.MySQLiteOpenHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by RayYeung on 2016/9/23.
 */
@Module
public class DbModule {

    private Context context;

    private static final String DB_NAME = "demo.db";

    public DbModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    DaoMaster.OpenHelper provideOpenHelper() {
        return new MySQLiteOpenHelper(context, DB_NAME);
    }

    @Provides
    @Singleton
    DaoMaster provideDaoMaster(DaoMaster.OpenHelper helper) {
        return new DaoMaster(helper.getWritableDatabase());
    }

    @Provides
    @Singleton
    DaoSession provideDaoSession(DaoMaster master) {
        return master.newSession();
    }

    @Provides
    @Singleton
    UserDao provideUserDao(DaoSession session) {
        return session.getUserDao();
    }

    @Provides
    @Singleton
    AnimalDao provideAnimalDao(DaoSession session) {
        return session.getAnimalDao();
    }

}
