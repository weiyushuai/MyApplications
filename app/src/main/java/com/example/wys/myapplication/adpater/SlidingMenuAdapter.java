package com.example.wys.myapplication.adpater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wys.myapplication.R;

import java.util.List;

/**
 * Created by wys on 2016/5/11.
 */
public class SlidingMenuAdapter extends MyBaseAdapter {
    private Context ct;
    private List<String> list;
    public SlidingMenuAdapter(Context ct,List<String> list) {
        super(ct,list);
        this.ct=ct;
        this.list=list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView==null){
            vh=new ViewHolder();
            convertView=View.inflate(ct, R.layout.menu_item,null);
            vh.tv_title= (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(vh);
        }else {
            vh= (ViewHolder) convertView.getTag();
        }
        vh.tv_title.setText(list.get(position));
        return convertView;
    }
    public class ViewHolder{
        private TextView tv_title;
    }
}
