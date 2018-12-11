package com.example.recyclerviewl.model;

import com.example.recyclerviewl.callback.MyCallBack;
import com.example.recyclerviewl.util.ICallBack;
import com.example.recyclerviewl.util.OkHttpUtil;

import java.util.HashMap;
import java.util.Map;

public class IModerImpl implements IModel{

    @Override
    public void requestData(String url, Map<String,String>parma, Class clazz, final MyCallBack callBack) {
        OkHttpUtil.getmInstance().postEnqueue(url, new HashMap<String, String>(), new ICallBack() {
            @Override
            public void success(Object data) {
                 callBack.setData(data);
            }

            @Override
            public void failed(Exception e) {
                callBack.setData(e);
            }
        },clazz);
    }
}
