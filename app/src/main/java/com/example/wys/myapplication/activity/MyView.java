package com.example.wys.myapplication.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wys on 2016/4/21.
 */
public class MyView extends View {
    private Paint paint;
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
//        canvas.drawRect(0,100,getHeight()/2,getWidth(),paint);
//        canvas.drawCircle(1f,1f,1f,paint);
        canvas.drawCircle(350, 550, 100, paint);// 圆
        paint.setAntiAlias(true);// 设置画笔的锯齿效果.
        paint.setColor(Color.YELLOW);
        paint.setTextSize(36);
        String text="hello word";
        canvas.drawText(text,getWidth()/3,getHeight()/2,paint);

        canvas.drawText("画线及弧线：", 10, 60, paint);
        paint.setColor(Color.GREEN);// 设置绿色
        paint.setStrokeWidth(5);
        canvas.drawLine(getRight(), 0, 350, 550, paint);//右上
        canvas.drawLine(getLeft(), 0, 350, 550, paint);// 左上
        canvas.drawLine(getLeft(),getHeight(), 350, 550, paint);// 左下
        canvas.drawLine(getRight()-200,getHeight()-200, 350, 550, paint);// 右下


        paint.setColor(Color.YELLOW);
        canvas.drawCircle(getRight()-200,getHeight()-200, 100, paint);// 圆
        paint.setAntiAlias(true);// 设置画笔的锯齿效果

        paint.setColor(Color.YELLOW);
        canvas.drawCircle(getRight()-100,getWidth(), 80, paint);// 圆
        paint.setAntiAlias(true);// 设置画笔的锯齿效果

    }
}
