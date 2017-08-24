package com.bway.two.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bway.two.R;
import com.bway.two.model.base.BaseActivity;
import com.bway.two.model.bean.KaBean;
import com.bway.two.view.adapter.KaListAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @类的用途:
 * @姓名: 张惠行
 * @date 2017/8/15
 */

public class KaAcitvity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.ka_fh)
    ImageView kaFh;
    @BindView(R.id.ka_wechat)
    RelativeLayout kaWechat;
    @BindView(R.id.ka_zhufubao)
    RelativeLayout kaZhufubao;
    @BindView(R.id.lv)
    ListView lv;
    @BindView(R.id.ka_add)
    TextView kaAdd;
    private List<KaBean> mList = new ArrayList<>();
    private KaBean kaBean;
    private KaListAdapter adapter;

    @Override
    public int getLayout() {
        return R.layout.layout_ka;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        kaFh.setOnClickListener(this);
        kaAdd.setOnClickListener(this);
        kaWechat.setOnClickListener(this);
        kaZhufubao.setOnClickListener(this);
        for (int i = 0; i < mList.size(); i++) {
            kaBean = new KaBean();
            kaBean.setName("中国银行(0605)");
            kaBean.setBangding("解除绑定 >");
            kaBean.setImage(R.drawable.zgyh);
            mList.add(kaBean);
        }


        adapter = new KaListAdapter(KaAcitvity.this, mList);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ka_fh:
                finish();
                break;
            case R.id.ka_add:
           startActivity(new Intent(KaAcitvity.this,AddKaAcitvity.class));
                break;
        }
    }



}
