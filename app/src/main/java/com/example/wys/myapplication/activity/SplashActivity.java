package com.example.wys.myapplication.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wys.myapplication.R;

public class SplashActivity extends BaseTitleBarActivity {

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 100:
                    Intent intent = new Intent(SplashActivity.this,
                            Main2Activity.class);
                    startActivity(intent);
                    finish();
                    break;
            }
        };
    };
    @Override
    protected void initView() {
        mHandler.sendEmptyMessageDelayed(100, 3000);
    }

    @Override
    protected void setView() {
        setContentView(R.layout.activity_splash);
    }
}
