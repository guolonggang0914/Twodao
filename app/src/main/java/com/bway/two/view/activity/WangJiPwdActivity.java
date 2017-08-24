package com.bway.two.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bway.two.R;
import com.bway.two.model.base.BaseActivity;
import com.bway.two.model.bean.RegisterBean;
import com.bway.two.presenter.RegisterPresenter;
import com.bway.two.view.IMview.IMLogin;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import butterknife.ButterKnife;

public class WangJiPwdActivity extends BaseActivity implements View.OnClickListener, IMLogin<RegisterBean> {


    private String urlMess = "http://123.57.33.185:8088/sendCode";
    private int count = 60;
    private Timer timer;
    private Thread thread;
    private boolean tag = true;
    private final static int MESSAGE = 0;
    private final static int REGISTER = 1;
    private RegisterPresenter presenter;
    private String tiJiao = "http://123.57.33.185:8088//user/forgetPassword";
    private String phone;
    private Map<String, Object> map = new HashMap<>();
    private ImageView wangjiFh;
    private EditText wangjiPhone;
    private EditText wangjiCode;
    private TextView wangjiHuoqu;
    private EditText wangjiXinPwd;
    private EditText wangjiQuePwd;
    private Button wangjiCongzhi;


    @Override
    public int getLayout() {
        ButterKnife.bind(this);
        return R.layout.activity_wang_ji_pwd;
    }

    @Override
    public void initView() {
        wangjiFh = (ImageView) findViewById(R.id.wangji_fh);
        wangjiPhone = (EditText) findViewById(R.id.wangji_phone);
        wangjiCode = (EditText) findViewById(R.id.wangji_code);
        wangjiHuoqu = (TextView) findViewById(R.id.wangji_huoqu);
        wangjiXinPwd = (EditText) findViewById(R.id.wangji_xin_pwd);
        wangjiQuePwd = (EditText) findViewById(R.id.wangji_que_pwd);
        wangjiCongzhi = (Button) findViewById(R.id.wangji_congzhi);
    }

    @Override
    public void initData() {
        wangjiHuoqu.setOnClickListener(this);
        wangjiFh.setOnClickListener(this);
        wangjiCongzhi.setOnClickListener(this);
        presenter = new RegisterPresenter(this);
        presenter.onAttach(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.wangji_huoqu:
                phone = wangjiPhone.getText().toString().trim();
                map.put("phone", phone);
                map.put("type", 2);
                map.put("merchant", 0);
                presenter.loadUrlbypost(urlMess, map, MESSAGE);
                changeBtnGetCode();
                break;
            case R.id.wangji_fh:
                finish();
                break;
            case R.id.wangji_congzhi:
                phone = wangjiPhone.getText().toString().trim();
                String xinPwd = wangjiXinPwd.getText().toString().trim();
                String quePwd = wangjiQuePwd.getText().toString().trim();
                String yanZheng = wangjiCode.getText().toString().trim();
                if (xinPwd.equals(quePwd)) {
                    map.put("phone", phone);
                    map.put("password", xinPwd);
                    map.put("code", yanZheng);
                    map.put("merchant", 0);
                    presenter.loadUrlbypost(tiJiao, map, REGISTER);
                } else {
                    Toast.makeText(WangJiPwdActivity.this, "密码不一致", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onSucceed(RegisterBean registerBean, int code) {
        if (code == MESSAGE) {
            if (registerBean.getCode().equals("2006")) {
                String code1 = registerBean.getDescirption();
                Toast.makeText(WangJiPwdActivity.this, code1, Toast.LENGTH_SHORT).show();
                return;
            }
            if (registerBean.getCode().equals("-1")) {
                Toast.makeText(WangJiPwdActivity.this, "系统处理失败", Toast.LENGTH_SHORT).show();
                return;
            }
            if (registerBean.getCode().equals("2005")) {
                Toast.makeText(WangJiPwdActivity.this, "用户未被注册", Toast.LENGTH_SHORT).show();
                changeBtnGetCode();
                return;
            }

        }
        if (code == REGISTER) {
            if (registerBean.getCode().equals("1000")) {
                Toast.makeText(WangJiPwdActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(WangJiPwdActivity.this, "手机号或验证码错误", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(int code, String err) {

    }

    @Override
    public void checkInfo(boolean isNull, String msg) {

    }

    private void changeBtnGetCode() {
        thread = new Thread() {
            @Override
            public void run() {
                if (tag) {
                    while (count > 0) {
                        count--;
                        if (WangJiPwdActivity.this == null) {
                            break;
                        }

                        WangJiPwdActivity.this
                                .runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        wangjiHuoqu.setText("获取验证码("
                                                + count + ")");
                                        wangjiHuoqu
                                                .setClickable(false);
                                    }
                                });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    tag = false;
                }
                count = 60;
                tag = true;
                if (WangJiPwdActivity.this != null) {
                    WangJiPwdActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            wangjiHuoqu.setText("获取验证码");
                            wangjiHuoqu.setClickable(true);
                        }
                    });
                }
            }

            ;
        };
        thread.start();
    }


}
