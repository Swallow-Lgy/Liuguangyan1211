package com.example.recyclerviewl.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.recyclerviewl.R;
import com.example.recyclerviewl.adpter.StaagerAdpter;
import com.example.recyclerviewl.bean.User;
import com.example.recyclerviewl.presenter.IPresenterImpl;

import java.util.HashMap;

public class FlowActivity extends AppCompatActivity implements IView{
    private final int mSpanCount=3;
    private StaagerAdpter staagerAdpter;
    private IPresenterImpl miPresenter;
    private String url="http://www.zhaoapi.cn/product/getCatagory";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);
        init();
    }

    private void init() {
        miPresenter = new IPresenterImpl(this);
        RecyclerView recyclerView = findViewById(R.id.recycler_flow);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(mSpanCount,StaggeredGridLayoutManager.VERTICAL);
        //设置布局管理器
        miPresenter.requestData(url,new HashMap<String, String>(),User.class);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        staagerAdpter = new StaagerAdpter(this);
        recyclerView.setAdapter(staagerAdpter);


    }

    @Override
    public void success(Object data) {
        User user = (User) data;
        staagerAdpter.setmData(user.getData());
    }
}
