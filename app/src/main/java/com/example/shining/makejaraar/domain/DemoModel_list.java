package com.example.shining.makejaraar.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by qibin on 2016/8/4.
 */

public class DemoModel_list implements Serializable {
    private static final long serialVersionUID = 1L;
    private String food_name;
    private String food_definition_id;
    private String food_image;
    private String food_category_id;
    private String food_unit;
    private String food_third_category_id;


    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_definition_id() {
        return food_definition_id;
    }

    public void setFood_definition_id(String food_definition_id) {
        this.food_definition_id = food_definition_id;
    }

    public String getFood_image() {
        return food_image;
    }

    public void setFood_image(String food_image) {
        this.food_image = food_image;
    }

    public String getFood_category_id() {
        return food_category_id;
    }

    public void setFood_category_id(String food_category_id) {
        this.food_category_id = food_category_id;
    }

    public String getFood_unit() {
        return food_unit;
    }

    public void setFood_unit(String food_unit) {
        this.food_unit = food_unit;
    }

    public String getFood_third_category_id() {
        return food_third_category_id;
    }

    public void setFood_third_category_id(String food_third_category_id) {
        this.food_third_category_id = food_third_category_id;
    }
}
