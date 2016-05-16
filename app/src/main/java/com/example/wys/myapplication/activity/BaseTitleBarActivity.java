package com.example.wys.myapplication.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.example.wys.myapplication.application.MyApplication;
import com.example.wys.myapplication.db.DBHelper;
import com.example.wys.myapplication.util.SharedPreferenceUtil;
import com.example.wys.myapplication.util.UILImageLoader;


import butterknife.ButterKnife;
import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ThemeConfig;

public abstract class BaseTitleBarActivity extends FragmentActivity {
    protected MyApplication application;
    protected SharedPreferenceUtil spUtil;
    protected DBHelper dbhelper;
    protected Context ct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        this.ct=this;
        application=MyApplication.getInstance();
        dbhelper=application.getDBHelper();
        spUtil=SharedPreferenceUtil.getInstance(ct);
        ButterKnife.bind(this);
        initView();
    }

    protected abstract void initView();

    protected abstract void setView();
}
