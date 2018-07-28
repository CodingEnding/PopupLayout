package com.codingending.popuplayout.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.codingending.popuplayout.PopupLayout;

/**
 * @author CodingEnding
 */
public class MainActivity extends AppCompatActivity {
    private boolean useRadius=true;//是否使用圆角特性

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupLayout popupLayout=PopupLayout.init(MainActivity.this, R.layout.layout_left);
                popupLayout.setUseRadius(useRadius);
                popupLayout.show(PopupLayout.POSITION_LEFT);
            }
        });
        findViewById(R.id.btn_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupLayout popupLayout=PopupLayout.init(MainActivity.this, R.layout.layout_right);
                popupLayout.setUseRadius(useRadius);
                popupLayout.show(PopupLayout.POSITION_RIGHT);
            }
        });
        findViewById(R.id.btn_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupLayout popupLayout=PopupLayout.init(MainActivity.this, R.layout.layout_top);
                popupLayout.setUseRadius(useRadius);
                popupLayout.show(PopupLayout.POSITION_TOP);
            }
        });
        findViewById(R.id.btn_bottom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupLayout popupLayout=PopupLayout.init(MainActivity.this, R.layout.layout_bottom);
                popupLayout.setUseRadius(useRadius);
                popupLayout.setDismissListener(new PopupLayout.DismissListener() {
                    @Override
                    public void onDismiss() {
                        Toast.makeText(MainActivity.this,"弹出窗口关闭",Toast.LENGTH_SHORT).show();
                    }
                });
                popupLayout.show(PopupLayout.POSITION_BOTTOM);
            }
        });
        findViewById(R.id.btn_center).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupLayout popupLayout=PopupLayout.init(MainActivity.this,R.layout.layout_center);
                popupLayout.setUseRadius(useRadius);
                popupLayout.show(PopupLayout.POSITION_CENTER);
            }
        });
        ((CheckBox)findViewById(R.id.checkbox_radius)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                useRadius=isChecked;
            }
        });
        findViewById(R.id.btn_bottom_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View parent=View.inflate(MainActivity.this,R.layout.layout_bottom_menu,null);
                final PopupLayout popupLayout=PopupLayout.init(MainActivity.this,parent);
                parent.findViewById(R.id.menu_1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"Item1",Toast.LENGTH_SHORT).show();
                        popupLayout.hide();//让弹出布局中的按钮关闭弹出窗口
                    }
                });
                popupLayout.setUseRadius(useRadius);
                popupLayout.show(PopupLayout.POSITION_BOTTOM);
            }
        });
    }
}
