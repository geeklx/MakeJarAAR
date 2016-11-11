package com.example.shining.makejaraar.params;

import java.io.Serializable;

/**
 * Created by shining on 2016/11/10 0010.
 */

public class DemoParams implements Serializable {
    private static final long serialVersionUID = 1L;
    private String user_id;

    public DemoParams() {
    }

    public DemoParams(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}

