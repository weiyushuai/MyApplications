package com.example.wys.myapplication.map;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.PolylineOptions;
import com.example.wys.myapplication.R;
import com.example.wys.myapplication.activity.BaseTitleBarActivity;

import butterknife.Bind;

public class GaoDeMapActivity extends BaseTitleBarActivity {
    @Bind(R.id.mapView)
    MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mapView.onCreate(savedInstanceState);// 此方法必须重写
    }

    @Override
    protected void initView() {
        AMap aMap = mapView.getMap();

        aMap.setTrafficEnabled(true);// 显示实时交通状况
        //地图模式可选类型：MAP_TYPE_NORMAL,MAP_TYPE_SATELLITE,MAP_TYPE_NIGHT
        aMap.setMapType(AMap.MAP_TYPE_NORMAL);// 卫星地图模式

        //绘制marker
        Marker marker = aMap.addMarker(new MarkerOptions()
                .position(new LatLng(39.986919,116.353369))
                .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                        .decodeResource(getResources(),R.drawable.ic_delete_photo)))
                .draggable(true));

        // 绘制曲线
        aMap.addPolyline((new PolylineOptions())
                .add(new LatLng(43.828, 87.621), new LatLng(45.808, 126.55))
                .geodesic(true).color(Color.RED));


    }

    @Override
    protected void setView() {
        setContentView(R.layout.activity_gao_de_map);
    }
}
