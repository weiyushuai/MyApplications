package com.example.wys.myapplication.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wys.myapplication.R;
import com.example.wys.myapplication.adpater.ViewPagerAdapter;
import com.example.wys.myapplication.widget.ColorAnimationView;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class GuideActivity extends BaseTitleBarActivity {
    @Bind(R.id.viewPager)
    public ViewPager viewPager;
    @Bind(R.id.colorView)
    public ColorAnimationView colorView;
    @Bind(R.id.cpi)
    CirclePageIndicator cpi;

    private ViewPagerAdapter adapter;
    private List<View> views;
    private boolean misScrolled;

    private static final int[] resource = new int[]{R.mipmap.welcome1, R.mipmap.welcome4,
            R.mipmap.welcome3, R.mipmap.welcome4};

    @Override
    protected void initView() {
        views = new ArrayList<View>();

        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        //初始化引导图片列表
        for(int i=0; i<resource.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(mParams);
            iv.setImageResource(resource[i]);
            views.add(iv);
        }
        //初始化Adapter
        adapter = new ViewPagerAdapter(views);
        viewPager.setAdapter(adapter);
        cpi.setViewPager(viewPager);
        colorView.setmViewPager(viewPager, resource.length);

        colorView.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        misScrolled = false;
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        misScrolled = true;
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        if (viewPager.getCurrentItem() == viewPager.getAdapter().getCount() - 1 && !misScrolled) {
                            startActivity(new Intent(ct, MainActivity.class));
                            GuideActivity.this.finish();
                        }
                        misScrolled = true;
                        break;
                }

            }
        });
    }

    @Override
    protected void setView() {
        setContentView(R.layout.activity_guide);
    }
}
