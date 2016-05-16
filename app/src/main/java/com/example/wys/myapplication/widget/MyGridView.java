package com.example.wys.myapplication.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * ==========================================================
 * 
 * 版 权 ： 北京世纪云联科技发展有限公司 （c） 2015
 * 
 * 作 者 ：Growth
 * 
 * 版 本 ：1.0
 * 
 * 创建日期 ：2015-9-10 下午3:30:54
 * 
 * 描 述 ：解决嵌套在ScrollView中显示不全的问题
 * 
 * 
 * 修订历史：
 * 
 * ==========================================================
 **/
public class MyGridView extends GridView {
	public MyGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyGridView(Context context) {
		super(context);
	}

	public MyGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}
