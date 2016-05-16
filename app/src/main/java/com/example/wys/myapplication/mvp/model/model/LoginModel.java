package com.example.wys.myapplication.mvp.model.model;


import com.example.wys.myapplication.mvp.model.presenter.ILoginPresenter;

/**
 * Created by wys on 2016/5/13.
 */
public class LoginModel {
    private ILoginPresenter iLoginPresenter;
    public LoginModel(ILoginPresenter iLoginPresenter) {
        this.iLoginPresenter=iLoginPresenter;
    }

    /**
     * 登录
     * @param userName
     * @param passWord
     */
    public void saveUserInfo(String userName, String passWord){
        LoginModelBean loginModelBean=new LoginModelBean();
        loginModelBean.setUserName(userName);
        loginModelBean.setPassWord(passWord);
        iLoginPresenter.loginSuccess(loginModelBean);
    }
}
