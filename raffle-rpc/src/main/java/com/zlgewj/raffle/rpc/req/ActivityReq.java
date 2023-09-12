package com.zlgewj.raffle.rpc.req;

import java.io.Serializable;

/**
 * @Author zlgewj
 * @Since 2023/9/5
 */

public class ActivityReq implements Serializable {
    public Long activityId;

    public Long getActivityId() {
        return activityId;
    }
    public void setActivityId(Long id) {
        this.activityId = id;
    }
}
