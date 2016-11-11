package com.example.shining.makejaraar.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by geek on 2016/8/4.
 */

public class DemoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private DemoModel_item page_info;
    private List<DemoModel_list> food_list;

    public DemoModel_item getPage_info() {
        return page_info;
    }

    public void setPage_info(DemoModel_item page_info) {
        this.page_info = page_info;
    }

    public List<DemoModel_list> getFood_list() {
        return food_list;
    }

    public void setFood_list(List<DemoModel_list> food_list) {
        this.food_list = food_list;
    }
}
