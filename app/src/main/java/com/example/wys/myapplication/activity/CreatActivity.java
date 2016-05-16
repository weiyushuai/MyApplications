package com.example.wys.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.wys.myapplication.R;

public class CreatActivity extends AppCompatActivity {
    Button btn_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat);
        btn_text= (Button) findViewById(R.id.btn_text);
        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CreatActivity.this,EventActivity.class);
                startActivity(intent);

            }
        });

        Log.d("debug","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("debug","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("debug","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("debug","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("debug","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("debug","onDestroy");
    }
}
