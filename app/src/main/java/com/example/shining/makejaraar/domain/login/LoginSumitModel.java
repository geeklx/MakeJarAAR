package com.example.shining.makejaraar.domain.login;

import java.io.Serializable;

/**
 * Created by shining 2016年11月14日18:47:24
 */

public class LoginSumitModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String access_token;
    private String user_id;
    private String u_open_id;

    public LoginSumitModel() {
    }

    public LoginSumitModel(String access_token, String user_id) {
        this.access_token = access_token;
        this.user_id = user_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getU_open_id() {
        return u_open_id;
    }

    public void setU_open_id(String u_open_id) {
        this.u_open_id = u_open_id;
    }
}
