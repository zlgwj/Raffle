package com.zlgewj.raffle.rpc.res;

import com.zlgewj.raffle.common.Result;
import com.zlgewj.raffle.rpc.dto.ActivityDto;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.PrimitiveIterator;

/**
 * @Author zlgewj
 * @Since 2023/9/5
 */

public class ActivityRes implements Serializable {
    private Result result;
    private ActivityDto activity;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ActivityDto getActivity() {
        return activity;
    }

    public void setActivity(ActivityDto activity) {
        this.activity = activity;
    }

    public ActivityRes(Result result, ActivityDto activity) {
        this.result = result;
        this.activity = activity;
    }

    public ActivityRes() {
    }
}
