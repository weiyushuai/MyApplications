package com.example.wys.myapplication.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.InputType;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.example.wys.myapplication.R;


public class DialogUtils {

    private static Theme dialogTheme = Theme.LIGHT;

	private DialogUtils() {
	}

    public static void getNeutralDialog(Context ct, String title,String tip,
                                        MaterialDialog.ButtonCallback callback) {
        if (ct == null || TextUtils.isEmpty(tip)) {
            return;
        }
        new MaterialDialog.Builder(ct).title(title).content(tip)
                .positiveText(R.string.check).negativeText(R.string.complete)
                .neutralText(R.string.cancel).callback(callback).show();
    }

    /**
     * @param ct
     * @param tip
     *            提示内容
     * @param callback
     */
    public static void getInputDialog(Context ct, String tip,
                                      MaterialDialog.InputCallback callback) {
        if (ct == null) {
            return;
        }
        new MaterialDialog.Builder(ct).content(tip)
                .positiveText(R.string.confirm).input("", "", false, callback)
                .negativeText(R.string.cancel).show();
    }

    /**
     * @param ct
     * @param tipRes
     *            提示内容资源id
     * @param callback
     */
    public static void getInputDialog(Context ct, int tipRes,
                                      MaterialDialog.InputCallback callback) {
        if (ct == null) {
            return;
        }
        new MaterialDialog.Builder(ct).content(tipRes)
                .positiveText(R.string.confirm).input("", "", false, callback)
                .negativeText(R.string.cancel).show();
    }

    public static void getInputNumberDialog(Context ct, int tipRes,
                                            int maxLength, MaterialDialog.InputCallback callback) {
        if (ct == null) {
            return;
        }
        new MaterialDialog.Builder(ct).content(tipRes)
                .inputType(InputType.TYPE_CLASS_NUMBER)
                .inputMaxLength(maxLength).positiveText(R.string.confirm)
                .input("", "", false, callback).negativeText(R.string.cancel)
                .show();
    }
    public static void getInputRemarkDialog(Context ct, int tipRes,
                                            int maxLength, MaterialDialog.InputCallback callback) {
        if (ct == null) {
            return;
        }
        new MaterialDialog.Builder(ct).content(tipRes)
                .inputMaxLength(maxLength).positiveText(R.string.confirm)
                .input("", "", false, callback).negativeText(R.string.cancel)
                .show();
    }

    /**
     * @param ct
     * @param tip
     *            提示文字
     * @param content
     *            输入框内容
     * @param callback
     *            回调
     */
    public static void getInputDialog(Context ct, String tip, String content,
                                      MaterialDialog.InputCallback callback) {
        if (ct == null) {
            return;
        }
        new MaterialDialog.Builder(ct).content(tip)
                .positiveText(R.string.confirm)
                .input("", content, false, callback)
                .negativeText(R.string.cancel).show();
    }

    public static void getInputDialog(Context ct, int tipRes, String content,
                                      MaterialDialog.InputCallback callback) {
        if (ct == null) {
            return;
        }
        new MaterialDialog.Builder(ct).content(tipRes)
                .positiveText(R.string.confirm)
                .input("", content, false, callback)
                .negativeText(R.string.cancel).show();
    }


    /**
     * 获取加载中对话框
     */
    public static MaterialDialog getLoadingDialog(Context ct) {
        if (ct == null) {
            return null;
        }
        MaterialDialog dialog = new MaterialDialog.Builder(ct)
                .title(R.string.please_wait).content(R.string.loading)
                .progress(true, 0).progressIndeterminateStyle(false).build();
        return dialog;
    }

    /**
     * 返回提示对话框
     */
    public static void getTipDialog(Context ct, String content,
                                    MaterialDialog.ButtonCallback callback) {
        if (ct == null || TextUtils.isEmpty(content)) {
            return;
        }
        MaterialDialog dialog = new MaterialDialog.Builder(ct)
                .theme(dialogTheme).content(content).callback(callback)
                .positiveText(R.string.confirm).build();
        dialog.setCancelable(false);
        dialog.show();
    }

    /**
     * 自定义布局Dialog
     */
    public static void getMyDialog(Context ct, String content,
                                    MaterialDialog.ButtonCallback callback) {
        if (ct == null || TextUtils.isEmpty(content)) {
            return;
        }
        MaterialDialog dialog = new MaterialDialog.Builder(ct)
                .theme(dialogTheme).customView(R.layout.dialog,false).positiveText(R.string.confirm).callback(callback)
                .build();
        dialog.setCancelable(false);
        dialog.show();
    }

    /**
     * 返回询问对话框
     */
    public static void getAskDialog(Context ct, String content,
                                    MaterialDialog.ButtonCallback callback) {
        if (ct == null || TextUtils.isEmpty(content)) {
            return;
        }
        MaterialDialog dialog = new MaterialDialog.Builder(ct)
                .theme(dialogTheme).negativeColor(0xff0077ff).positiveColor(0xff0077ff).content(content)
                .positiveText(R.string.confirm).negativeText(R.string.cancel)
                .callback(callback).build();
        dialog.setCancelable(false);
        dialog.show();
    }
    /**
     * 返回家人添加对话框
     */
    public static void getFriendsDialog(Context ct, String content,
                                        MaterialDialog.ButtonCallback callback) {
        if (ct == null || TextUtils.isEmpty(content)) {
            return;
        }
        MaterialDialog dialog = new MaterialDialog.Builder(ct)
                .theme(dialogTheme).content(content)
                .positiveText(R.string.consent).negativeText(R.string.reject)
                .callback(callback).build();
        dialog.setCancelable(false);
        dialog.show();
    }

    public static void getAskDialog(Context ct, int contentRes,
                                    MaterialDialog.ButtonCallback callback) {
        if (ct == null) {
            return;
        }
        MaterialDialog dialog = new MaterialDialog.Builder(ct)
                .theme(dialogTheme).content(contentRes)
                .positiveText(R.string.confirm).negativeText(R.string.cancel)
                .callback(callback).build();
        dialog.setCancelable(false);
        dialog.show();
    }

    public static void getListNoTitleDialog(Context ct, int itemsRes,
                                            MaterialDialog.ListCallback callback) {
        new MaterialDialog.Builder(ct).items(itemsRes).itemsCallback(callback)
                .show();
    }

    /**
     * 返回列表对话框
     */
    public static void getListDialog(Context ct, int titleRes, int itemsRes,
                                     MaterialDialog.ListCallback callback) {
        new MaterialDialog.Builder(ct).title(titleRes).items(itemsRes)
                .itemsCallback(callback).show();
    }

    /**
     * 返回列表对话框
     */
    public static void getListDialog(Context ct, CharSequence title,
                                     CharSequence[] items, MaterialDialog.ListCallback callback) {
        new MaterialDialog.Builder(ct).title(title).items(items)
                .itemsCallback(callback).show();
    }

    public static Dialog getNewLoadingDialog(Activity context) {
        final Dialog dialog = new Dialog(context, R.style.Dialog);
        dialog.setContentView(R.layout.dialog_loading);
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        int screenW = getScreenWidth(context);
        lp.width = (int) (0.6 * screenW);
        return dialog;
    }

    public static int getScreenWidth(Activity context) {
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    public static int getScreenHeight(Activity context) {
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }
}
