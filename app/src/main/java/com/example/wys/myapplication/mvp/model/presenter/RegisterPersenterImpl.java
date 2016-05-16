package com.example.wys.myapplication.mvp.model.presenter;

import com.example.wys.myapplication.mvp.model.model.RegisterModel;
import com.example.wys.myapplication.mvp.model.model.RegisterModelBean;
import com.example.wys.myapplication.mvp.model.view.RegisterView;

/**
 * Created by wys on 2016/5/13.
 */
public class RegisterPersenterImpl implements IRegisterPersenter {
    private RegisterModel registerModel;
    private RegisterView registerView;
    public RegisterPersenterImpl(RegisterView registerView) {
        this.registerView=registerView;
        registerModel=new RegisterModel(this);
    }

    @Override
    public void registerSuccess(RegisterModelBean registerModelBean) {
        registerView.registerSuccess(registerModelBean);
    }

    private void loadData(){
        registerModel.userRegister();
    }
}
