package com.example.dell.liuguangyan1211.model;

import android.telecom.Call;

import com.example.dell.liuguangyan1211.callback.MyCallBack;
import com.example.dell.liuguangyan1211.util.ICall;
import com.example.dell.liuguangyan1211.util.OkUtil;

import java.util.HashMap;

public class IModelImpl implements IModel{
    @Override
    public void requestData(String url, Class clazz, final Call callBack) {
        OkUtil.getmInstance().postEnququ(url, new HashMap<String, String>(), clazz, new ICall() {
            @Override
            public void success(Object data) {

            }

            @Override
            public void file(Object data) {

            }
        });
    }
}
