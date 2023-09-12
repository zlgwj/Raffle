package com.zlgewj.raffle.infrastructure.dao;

import com.zlgewj.raffle.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zlgewj
 * @Since 2023/9/5
 */
@Mapper
public interface IActivityDao {

    Activity queryActivityById(Long activityId);
}
