package com.example.recyclerviewl.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.recyclerviewl.R;
import com.example.recyclerviewl.adpter.LinearAdpter;
import com.example.recyclerviewl.bean.User;
import com.example.recyclerviewl.presenter.IPresenter;
import com.example.recyclerviewl.presenter.IPresenterImpl;

import java.util.HashMap;
import java.util.List;

public class LinaerActivity extends AppCompatActivity implements View.OnClickListener,IView {
     private LinearAdpter linearAdpter;
     private IPresenterImpl miPresenter;
     private String url="http://www.zhaoapi.cn/product/getCatagory";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linaer);
        initData();
        init();

    }
    //互相绑定
    public void  initData(){
         miPresenter = new IPresenterImpl(this);
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.recycler);
        //写一个布局管理器
       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //设置方向
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
         //设置布局管理器
        recyclerView.setLayoutManager(linearLayoutManager);
        miPresenter.requestData(url,new HashMap<String, String>(),User.class);
        linearAdpter = new LinearAdpter(this);
        recyclerView.setAdapter(linearAdpter);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void success(Object data) {
        User user = (User) data;

        linearAdpter.setmDatas(user.getData());
    }
}
