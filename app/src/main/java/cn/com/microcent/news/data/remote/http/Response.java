package cn.com.microcent.news.data.remote.http;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import static cn.com.microcent.news.app.Constant.Code.SUCCESS;

/**
 * Created by Administrator on 2017/12/14.
 */

public class Response<T> implements Serializable {

    @SerializedName("code")
    private int code;

    @SerializedName("msg")
    private String msg;

    @SerializedName("data")
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.code == SUCCESS;
    }
}
