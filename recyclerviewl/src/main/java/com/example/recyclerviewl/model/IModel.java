package com.example.recyclerviewl.model;

import com.example.recyclerviewl.callback.MyCallBack;

import java.util.Map;

public interface IModel {
    void requestData(String url, Map<String,String>prams, Class clazz, MyCallBack callBack);

}
