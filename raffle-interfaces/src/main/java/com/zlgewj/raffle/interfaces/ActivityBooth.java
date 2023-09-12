package com.zlgewj.raffle.interfaces;

import com.zlgewj.raffle.common.Constants;
import com.zlgewj.raffle.common.Result;
import com.zlgewj.raffle.infrastructure.dao.IActivityDao;
import com.zlgewj.raffle.infrastructure.po.Activity;
import com.zlgewj.raffle.rpc.IActivityBooth;
import com.zlgewj.raffle.rpc.dto.ActivityDto;
import com.zlgewj.raffle.rpc.req.ActivityReq;
import com.zlgewj.raffle.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * 活动展示台
 *
 * @Author zlgewj
 * @Since 2023/9/5
 */
@Service
public class ActivityBooth implements IActivityBooth {
    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq req) {
        Activity activity = activityDao.queryActivityById(req.getActivityId());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo()), activityDto);
    }
}
