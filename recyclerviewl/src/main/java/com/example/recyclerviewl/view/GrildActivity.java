package com.example.recyclerviewl.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.recyclerviewl.R;
import com.example.recyclerviewl.adpter.GridAdpter;
import com.example.recyclerviewl.bean.User;
import com.example.recyclerviewl.presenter.IPresenterImpl;

import java.util.HashMap;

public class GrildActivity extends AppCompatActivity implements IView{
   //一行显示几个
    private final int mSpanCount=3;
   private GridAdpter gridAdpter;
    private String url="http://www.zhaoapi.cn/product/getCatagory";
    private IPresenterImpl miPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_griid);
        init();
    }

    private void init() {
        final RecyclerView recyclerView = findViewById(R.id.recycler_grild);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,mSpanCount);
        gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置布局管理器
        recyclerView.setLayoutManager(gridLayoutManager);
        gridAdpter =  new GridAdpter();
        recyclerView.setAdapter(gridAdpter);
        miPresenter = new IPresenterImpl( this);
        miPresenter.requestData(url,new HashMap<String, String>(),User.class);
        gridAdpter.setClickListener(new GridAdpter.Click() {
            @Override
            public void OnClick(int position) {
                Log.i("lgy",position+"");
                gridAdpter.remove(position);

            }
        });
    }

    @Override
    public void success(Object data) {
            User user = (User) data;
            gridAdpter.setmDatas(user.getData());
    }
}
