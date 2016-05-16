package com.example.wys.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.example.wys.myapplication.R;
import com.example.wys.myapplication.application.MyApplication;
import com.example.wys.myapplication.bean.User;
import com.example.wys.myapplication.bean.UserDao;
import com.example.wys.myapplication.db.DBHelper;

import java.util.List;

public class DataBaseActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private MyApplication application;
    private UserDao userDao;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        textview= (TextView) findViewById(R.id.textview);
        application = MyApplication.getInstance();
        dbHelper = application.getDBHelper();
        userDao = dbHelper.getUserDao();
    }
    User user;
    public void dataBase(View v) {
        switch (v.getId()) {
            case R.id.add:
                //Long id, String url, String params, String cacheData
                user = new User(null, "张三", "24", "北京");
                userDao.insert(user);
                break;
            case R.id.delete:
                userDao.deleteByKey(user.getId());
                break;
            case R.id.update:
                user = new User(null, "李四", "30", "上海");
                userDao.update(user);
                break;
            case R.id.select:
                List<User> userList = userDao.loadAll();
                for (User users : userList) {
                     users.getCacheData();
                    textview.setText(users.getCacheData()+"----"+users.getParams()+"----"+users.getUrl());
                }
                break;
        }
    }
}
