package com.example.wys.myapplication.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.example.wys.myapplication.R;
import com.example.wys.myapplication.application.MyApplication;

import butterknife.Bind;

public class CardActivity extends BaseTitleBarActivity {
    int[] images={R.mipmap.fore,R.mipmap.fore,R.mipmap.fore,R.mipmap.fore,R.mipmap.fore,R.mipmap.fore,R.mipmap.fore,R.mipmap.fore};

    @Bind(R.id.recycler_view)
    RecyclerView recycler_view;

    @Bind(R.id.list_view)
    GridView list_view;
    @Bind(R.id.refresh)
    MaterialRefreshLayout refresh;

    @Override
    protected void initView() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recycler_view.setLayoutManager(mLayoutManager);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        RecyclerAdapter adpater=new RecyclerAdapter();
        recycler_view.setAdapter(adpater);
        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(30);
        recycler_view.addItemDecoration(decoration);
        adpater.setOnItemClickListener(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Log.d("debug","点击的是"+postion);
            }
        });
        list_view.setAdapter(new MyAdapter());
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        refresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {

            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {

            }
        });
        refresh.finishRefresh();
        refresh.finishRefreshLoadMore();
    }



    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder vh;
            if (convertView==null){
                vh=new ViewHolder();
                convertView=View.inflate(CardActivity.this, R.layout.card_item, null);
                vh.imageView= (ImageView) findViewById(R.id.imageView);
                convertView.setTag(vh);
            }else {
                vh= (ViewHolder) convertView.getTag();
            }
            vh.imageView.setBackgroundResource(images[position]);
            return convertView;
        }
        private class ViewHolder{
            private ImageView imageView;
        }
    }
    private class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
        MyItemClickListener mItemClickListener;

        @Override
        public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewHolder vh=new ViewHolder(View.inflate(CardActivity.this, R.layout.card_item, null),mItemClickListener);
            return vh;
        }

        @Override
        public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
            if (holder.imageView!=null){
                holder.imageView.setBackgroundResource(images[position]);
            }

        }
        /**
         * 设置Item点击监听
         * @param listener
         */
        public void setOnItemClickListener(MyItemClickListener listener){
            this.mItemClickListener = listener;
        }
        @Override
        public int getItemCount() {
            return images==null?0:images.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private ImageView imageView;
            private  MyItemClickListener mListener;
            public ViewHolder(View itemView,MyItemClickListener mListener) {
                super(itemView);
                this.mListener=mListener;
                imageView= (ImageView) findViewById(R.id.imageView);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                if(mListener != null){
                    mListener.onItemClick(v,getPosition());
                }
            }

        }

    }
    public interface MyItemClickListener {
         void onItemClick(View view,int postion);
    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpacesItemDecoration(int space) {
            this.space=space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left=space;
            outRect.right=space;
            outRect.bottom=space;

        }
    }

    @Override
    protected void setView() {
        setContentView(R.layout.activity_card);
    }
}
