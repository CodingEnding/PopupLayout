package com.codingending.popuplayout.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.codingending.popuplayout.PopupLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用弹出布局的演示demo
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
                });//添加监听器
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
        //底部菜单
        findViewById(R.id.btn_bottom_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View parent=View.inflate(MainActivity.this,R.layout.layout_bottom_menu,null);
                final PopupLayout popupLayout=PopupLayout.init(MainActivity.this,parent);
                final View.OnClickListener clickListener=new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,((Button)v).getText(),Toast.LENGTH_SHORT).show();
                        popupLayout.dismiss();//让弹出布局中的按钮关闭弹出窗口
                    }
                };
                parent.findViewById(R.id.menu_1).setOnClickListener(clickListener);
                parent.findViewById(R.id.menu_2).setOnClickListener(clickListener);
                parent.findViewById(R.id.menu_3).setOnClickListener(clickListener);
                popupLayout.setUseRadius(useRadius);
                popupLayout.show(PopupLayout.POSITION_BOTTOM);
            }
        });
        //底部列表
        findViewById(R.id.btn_bottom_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=View.inflate(MainActivity.this,R.layout.layout_bottom_list,null);
                initListView(view);
                PopupLayout popupLayout=PopupLayout.init(MainActivity.this,view);
                popupLayout.setUseRadius(useRadius);
                popupLayout.setHeight(350,true);//手动设置弹出布局的高度
                //popupLayout.setWidth(320,true);//手动设置弹出布局的宽度
                popupLayout.show();//默认从底部弹出
            }
        });
        ((CheckBox)findViewById(R.id.checkbox_radius)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                useRadius=isChecked;
            }
        });
    }

    //获取示例ListView
    private void initListView(View parent){
        ListView listView=parent.findViewById(R.id.listview_bottom);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,getDataList());
        listView.setAdapter(adapter);
    }

    //获取列表的演示数据
    private List<String> getDataList(){
        List<String> dataList=new ArrayList<>();
        for(int i=0;i<20;i++){
            dataList.add("示例条目"+i);
        }
        return dataList;
    }

}
