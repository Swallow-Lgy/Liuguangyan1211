package com.example.recyclerviewl.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.recyclerviewl.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.linear).setOnClickListener(this);
        findViewById(R.id.grid).setOnClickListener(this);
        findViewById(R.id.flow).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        int id = v.getId();
        switch (id){
            case R.id.linear:
              intent.setClass(this,LinaerActivity.class);
              break;
            case R.id.grid:
                intent.setClass(this,GrildActivity.class);
                break;
            case R.id.flow:
            intent.setClass(this,FlowActivity.class);
            break;
            default:
                break;
        }
        startActivity(intent);
    }
}
