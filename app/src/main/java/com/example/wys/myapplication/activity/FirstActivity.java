package com.example.wys.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wys.myapplication.R;
import com.example.wys.myapplication.application.MyApplication;

public class FirstActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent;
        if (MyApplication.getmSpUtil().getFirst()) {
            intent = new Intent(FirstActivity.this, GuideActivity.class);
        } else {
            intent = new Intent(FirstActivity.this, SplashActivity.class);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        this.finish();
    }

}
