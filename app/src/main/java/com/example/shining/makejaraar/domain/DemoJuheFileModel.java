package com.example.shining.makejaraar.domain;

import java.io.Serializable;

/**
 * Created by shining on 2017/2/10 0010.
 */

public class DemoJuheFileModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String reason;
    private int error_code;
    private String result;

    public DemoJuheFileModel() {
    }

    public DemoJuheFileModel(String reason, int error_code, String result) {
        this.reason = reason;
        this.error_code = error_code;
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
