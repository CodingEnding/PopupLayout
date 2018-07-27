package com.codingending.popuplayout;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

/**
 * 弹出窗体的辅助类
 * Created by CodingEnding on 2018/7/24.
 */
public class PopupLayout {
    private static final String TAG="PopupLayout";
    private static PopupDialog mPopupDialog;//使用到的对话框

    public static int POSITION_LEFT=Gravity.LEFT;//从最左侧弹出
    public static int POSITION_RIGHT=Gravity.RIGHT;//右侧
    public static int POSITION_CENTER=Gravity.CENTER;//从中间浮现
    public static int POSITION_TOP=Gravity.TOP;//从顶部弹出
    public static int POSITION_BOTTOM=Gravity.BOTTOM;//从底部弹出

    private PopupLayout(){}

    /**
     * 初始化PopLayout
     * @param context
     * @param contentLayoutId 内容布局Id
     */
    public static void init(Context context,@LayoutRes int contentLayoutId){
        mPopupDialog=new PopupDialog(context);
        mPopupDialog.setContentLayout(contentLayoutId);
    }

    /**
     * 初始化PopLayout
     * @param context
     * @param contentView 内容布局
     */
    public static void init(Context context,View contentView){
        mPopupDialog=new PopupDialog(context);
        mPopupDialog.setContentLayout(contentView);
    }

    /**
     * 设置是否使用圆角特性
     */
    public static void setUseRadius(boolean useRadius){
        mPopupDialog.setUseRadius(useRadius);
    }

    /**
     * 默认从底部弹出
     */
    public static void show(){
        show(POSITION_LEFT);
    }

    /**
     * 从指定位置弹出/显示
     * @param position 指定位置
     */
    public static void show(int position){
        if(mPopupDialog==null){
            Log.e(TAG,"Dialog init error,it's null");
            return;
        }
        mPopupDialog.setWindowGravity(position);
        mPopupDialog.show();
    }

    /**
     * 隐藏对话框
     */
    public static void hide(){
        if(mPopupDialog!=null){
            mPopupDialog.hide();
        }
    }

}
