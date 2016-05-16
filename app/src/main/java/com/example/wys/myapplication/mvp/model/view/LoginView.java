package com.example.wys.myapplication.mvp.model.view;

import com.example.wys.myapplication.mvp.model.model.LoginModelBean;

/**
 * Created by wys on 2016/5/13.
 */
public interface LoginView {

    /**
     * @param loginBean
     * 展示数据
     */
    void login(LoginModelBean loginBean);
}
