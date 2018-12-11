package com.example.dell.liuguangyan1211.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dell.liuguangyan1211.R;
import com.example.dell.liuguangyan1211.bean.NewBean;
import com.example.dell.liuguangyan1211.callback.MyCallBack;
import com.example.dell.liuguangyan1211.presenter.IPresenterImpl;
import com.recker.flybanner.FlyBanner;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IView
{
    private FlyBanner flyBanner;
    private String url="https://www.zhaoapi.cn/ad/getAd";
    private IPresenterImpl iPresenter;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       flyBanner = findViewById(R.id.fly);
       iPresenter = new IPresenterImpl(this);
       iPresenter.requestData(url,NewBean.class);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void succes(Object data) {
          NewBean bean = (NewBean) data;
        List<NewBean.DataBean> data1 = bean.getData();
        for (int i=0;i<data1.size();i++){
            list.add(data1.get(i).getIcon());
        }
        flyBanner.setImagesUrl(list);
    }
}
