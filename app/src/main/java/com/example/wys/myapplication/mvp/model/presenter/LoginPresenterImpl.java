package com.example.wys.myapplication.mvp.model.presenter;

import android.content.Context;

import com.example.wys.myapplication.mvp.model.model.LoginModel;
import com.example.wys.myapplication.mvp.model.model.LoginModelBean;
import com.example.wys.myapplication.mvp.model.view.LoginView;

/**
 * Created by wys on 2016/5/13.
 */
public class LoginPresenterImpl implements ILoginPresenter {
    private LoginView loginView;
    private LoginModel loginModel;
    public LoginPresenterImpl(LoginView loginView) {
        this.loginView=loginView;
        loginModel=new LoginModel(this);
    }

    @Override
    public void loginSuccess(LoginModelBean loginModelBean) {
        loginView.login(loginModelBean);
    }

    public void saveUserInfo(String userName, String passWord) {
        loginModel.saveUserInfo(userName,passWord);
    }

}
