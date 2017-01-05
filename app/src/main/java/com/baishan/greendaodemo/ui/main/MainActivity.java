package com.baishan.greendaodemo.ui.main;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.TextView;

import com.baishan.greendaodemo.R;
import com.baishan.greendaodemo.base.BaseActivity;
import com.baishan.greendaodemo.http.FileDownload;
import com.baishan.greendaodemo.model.User;
import com.orhanobut.logger.Logger;

import java.io.File;
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
       destFileDir = Environment.getExternalStorageDirectory().getAbsolutePath();
        destFileName = "yoursex_v1.5.3_other.apk";
        new FileDownload(destFileDir,destFileName)
                .download("http://yoursex.cn:8082/html/yoursex_v1.5.3_other.apk", new FileDownload.Callback() {
                    @Override
                    public void onError(Exception e) {
                        Logger.e(e);
                    }

                    @Override
                    public void onSuccess(File file) {
                        textView.setText(file.getAbsolutePath());
                    }

                    @Override
                    public void inProgress(float progress, long total) {
                        textView.setText(progress+"");
                    }
                });
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
