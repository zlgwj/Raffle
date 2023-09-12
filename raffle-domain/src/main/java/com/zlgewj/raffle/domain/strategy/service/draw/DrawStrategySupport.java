package com.zlgewj.raffle.domain.strategy.service.draw;

import com.zlgewj.raffle.domain.strategy.model.aggregates.StrategyRich;
import com.zlgewj.raffle.domain.strategy.repository.impl.StrategyRepository;
import com.zlgewj.raffle.infrastructure.po.Award;

import javax.annotation.Resource;

/**
 * @Author zlgewj
 * @Since 2023/9/8
 */

public class DrawStrategySupport extends DrawConfig {

    @Resource
    protected StrategyRepository strategyRepository;

    protected StrategyRich queryStrategyRich(Long strategyId) {
        return strategyRepository.queryStrategyRich(strategyId);
    }


    protected Award queryAwardInfo(String awardId) {
        return strategyRepository.queryAward(awardId);
    }

}
