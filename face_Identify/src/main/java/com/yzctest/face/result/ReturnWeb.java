package com.yzctest.face.result;

public class ReturnWeb {
    private boolean isSuccess;
    private Object context;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }



    public ReturnWeb() {
    }

    public ReturnWeb(boolean isSuccess, Object context) {
        this.isSuccess = isSuccess;
        this.context = context;
    }

    public Object getContext() {
        return context;
    }

    public void setContext(Object context) {
        this.context = context;
    }
}
