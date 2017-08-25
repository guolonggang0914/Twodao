package com.bway.two.view.IMview;

/**
 * autor: 李金涛.
 * date:2017/8/9
 */


public interface IMMain<T> {
    void onSucceed(T t);
    void onError(int code,String err);
}
