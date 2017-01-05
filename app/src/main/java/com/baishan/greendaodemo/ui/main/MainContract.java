package com.baishan.greendaodemo.ui.main;

import com.baishan.greendaodemo.base.BasePresenter;
import com.baishan.greendaodemo.base.BaseView;
import com.baishan.greendaodemo.model.User;

import java.util.List;

/**
 * Created by RayYeung on 2016/9/22.
 */
public interface MainContract {

    interface View extends BaseView{
       void showUser(List<User> list);
    }
    interface Presenter extends BasePresenter<View>{
        void insert();
        void  query();
    }
}
