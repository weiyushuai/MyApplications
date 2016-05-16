package com.example.wys.myapplication.activity;

import android.app.Dialog;
import android.content.Intent;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.wys.myapplication.Event.MyEvent;
import com.example.wys.myapplication.R;
import com.example.wys.myapplication.util.DialogUtils;
import com.example.wys.myapplication.util.T;

import butterknife.Bind;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class EventActivity extends BaseTitleBarActivity {
    @Bind(R.id.et_text)
    EditText et_text;
    String data;
    @Bind(R.id.event)
    Button event;
    @Bind(R.id.btn_broadCast)
    Button btn_broadCast;
    @Bind(R.id.chronometer)
    Chronometer chronometer;

    @Bind(R.id.tv_time)
    TextView tv_time;
    @Bind(R.id.btn_list)
    Button btn_list;

    @Bind(R.id.btn_dialog)
    Button btn_dialog;

    @OnClick(R.id.btn_dialog)
    void showDialog(){
        DialogUtils.getAskDialog(ct, "您确定要打开吗?", new MaterialDialog.ButtonCallback() {
            @Override
            public void onPositive(MaterialDialog dialog) {
                super.onPositive(dialog);
                T.s(ct,"onPositive");
            }

            @Override
            public void onNegative(MaterialDialog dialog) {
                super.onNegative(dialog);
                T.s(ct,"onNegative");
            }
        });
//        DialogUtils.getNewLoadingDialog(this);
//        Dialog dialog=new Dialog(ct, R.style.Dialog);
//        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.setContentView(R.layout.dialog);
//
//        WindowManager windowManager = getWindowManager();
//        Display display = windowManager.getDefaultDisplay();
//        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
//        lp.width = display.getWidth(); //设置宽度
//        dialog.getWindow().setAttributes(lp);
//        dialog.show();
    }

    @Bind(R.id.btn_activity)
    Button btn_activity;

    @Override
    protected void initView() {
        tv_time.setText(getIntent().getStringExtra("time"));
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //data=et_text.getText().toString().trim();

                    data=chronometer.getText().toString().trim();
                    EventBus.getDefault().post(new MyEvent(data));
                    finish();
                    chronometer.stop();

            }
        });

        btn_broadCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ct,ListActivity.class);
                startActivity(intent);
            }
        });
        btn_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ct,CreatActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        chronometer.start();
    }

    @Override
    protected void setView() {
        setContentView(R.layout.activity_event);
    }
}
