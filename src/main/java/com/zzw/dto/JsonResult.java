package com.zzw.dto;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {

    private T data;

    private int err_code;

    private String err_msg;

    public JsonResult() {

    }

    public JsonResult(int err_code, String err_msg) {
        this.err_code = err_code;
        this.err_msg = err_msg;
    }

    public JsonResult(int err_code, T data) {
        this.err_code = err_code;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErr_code() {
        return err_code;
    }

    public void setErr_code(int err_code) {
        this.err_code = err_code;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }
}
