package com.example.wys.myapplication.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.wys.myapplication.R;
import com.example.wys.myapplication.activity.HorizonalActivity;
import com.example.wys.myapplication.activity.LoginActivity;
import com.example.wys.myapplication.activity.MainActivity;
import com.example.wys.myapplication.activity.MyViewActivity;
import com.example.wys.myapplication.application.MyApplication;
import com.example.wys.myapplication.map.GaoDeMapActivity;
import com.example.wys.myapplication.util.T;
import com.example.wys.myapplication.util.UILImageLoader;

import java.util.List;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ThemeConfig;
import cn.finalteam.galleryfinal.model.PhotoInfo;

public class HomeFragment extends Fragment {
    Button btn_listview,btn_map,btn_photo,btn_text,btn_login,btn_view;

    private MyApplication app;
    protected static FunctionConfig functionConfig;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(),R.layout.activity_home_fragment,null);
        btn_text= (Button) view.findViewById(R.id.btn_text);
        btn_view= (Button) view.findViewById(R.id.btn_view);
        btn_photo= (Button) view.findViewById(R.id.btn_photo);
        btn_map= (Button) view.findViewById(R.id.btn_map);
        btn_listview= (Button) view.findViewById(R.id.btn_listview);
        btn_login= (Button) view.findViewById(R.id.btn_login);
        app=MyApplication.getInstance();
        initTheme();
        setClick();
        return view;
    }

    private void setClick() {
        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyViewActivity.class);
                startActivity(intent);
            }
        });
        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceImg();
            }
        });
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GaoDeMapActivity.class);
                startActivity(intent);
            }
        });
        btn_listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),HorizonalActivity.class);
                startActivity(intent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });
        /**
         * 有于系统裁剪个别手机不是正方形 故使用第三方裁剪
         * 对裁剪进行初始化配置
         * 具体配置请看
         * https://github.com/pengjianbo/GalleryFinal
         */
    }
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
        CoreConfig coreConfig = new CoreConfig.Builder(getActivity(), imageloader,themeConfig)
                .setFunctionConfig(functionConfig)
                .build();
        GalleryFinal.init(coreConfig);
    }
    /**
     * 选择相机
     * 0.拍照并截图,成功后会走onSucces
     */
    public void choiceImg() {
        new MaterialDialog.Builder(getActivity()).title("选择")
                .items(R.array.select_mode)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view,
                                            int which, CharSequence text) {
                        switch (which) {
                            case 0:
                                //拍照对图片进行裁剪(使用的第三方自定义裁剪)
                                GalleryFinal.openCamera(1001, functionConfig, mOnHanlderResultCallback);
                                //使用系统进行裁剪,由于华为手机裁剪为圆形.故注掉
//                                cameraProxy.getPhoto2CameraCrop("kuaipai.jpg");
                                break;
                            case 1:
                                //从相册对图片进行裁剪(使用的第三方自定义裁剪)
                                GalleryFinal.openGallerySingle(1001,functionConfig, mOnHanlderResultCallback);
//                                cameraProxy.getPhoto2AlbumCrop("kuaipai.jpg");
                                break;
                        }
                    }
                }).show();

    }

    private GalleryFinal.OnHanlderResultCallback mOnHanlderResultCallback = new GalleryFinal.OnHanlderResultCallback() {
        @Override
        public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
            if (resultList != null) {

            }
        }

        @Override
        public void onHanlderFailure(int requestCode, String errorMsg) {
            T.s(getActivity(), errorMsg);
        }
    };
}
