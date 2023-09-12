package com.zlgewj.raffle.common;

import java.io.Serializable;

/**
 * @Author zlgewj
 * @Since 2023/9/5
 */

public class Result implements Serializable {
    private String code;
    private String info;

    public Result(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public static Result buildResult(String code, String info) {
        return new Result(code, info);
    }

    public static Result buildSuccess() {
        return new Result(Constants.ResponseCode.SUCCESS.getCode(),Constants.ResponseCode.SUCCESS.getInfo());
    }

    public static Result buildError() {
        return new Result(Constants.ResponseCode.UN_ERROR.getCode(), Constants.ResponseCode.UN_ERROR.getInfo());
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
