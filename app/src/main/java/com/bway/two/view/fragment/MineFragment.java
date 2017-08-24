package com.bway.two.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bway.two.R;
import com.bway.two.model.application.MainApplication;
import com.bway.two.model.bean.LoginBean;
import com.bway.two.view.activity.GuanYuActivity;
import com.bway.two.view.activity.KaAcitvity;
import com.bway.two.view.activity.LoginActivity;
import com.bway.two.view.activity.AnQuanActivity;
import com.bway.two.view.activity.MessJiLuActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @类的用途:
 * @姓名: 张惠行
 * @date 2017/8/10
 */

public class MineFragment extends Fragment implements View.OnClickListener {

    private TextView min_login;
    private LinearLayout min_ll;
    private TextView phone;
    private TextView guanyu;
    private TextView anquan;
    private ImageView kabao;
    private TextView userName;
    private MainApplication instence;
    private LinearLayout min_ll_phone;
    private boolean login;
    private TextView jiLu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        EventBus.getDefault().register(this);
        return inflater.inflate(R.layout.fragmet_min,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        min_login = getView().findViewById(R.id.min_login);
        min_ll = getView().findViewById(R.id.min_llusername);
        min_ll_phone = getView().findViewById(R.id.min_llphone);
        phone = getView().findViewById(R.id.min_phone);
        guanyu = getView().findViewById(R.id.min_guanyu);
        anquan = getView().findViewById(R.id.min_anquan);
        kabao = getView().findViewById(R.id.min_kabao);
        userName = getView().findViewById(R.id.min_username);
        jiLu = getView().findViewById(R.id.min_jilu);
        jiLu.setOnClickListener(this);
        phone.setOnClickListener(this);
        min_login.setOnClickListener(this);
        guanyu.setOnClickListener(this);
        anquan.setOnClickListener(this);
        kabao.setOnClickListener(this);

    }
    @Override
    public void onResume() {
        super.onResume();
        instence = MainApplication.getInstence();
        login = instence.isLogin();
        if (login){
            min_login.setVisibility(View.GONE);
            min_ll.setVisibility(View.VISIBLE);
            min_ll_phone.setVisibility(View.VISIBLE);
            String name = instence.getUserName();
            userName.setText(name);
            String userPhone = instence.getUserPhone();
            phone.setText(userPhone);
        }else {
            min_login.setVisibility(View.VISIBLE);
            min_ll.setVisibility(View.GONE);
            min_ll_phone.setVisibility(View.GONE);
            instence.setLogin(false);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.min_login:
                Intent  intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.min_anquan:
                if (login) {
                    startActivity(new Intent(getActivity(), AnQuanActivity.class));
                }else{
                    Toast.makeText(getActivity(),"请先登陆",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.min_guanyu:
                startActivity(new Intent(getActivity(), GuanYuActivity.class));
                break;
            case R.id.min_kabao:
                if (login) {
                    startActivity(new Intent(getActivity(), KaAcitvity.class));
                }else{
                    Toast.makeText(getActivity(),"请先登陆",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.min_jilu:
                if (login) {
                    startActivity(new Intent(getActivity(),MessJiLuActivity.class));
                }else{
                    Toast.makeText(getActivity(),"请先登陆",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEventMainThread(LoginBean event) {
//                     min_login.setVisibility(View.GONE);
//                    min_ll.setVisibility(View.VISIBLE);
//        LoginBean.ObjectBean object = event.getObject();
//        String nickname = object.getNickname();
//        userName.setText(nickname);
//        String p = object.getPhone();
//        phone.setText(p);
//    }

//    @Override
//    public void onDestroy(){
//        super.onDestroy();
//        EventBus.getDefault().unregister(this);//反注册EventBus
//    }
}
