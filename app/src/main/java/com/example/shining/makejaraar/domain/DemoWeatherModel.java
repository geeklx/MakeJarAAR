package com.example.shining.makejaraar.domain;

import java.io.Serializable;

/**
 * Created by geek on 2016/8/4.
 */

public class DemoWeatherModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String qlty;
    private String txt;
    private int tmp;

    public DemoWeatherModel() {
    }

    public DemoWeatherModel(String qlty, String txt, int tmp) {
        this.qlty = qlty;
        this.txt = txt;
        this.tmp = tmp;
    }

    public String getQlty() {
        return qlty;
    }

    public void setQlty(String qlty) {
        this.qlty = qlty;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public int getTmp() {
        return tmp;
    }

    public void setTmp(int tmp) {
        this.tmp = tmp;
    }
}
