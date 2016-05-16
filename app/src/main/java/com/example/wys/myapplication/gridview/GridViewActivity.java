package com.example.wys.myapplication.gridview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wys.myapplication.R;
import com.example.wys.myapplication.activity.BaseTitleBarActivity;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends BaseTitleBarActivity {
    private PageRecyclerView mRecyclerView = null;
    private List<String> dataList = null;
    private PageRecyclerView.PageAdapter myAdapter = null;
    @Override
    protected void initView() {
        initData();
        mRecyclerView = (PageRecyclerView) findViewById(R.id.cusom_swipe_view);
        // 设置指示器
        mRecyclerView.setIndicator((PageIndicatorView) findViewById(R.id.indicator));
        // 设置行数和列数
        mRecyclerView.setPageSize(3, 2);
        // 设置页间距
        mRecyclerView.setPageMargin(30);
        // 设置数据
        mRecyclerView.setAdapter(myAdapter = mRecyclerView.new PageAdapter(dataList, new PageRecyclerView.CallBack() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(ct).inflate(R.layout.grid_item, parent, false);
                return new MyHolder(view);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((MyHolder)holder).tv.setText(dataList.get(position));
            }
        }));
    }
    private void initData() {
        dataList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            dataList.add(String.valueOf(i));
        }
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        public TextView tv = null;

        public MyHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.text);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            tv.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    myAdapter.remove(getAdapterPosition());
                    return true;
                }
            });
        }
    }

    @Override
    protected void setView() {
        setContentView(R.layout.activity_grid_view);
    }


}
