package com.zlgewj.raffle.infrastructure.dao;

import com.zlgewj.raffle.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 策略明细dao
 *
 * @Author zlgewj
 * @Since 2023/9/6
 */
@Mapper
public interface IStrategyDetailDao {
    List<StrategyDetail> queryStrategyDetailList(@Param("strategyId") Long strategyId);

    List<String> queryNoStock(@Param("strategyId") Long strategyId);

    Integer deductStock(@Param("strategyId") Long strategyId, @Param("awardId") String awardId);
}
