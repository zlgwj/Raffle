package com.zlgewj.raffle.domain.strategy.service.algorithm.impl;

import com.zlgewj.raffle.domain.strategy.service.algorithm.BaseDrawAlgorighm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

/**
 * 先以 斐波那契散列填充数组，再随机然后直接获取奖品id
 * @Author zlgewj
 * @Since 2023/9/8
 */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseDrawAlgorighm {
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        String[] tuple = super.initedTuple.get(strategyId);
        assert  tuple!= null;
        int random = new SecureRandom().nextInt(100) + 1;
        int idx = super.hashIdx(random);
        String s = tuple[idx];
        if (excludeAwardIds.contains(s)) {
            throw new RuntimeException("未中奖");
        }
        return s;
    }
}
