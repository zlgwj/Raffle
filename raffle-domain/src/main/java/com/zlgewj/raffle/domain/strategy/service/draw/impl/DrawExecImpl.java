package com.zlgewj.raffle.domain.strategy.service.draw.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.zlgewj.raffle.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.zlgewj.raffle.domain.strategy.service.draw.AbstractDrawBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zlgewj
 * @Since 2023/9/8
 */
@Slf4j
@Service
public class DrawExecImpl extends AbstractDrawBase{


    @Override
    protected List<String> queryExcludedAwardsIds(Long strategyId) {
        List<String> strings = strategyRepository.queryNoStockAward(strategyId);
        log.info("无库存集合：{}",JSON.toJSONString(strings));
        return strings;
    }

    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludedAwards) {
        String awardId = drawAlgorithm.randomDraw(strategyId, excludedAwards);
        log.info("执行抽奖, 策略id :{}",strategyId);
        if (StrUtil.isBlank(awardId)) {
            return "";
        }
        boolean isSuccess = strategyRepository.deductStock(strategyId, awardId);
        return isSuccess ? awardId : null;
    }
}
