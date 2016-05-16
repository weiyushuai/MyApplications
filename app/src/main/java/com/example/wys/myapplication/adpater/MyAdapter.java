package com.example.wys.myapplication.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.wys.myapplication.R;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.abslistview.CommonAdapter;

import java.util.List;

/**
 * Created by wys on 2016/4/20.
 */
public class MyAdapter extends CommonAdapter {


    public MyAdapter(Context context, int layoutId, List datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(ViewHolder holder, Object o) {

    }
}
