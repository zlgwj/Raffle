package com.zlgewj.raffle.rpc;

import com.zlgewj.raffle.rpc.req.ActivityReq;
import com.zlgewj.raffle.rpc.res.ActivityRes;

/**
 * @Author zlgewj
 * @Since 2023/9/5
 */

public interface IActivityBooth {
    ActivityRes queryActivityById(ActivityReq req);
}
