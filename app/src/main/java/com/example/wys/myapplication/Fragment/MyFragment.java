package com.example.wys.myapplication.Fragment;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wys.myapplication.R;
import com.example.wys.myapplication.activity.MainActivity;
import com.example.wys.myapplication.util.T;
import com.example.wys.myapplication.widget.PullToZoomListView;
import com.example.wys.myapplication.widget.PullToZoomScrollView;

public class MyFragment extends Fragment {
    private PullToZoomListView listView;
    private PullToZoomScrollView scrollView;
    private ImageView iv_image;
    private String[] adapterData;
    private TextView tv_title;
    private int imageHeight;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(),R.layout.activity_my_fragment,null);
        initData(view);
        initListeners();
        return view;
    }

    private void initListeners() {
        new ImageView(getActivity());
        // 获取顶部图片高度后，设置滚动监听
        ViewTreeObserver vto = iv_image.getViewTreeObserver();
        //当在一个视图树中全局布局发生改变或者视图树中的某个视图的可视状态发生改变时，所要调用的回调函数的接口类
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                iv_image.getViewTreeObserver().removeGlobalOnLayoutListener(
                        this);
                imageHeight = iv_image.getHeight();

                scrollView.setScrollViewListener(new PullToZoomScrollView.ScrollViewListener() {
                    @Override
                    public void onScrollChanged(PullToZoomScrollView scrollView, int x, int y, int oldx, int oldy) {
                        if (y <= 0) {
                            tv_title.setBackgroundColor(Color.TRANSPARENT);//AGB由相关工具获得，或者美工提供
                        } else if (y > 0 && y <= imageHeight) {
                            float scale = (float) y / imageHeight;
                            float alpha = (255 * scale);
                            /**
                             * 只是layout背景透明
                             * 设置滑动变色
                             */
                            tv_title.setBackgroundColor(Color.argb((int) alpha, 128, 138, 135));
                        } else {
                            tv_title.setBackgroundColor(Color.argb((int)220, 128, 138, 135));
                        }
                    }
                });
            }
        });

    }

    private void initData(View view) {
        listView = (PullToZoomListView)view.findViewById(R.id.listview);
        scrollView = (PullToZoomScrollView) view.findViewById(R.id.scrollView);
        iv_image = (ImageView) view.findViewById(R.id.iv_image);
        tv_title= (TextView) view.findViewById(R.id.tv_title);

//        adapterData = new String[] { "Activity","Service","Content Provider","Intent","BroadcastReceiver","ADT","Sqlite3","HttpClient","DDMS","Android Studio","Fragment","Loader" };
//
//        listView.setAdapter(new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_list_item_1, adapterData));
//        listView.getHeaderView().setImageResource(R.mipmap.fore);
//        listView.getHeaderView().setScaleType(ImageView.ScaleType.CENTER_CROP);

    }

}
