package com.example.wys.myapplication.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.wys.myapplication.R;
import com.example.wys.myapplication.mvp.model.model.LoginModelBean;
import com.example.wys.myapplication.mvp.model.model.MainModelBean;
import com.example.wys.myapplication.mvp.model.model.RegisterModelBean;
import com.example.wys.myapplication.mvp.model.presenter.LoginPresenterImpl;
import com.example.wys.myapplication.mvp.model.presenter.MainPersenterImpl;
import com.example.wys.myapplication.mvp.model.presenter.RegisterPersenterImpl;
import com.example.wys.myapplication.mvp.model.view.LoginView;
import com.example.wys.myapplication.mvp.model.view.MainView;
import com.example.wys.myapplication.mvp.model.view.RegisterView;
import com.example.wys.myapplication.util.T;

import butterknife.Bind;

public class LoginActivity extends BaseTitleBarActivity implements LoginView, MainView, RegisterView {
    @Bind(R.id.btn_login)
    Button btn_login;
    @Bind(R.id.et_username)
    EditText et_username;
    @Bind(R.id.et_password)
    EditText et_password;
    LoginPresenterImpl loginPresenter;
    MainPersenterImpl mainPersenter;
    RegisterPersenterImpl registerPersenter;
    @Override
    protected void initView() {
        loginPresenter=new LoginPresenterImpl(this);
        mainPersenter=new MainPersenterImpl(this);
        mainPersenter.loadData();
        registerPersenter=new RegisterPersenterImpl(this);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=et_username.getText().toString();
                String passWord=et_password.getText().toString();
                loginPresenter.saveUserInfo(userName,passWord);
            }
        });
    }

    @Override
    protected void setView() {
        setContentView(R.layout.activity_login);
    }

    @Override
    public void login(LoginModelBean loginBean) {
        final String username=loginBean.getUserName();
        final String password=loginBean.getPassWord();
        if (!TextUtils.isEmpty(username)&&!TextUtils.isEmpty(password)){
            if ("123456".equals(username)&&"123456".equals(password)){
                Intent intent=new Intent(ct,CreatActivity.class);
                startActivity(intent);
            }else {
                T.s(ct,"账号或密码错误");
            }
        }else {
            T.s(ct,"请输入账号或者密码");
        }

    }

    @Override
    public void showData(MainModelBean.WeatherinfoBean modelBean) {
        T.s(ct,"城市"+modelBean.getCity()+"时间"+modelBean.getTime()+modelBean.getWD()+modelBean.getWS());
    }

    @Override
    public void registerSuccess(RegisterModelBean registerModelBean) {

    }
}
