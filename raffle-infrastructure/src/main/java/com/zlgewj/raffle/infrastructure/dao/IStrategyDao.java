package com.zlgewj.raffle.infrastructure.dao;

import com.zlgewj.raffle.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author zlgewj
 * @Since 2023/9/6
 */
@Mapper
public interface IStrategyDao {
    Strategy queryStrategy(@Param("strategyId") Long strategyId);
}
