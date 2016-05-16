package com.example.wys.myapplication.application;

import android.app.Application;
import android.graphics.Color;

import com.example.wys.myapplication.db.DBHelper;
import com.example.wys.myapplication.util.HttpUtils;
import com.example.wys.myapplication.util.SharedPreferenceUtil;
import com.example.wys.myapplication.util.UILImageLoader;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ThemeConfig;

/**
 * Created by wys on 2016/4/14.
 */
public class MyApplication extends Application{
    private static MyApplication application;
    private DBHelper dbHelper;
    private static SharedPreferenceUtil mSpUtil;
    protected static FunctionConfig functionConfig;

    @Override
    public void onCreate() {
        super.onCreate();
        this.application=this;
        HttpUtils.WEB_USER_AGENT=HttpUtils.getUA(application);
        mSpUtil = SharedPreferenceUtil.getInstance(this);
        initTheme();
    }

    public synchronized DBHelper getDBHelper() {
        if (dbHelper == null)
            dbHelper=new DBHelper(application,"wys.db");
        return dbHelper;
    }
    public static FunctionConfig getFunction(){
        return functionConfig;
    }
    /**
     * 有于系统裁剪个别手机不是正方形 故使用第三方裁剪
     * 对裁剪进行初始化配置
     * 具体配置请看
     * https://github.com/pengjianbo/GalleryFinal
     */
    protected void initTheme(){
        //配置功能
        functionConfig = new FunctionConfig.Builder()
                .setEnableCamera(false)
                .setEnableEdit(true)
                .setEnableCrop(true)
                .setEnableRotate(true)
                .setCropSquare(true)
                .setEnablePreview(false)
                .setForceCrop(true)
                .build();
        //黑色主题
        ThemeConfig themeConfig = new ThemeConfig.Builder()
                .setTitleBarBgColor(Color.rgb(0x38, 0x42, 0x48))
                .setFabNornalColor(Color.rgb(0x38, 0x42, 0x48))
                .setFabPressedColor(Color.rgb(0x20, 0x25, 0x28))
                .setCheckSelectedColor(Color.rgb(0x38, 0x42, 0x48))
                .setCropControlColor(Color.rgb(0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF))
                .build();
        //配置imageloader
        cn.finalteam.galleryfinal.ImageLoader imageloader = new UILImageLoader();
        CoreConfig coreConfig = new CoreConfig.Builder(application, imageloader,themeConfig)
                .setFunctionConfig(functionConfig)
                .build();
        GalleryFinal.init(coreConfig);
    }
    public synchronized static MyApplication getInstance() {
        return application;
    }

    public static SharedPreferenceUtil getmSpUtil() {
        if (mSpUtil == null)
            mSpUtil = SharedPreferenceUtil.getInstance(application);
        return mSpUtil;
    }

    public static Application getApplication(){
        return application;
    }
}
