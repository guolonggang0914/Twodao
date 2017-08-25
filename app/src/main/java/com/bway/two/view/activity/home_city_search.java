package com.bway.two.view.activity;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.bway.two.R;
import com.bway.two.utils.ImageShowUtils.KeyboardUtil;



public class home_city_search extends AppCompatActivity {
    private Context mContext;
    private Activity mActivity;
    private EditText mUsernameEt;
    private EditText mPasswordEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_city_search);
        mContext = this;
        mActivity = this;

        mUsernameEt = (EditText) findViewById(R.id.editText1);
        mPasswordEt = (EditText) findViewById(R.id.editText2);

        mUsernameEt.setInputType(InputType.TYPE_NULL);
        mUsernameEt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                new KeyboardUtil(mContext, mActivity, mUsernameEt).showKeyboard();
                return false;
            }
        });

        mPasswordEt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int inputType = mPasswordEt.getInputType();
                mPasswordEt.setInputType(InputType.TYPE_NULL);
                new KeyboardUtil(mContext, mActivity, mPasswordEt).showKeyboard();
                mPasswordEt.setInputType(inputType);
                return false;
            }
        });
    }
}
