package com.codingending.popuplayout;

import android.content.Context;
import android.content.DialogInterface;
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
    private PopupDialog mPopupDialog;//内部使用的Dialog
    private DismissListener mDismissListener;//监听弹出窗口的消失事件

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
    public static PopupLayout init(Context context,@LayoutRes int contentLayoutId){
        PopupLayout popupLayout=new PopupLayout();
        popupLayout.mPopupDialog=new PopupDialog(context);
        popupLayout.mPopupDialog.setContentLayout(contentLayoutId);
        popupLayout.initListener();
        return popupLayout;
    }

    /**
     * 初始化PopLayout
     * @param context
     * @param contentView 内容布局
     */
    public static PopupLayout init(Context context,View contentView){
        PopupLayout popupLayout=new PopupLayout();
        popupLayout.mPopupDialog=new PopupDialog(context);
        popupLayout.mPopupDialog.setContentLayout(contentView);
        popupLayout.initListener();
        return popupLayout;
    }

    //初始化Dialog监听器
    private void initListener(){
        mPopupDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if(mDismissListener!=null){
                    mDismissListener.onDismiss();
                }
            }
        });
    }

    /**
     * 设置是否使用圆角特性
     */
    public void setUseRadius(boolean useRadius){
        if(mPopupDialog!=null){
            mPopupDialog.setUseRadius(useRadius);
        }
    }

    /**
     * 默认从底部弹出
     */
    public void show(){
        show(POSITION_BOTTOM);
    }

    /**
     * 从指定位置弹出/显示
     * @param position 指定位置
     */
    public void show(int position){
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
    public void hide(){
        if(mPopupDialog!=null){
            mPopupDialog.hide();
        }

    }

    /**
     * 设置弹出布局消失的监听器
     * @param dismissListener 监听器
     */
    public void setDismissListener(DismissListener dismissListener){
        this.mDismissListener=dismissListener;
    }

    //监听弹出窗口消失事件的监听器
    public interface DismissListener{
        void onDismiss();
    }

}
