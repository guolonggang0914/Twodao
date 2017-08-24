package com.bway.two.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bway.two.R;
import com.bway.two.model.base.BaseActivity;
import com.zaaach.toprightmenu.MenuItem;
import com.zaaach.toprightmenu.TopRightMenu;

import java.util.ArrayList;
import java.util.List;

public class MessJiLuActivity extends BaseActivity implements View.OnClickListener {

    private ImageView bang;
    private ImageView fh;
    private TopRightMenu topRightMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_mess_ji_lu;
    }

    @Override
    public void initView() {
        bang = (ImageView) findViewById(R.id.jilu_bang);
        fh = (ImageView) findViewById(R.id.jilu_fh);
    }

    @Override
    public void initData() {
         bang.setOnClickListener(this);
        fh.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.jilu_fh:
                finish();
                break;
            case R.id.jilu_bang:
                getTopMenu();
                topRightMenu.showAsDropDown(bang,-225,0);
                break;
        }
    }
    public  void   getTopMenu(){
        topRightMenu = new TopRightMenu(this);
        //添加菜单项
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("7天内消费可以申请退款,"));
        menuItems.add(new MenuItem("具体事宜请咨询商户"));
        topRightMenu
                .setHeight(200)     //默认高度480
                .setWidth(280)      //默认宽度wrap_content
                .showIcon(true)     //显示菜单图标，默认为true
                .dimBackground(true)        //背景变暗，默认为true
                .needAnimationStyle(true)   //显示动画，默认为true
                .setAnimationStyle(R.style.TRM_ANIM_STYLE)
                .addMenuList(menuItems);
    }
}
