package com.gls.speed.sdk.impl;

/**
 * Created by dengjun on 2017/10/17.
 */

public interface RequestCallback<T> {
    void onResult(T result);
    void onError(Exception e);
}
