package com.example.dell.liuguangyan1211.presenter;

import com.example.dell.liuguangyan1211.callback.MyCallBack;
import com.example.dell.liuguangyan1211.model.IModel;
import com.example.dell.liuguangyan1211.model.IModelImpl;
import com.example.dell.liuguangyan1211.util.ICall;
import com.example.dell.liuguangyan1211.view.IView;

public class IPresenterImpl  implements IPresenter {
    private IView iView;
    private IModelImpl iModel;
    public IPresenterImpl(IView iView){
        iView = iView;
        iModel = new IModelImpl();
    }
    @Override
    public void requestData(String url, Class clazz) {

    }
}
