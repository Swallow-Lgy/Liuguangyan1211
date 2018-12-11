package com.example.recyclerviewl.presenter;

import com.example.recyclerviewl.callback.MyCallBack;
import com.example.recyclerviewl.model.IModerImpl;
import com.example.recyclerviewl.view.IView;

import java.util.Map;

public class IPresenterImpl implements IPresenter {
    private IView miView;
    private IModerImpl miModer;
    public IPresenterImpl(IView iView){
        miView = iView;
        miModer = new IModerImpl();
    }
    @Override
    public void requestData(String url, Map<String,String>prams , Class clazz) {
            miModer.requestData(url,prams ,clazz, new MyCallBack() {
                @Override
                public void setData(Object data) {
                   miView.success(data);
                }
            });
    }
}
