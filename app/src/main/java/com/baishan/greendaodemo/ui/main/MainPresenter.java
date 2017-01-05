package com.baishan.greendaodemo.ui.main;

import android.app.Activity;
import android.widget.Toast;

import com.baishan.greendaodemo.base.RxPresenter;
import com.baishan.greendaodemo.dao.AnimalDao;
import com.baishan.greendaodemo.dao.UserDao;
import com.baishan.greendaodemo.model.Animal;
import com.baishan.greendaodemo.model.User;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by RayYeung on 2016/9/22.
 */
public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {


    private UserDao userDao;
    private Activity activity;
    private AnimalDao animalDao;

    @Inject
    public MainPresenter(UserDao userDao, AnimalDao animalDao, Activity activity) {
        this.userDao = userDao;
        this.animalDao = animalDao;
        this.activity = activity;
    }


    @Override
    public void insert() {
        Animal animal = new Animal();
        animal.name = "cat";
        long id = animalDao.insert(animal);
        User user = new User("aaa","123",animal);
        user.setAnimalId(id);
        userDao.insert(user);
        Toast.makeText(activity, "插入了一条数据", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void query() {
        List<User> aaa = userDao.loadAll();
        mView.showUser(aaa);
    }
}
