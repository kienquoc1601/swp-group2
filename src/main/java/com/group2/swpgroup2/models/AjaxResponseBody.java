package com.group2.swpgroup2.models;

import java.util.List;

public class AjaxResponseBody {
    String msg;
    List<Course> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Course> getResult() {
        return result;
    }

    public void setResult(List<Course> result) {
        this.result = result;
    }
}
