package com.zlgewj.raffle.domain.strategy.repository;

import com.zlgewj.raffle.domain.strategy.model.aggregates.StrategyRich;
import com.zlgewj.raffle.infrastructure.po.Award;

import java.util.List;

/**
 * @Author zlgewj
 * @Since 2023/9/8
 */

public interface IStrategyRepository {
    StrategyRich queryStrategyRich(Long strategyId);

    Award queryAward(String awardId);

    List<String> queryNoStockAward(Long strategyId);

    boolean deductStock(Long strategyId, String awardId);
}
