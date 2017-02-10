package com.example.shining.makejaraar.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by shining on 2017/2/10 0010.
 */

public class ResultDemoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String stat;
    private List<DataDemoModel> data;

    public ResultDemoModel() {
    }

    public ResultDemoModel(String stat, List<DataDemoModel> data) {
        this.stat = stat;
        this.data = data;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<DataDemoModel> getData() {
        return data;
    }

    public void setData(List<DataDemoModel> data) {
        this.data = data;
    }
}
