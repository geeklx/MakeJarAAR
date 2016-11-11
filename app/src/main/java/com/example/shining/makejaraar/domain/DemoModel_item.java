package com.example.shining.makejaraar.domain;

import java.io.Serializable;

/**
 * Created by geek on 2016/8/4.
 */

public class DemoModel_item implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * current_page : 1
     * page_size : 10
     * total_page : 3
     * total_record : 27
     */

    private int current_page;
    private int page_size;
    private int total_page;
    private int total_record;

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }

    public int getTotal_record() {
        return total_record;
    }

    public void setTotal_record(int total_record) {
        this.total_record = total_record;
    }
}
