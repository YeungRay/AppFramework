package com.baishan.greendaodemo.ui.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.baishan.greendaodemo.R;
import com.baishan.greendaodemo.base.BaseActivity;
import com.baishan.greendaodemo.model.User;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.button)
    Button button;
    private String destFileDir;
    private String destFileName;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        System.out.println(destFileDir.length());
//        destFileDir = Environment.getExternalStorageDirectory().getAbsolutePath();
//        destFileName = "ee.mp4";
//        new FileDownload(destFileDir, destFileName)
//                .download("http://v1.365yg.com/8940aa92ca6996d82dd41c61181bd5e6/58a3ca5b/video/c/fe0b69223d524753bb668d61d62b46d9/", new FileDownload.Callback() {
//                    @Override
//                    public void onError(Exception e) {
//                        Logger.e(e);
//                    }
//
//                    @Override
//                    public void onSuccess(File file) {
//                        textView.setText(file.getAbsolutePath());
//                    }
//
//                    @Override
//                    public void inProgress(float progress, long total) {
//                        textView.setText(progress + "");
//                    }
//                });
    }


    @Override
    protected void setListener() {

    }

    @Override
    public void showUser(List<User> list) {
        for (User user : list) {
            textView.append(user.getAnimal().toString() + "\n");
        }
    }


    @OnClick(R.id.button)
    public void onClick() {
        mPresenter.insert();
        mPresenter.query();
    }
}
