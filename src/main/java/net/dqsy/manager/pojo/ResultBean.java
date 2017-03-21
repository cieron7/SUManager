package net.dqsy.manager.pojo;

import java.io.Serializable;

/**
 * @author jingzhibao
 * @version 1.0.0 2017/3/21 11:43
 */
public class ResultBean<T> implements Serializable {

    private boolean success;

    private String message;

    private T data;

    public ResultBean() {
    }

    public ResultBean(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResultBean(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
