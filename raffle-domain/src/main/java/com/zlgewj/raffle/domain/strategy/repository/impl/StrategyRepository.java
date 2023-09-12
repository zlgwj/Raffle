package com.zlgewj.raffle.domain.strategy.repository.impl;

import com.zlgewj.raffle.domain.strategy.model.aggregates.StrategyRich;
import com.zlgewj.raffle.domain.strategy.repository.IStrategyRepository;
import com.zlgewj.raffle.infrastructure.dao.IAwardDao;
import com.zlgewj.raffle.infrastructure.dao.IStrategyDao;
import com.zlgewj.raffle.infrastructure.dao.IStrategyDetailDao;
import com.zlgewj.raffle.infrastructure.po.Award;
import com.zlgewj.raffle.infrastructure.po.Strategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author zlgewj
 * @Since 2023/9/8
 */

@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    IStrategyDao strategyDao;
    @Resource
    IStrategyDetailDao strategyDetailDao;
    @Resource
    IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        return StrategyRich.builder()
                .strategyDetailList(strategyDetailDao.queryStrategyDetailList(strategyId))
                .strategyId(strategyId)
                .strategy(strategy)
                .build();
    }

    @Override
    public Award queryAward(String awardId) {
        return awardDao.queryAward(awardId);
    }

    @Override
    public List<String> queryNoStockAward(Long strategyId) {
        return strategyDetailDao.queryNoStock(strategyId);
    }

    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        Integer isSuccess = strategyDetailDao.deductStock(strategyId, awardId);
        return isSuccess > 0;
    }
}
