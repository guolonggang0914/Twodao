package com.bway.two.view.IMview;

/**
 * Created by 卢程
 * 2017/8/24.
 */

public interface IMHome<T> {
    void onSuccess(T t, int code);
    void onError(int code, String str);
}
