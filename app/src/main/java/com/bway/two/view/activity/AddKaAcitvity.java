package com.bway.two.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bway.two.R;
import com.bway.two.model.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @类的用途:
 * @姓名: 张惠行
 * @date 2017/8/15
 */

public class AddKaAcitvity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.ka_add_fh)
    ImageView kaAddFh;
    @BindView(R.id.add_ka_kh)
    EditText addKaKh;
    @BindView(R.id.add_ka_name)
    EditText addKaName;
    @BindView(R.id.add_ka_dz)
    EditText addKaDz;
    @BindView(R.id.add_ka_hang)
    EditText addKaHang;
    @BindView(R.id.add_ka_qd)
    Button addKaQd;
    private String name;

    @Override
    public int getLayout() {
        return R.layout.add_ka_layout;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
      kaAddFh.setOnClickListener(this);
        addKaQd.setOnClickListener(this);
        name = addKaName.getText().toString().trim();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ka_add_fh:
                finish();
                break;
            case  R.id.add_ka_qd:
                finish();
//                EventBus.getDefault().post("");
                break;

        }
    }
}
