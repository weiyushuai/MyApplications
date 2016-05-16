package com.example.wys.myapplication.mvp.model.model;

import com.example.wys.myapplication.mvp.model.presenter.IRegisterPersenter;

/**
 * Created by wys on 2016/5/13.
 */
public class RegisterModel {
    private IRegisterPersenter registerPersenter;

    public RegisterModel(IRegisterPersenter registerPersenter) {
        this.registerPersenter = registerPersenter;
    }

    public void userRegister() {
        RegisterModelBean registerModelBean=new RegisterModelBean();
        registerPersenter.registerSuccess(registerModelBean);
    }
}
