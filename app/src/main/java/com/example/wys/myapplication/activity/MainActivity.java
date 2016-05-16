package com.example.wys.myapplication.activity;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.example.wys.myapplication.Event.MyEvent;
import com.example.wys.myapplication.R;

import butterknife.Bind;
import de.greenrobot.event.EventBus;

public class MainActivity extends BaseTitleBarActivity {
    @Bind(R.id.btn_login)
    Button btn_login;
    @Bind(R.id.tv_data)
    TextView tv_data;
    @Bind(R.id.chronometer)
    Chronometer chronometer;

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ct, LoginActivity.class);
                startActivity(intent);
//                AnimationSet aa=new AnimationSet(true);
////                //添加透明度变换动画
//                AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
//                alphaAnimation.setDuration(3000);
////                //添加旋转动画
//                RotateAnimation rotateAnimation=new RotateAnimation(360,0,300,100);
//                rotateAnimation.setDuration(3000);
//                aa.addAnimation(rotateAnimation);
//
//                //位移动画
//                TranslateAnimation translateAnimation=new TranslateAnimation(200,0,0,0);
//                translateAnimation.setDuration(3000);
//                aa.addAnimation(translateAnimation);
//                //缩放动画
//                ScaleAnimation scaleAnimation=new ScaleAnimation(0,2,0,2);
//                scaleAnimation.setDuration(3000);
//                aa.addAnimation(scaleAnimation);
//                btn_login.startAnimation(aa);
            }
        });


    }
    public void onEventMainThread(MyEvent event) {
        tv_data.setText(event.getData());
    }

    private static final int NOTIFICATION_FLAG = 1;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void notificationMethod(View view) {
        // 在Android进行通知处理，首先需要重系统哪里获得通知管理器NotificationManager，它是一个系统Service。
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent;
        switch (view.getId()) {
            // 默认通知
            case R.id.btn1:
                PendingIntent pendingIntent1 = PendingIntent.getActivity(this, 0,
                        new Intent(this, MainActivity.class), 0);
                //使用通知推送消息
                Notification.Builder builder = new Notification.Builder(ct);
                //设置消息属性
                //必须设置的属性：小图标 标题 内容
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle("Bmob给您发送一条消息");
                builder.setContentText("祝您2016年行大运~！！！");
                builder.setContentIntent(pendingIntent1);
                //创建一个通知对象
                Notification notification = builder.build();
                notification.defaults=Notification.DEFAULT_SOUND;
                //使用通知管理器发送一条通知s
                NotificationManager managers = (NotificationManager) ct.getSystemService(Context.NOTIFICATION_SERVICE);
                managers.notify(1,notification);

                break;
            // 默认通知 API11及之后可用
            case R.id.btn2:
                PendingIntent pendingIntent2 = PendingIntent.getActivity(this, 0,
                        new Intent(this, MainActivity.class), 0);
                // 通过Notification.Builder来创建通知，注意API Level
                // API11之后才支持
                Notification notify2 = new Notification.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher) // 设置状态栏中的小图片，尺寸一般建议在24×24，这个图片同样也是在下拉状态栏中所显示，如果在那里需要更换更大的图片，可以使用setLargeIcon(Bitmap
                        // icon)
                        .setTicker("TickerText:" + "您有新短消息，请注意查收！")// 设置在status
                        // bar上显示的提示文字
                        .setContentTitle("Notification Title")// 设置在下拉status
                        // bar后Activity，本例子中的NotififyMessage的TextView中显示的标题
                        .setContentText("This is the notification message")// TextView中显示的详细内容
                        .setContentIntent(pendingIntent2) // 关联PendingIntent
                        .setNumber(1) // 在TextView的右方显示的数字，可放大图片看，在最右侧。这个number同时也起到一个序列号的左右，如果多个触发多个通知（同一ID），可以指定显示哪一个。
                        .getNotification(); // 需要注意build()是在API level
                // 16及之后增加的，在API11中可以使用getNotificatin()来代替
                notify2.flags |= Notification.FLAG_AUTO_CANCEL;
                manager.notify(NOTIFICATION_FLAG, notify2);
                break;
            // 默认通知 API16及之后可用
            case R.id.btn3:
                PendingIntent pendingIntent3 = PendingIntent.getActivity(this, 0,
                        new Intent(this, MainActivity.class), 0);
                // 通过Notification.Builder来创建通知，注意API Level
                // API16之后才支持
                Notification notify3 = new Notification.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setTicker("TickerText:" + "您有新短消息，请注意查收！")
                        .setContentTitle("Notification Title")
                        .setContentText("This is the notification message")
                        .setContentIntent(pendingIntent3).setNumber(1).build(); // 需要注意build()是在API
                // level16及之后增加的，API11可以使用getNotificatin()来替代
                notify3.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL表明当通知被用户点击时，通知将被清除。
                manager.notify(NOTIFICATION_FLAG, notify3);// 步骤4：通过通知管理器来发起通知。如果id不同，则每click，在status哪里增加一个提示
                break;
            // 自定义通知
            case R.id.btn4:
                // Notification myNotify = new Notification(R.drawable.message,
                // "自定义通知：您有新短信息了，请注意查收！", System.currentTimeMillis());
                Notification myNotify = new Notification();
                myNotify.icon = R.drawable.ic_launcher;
                myNotify.tickerText = "TickerText:您有新短消息，请注意查收！";
                myNotify.when = System.currentTimeMillis();
                myNotify.flags = Notification.FLAG_NO_CLEAR;// 不能够自动清除
                RemoteViews rv = new RemoteViews(getPackageName(),
                        R.layout.item);
                rv.setTextViewText(R.id.text_content, "hello wrold!");
                myNotify.contentView = rv;
                intent = new Intent(Intent.ACTION_MAIN);
                PendingIntent contentIntent = PendingIntent.getActivity(this, 1,
                        intent, 1);
                myNotify.contentIntent = contentIntent;
                manager.notify(NOTIFICATION_FLAG, myNotify);
                break;
            case R.id.btn5:
                // 清除id为NOTIFICATION_FLAG的通知
                manager.cancel(NOTIFICATION_FLAG);
                // 清除所有的通知
                // manager.cancelAll();
                break;
            case R.id.btn6:
                intent =new Intent(this,CardActivity.class);
                startActivity(intent);

                break;
            case R.id.btn7:
                intent =new Intent(this,DataBaseActivity.class);
                startActivity(intent);

                break;
            case R.id.btn8:
                intent =new Intent(this,EventActivity.class);
                intent.putExtra("time",chronometer.getText().toString());
                startActivity(intent);
                chronometer.stop();
                break;

        }
    }
    @Override
    protected void onResume() {
        super.onResume();

        chronometer.start();
        if (spUtil.getFirst()) {
            spUtil.setFirst(false);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void setView() {
        setContentView(R.layout.activity_main);
    }
}
