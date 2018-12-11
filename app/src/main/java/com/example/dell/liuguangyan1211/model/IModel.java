package com.example.dell.liuguangyan1211.model;

import android.telecom.Call;

import com.example.dell.liuguangyan1211.callback.MyCallBack;

public interface IModel {
    void requestData(String url, Class clazz, Call callBack);
}
