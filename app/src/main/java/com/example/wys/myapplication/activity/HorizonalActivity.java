package com.example.wys.myapplication.activity;

import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.wys.myapplication.R;
import com.example.wys.myapplication.util.ProgressView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import cn.finalteam.galleryfinal.widget.HorizontalListView;

public class HorizonalActivity extends BaseTitleBarActivity {
    @Bind(R.id.listview)
    HorizontalListView listview;
    Handler mHandler = new Handler();
    int position = 0;
    @Bind(R.id.ffff)
    ProgressView view;
    @Override
    protected void initView() {
        listview.setAdapter(mAdapter);

        final List<ProgressView.Model> models = new ArrayList<>();

        models.add(new ProgressView.Model("确认密码", ProgressView.STARTING));
        models.add(new ProgressView.Model("输入邮箱", ProgressView.AFTER));
        models.add(new ProgressView.Model("再次输入", ProgressView.AFTER));
        models.add(new ProgressView.Model("最终完成", ProgressView.AFTER));

        view.setData(models);


        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                models.get(position).state = ProgressView.BEFORE;
                models.get(position + 1).state = ProgressView.STARTING;
                position++;
                view.setData(models);
            }
        }, 3000);


    }
    private BaseAdapter mAdapter = new BaseAdapter() {

        private View.OnClickListener mOnButtonClicked = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ct);
                builder.setMessage("hello from " + v);
                builder.setPositiveButton("Cool", null);
                builder.show();

            }
        };

        @Override
        public int getCount() {
            return 2;
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
                convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_clean_step_item, null);
                vh.view_line=convertView.findViewById(R.id.view_line);
                vh.image_name= (ImageView) convertView.findViewById(R.id.image_name);
                convertView.setTag(vh);
            }else {
                vh= (ViewHolder) convertView.getTag();
            }

            return convertView;
        }
        class ViewHolder{
            View view_line;
            ImageView image_name;
        }

    };
    @Override
    protected void setView() {
        setContentView(R.layout.activity_horizonal);
    }
}
