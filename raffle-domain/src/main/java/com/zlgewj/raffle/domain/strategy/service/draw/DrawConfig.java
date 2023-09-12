package com.zlgewj.raffle.domain.strategy.service.draw;

import com.zlgewj.raffle.common.Constants;
import com.zlgewj.raffle.domain.strategy.service.algorithm.IDrawAlgorithm;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zlgewj
 * @Since 2023/9/8
 */

public class DrawConfig {
    @Resource
    private IDrawAlgorithm entiretyRateRandomDrawAlgorithm;
    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    protected Map<Integer, IDrawAlgorithm> map = new ConcurrentHashMap<Integer, IDrawAlgorithm>();

    @PostConstruct
    public void init() {
        map.put(Constants.StrategyMode.ENTIRETY.getCode(), entiretyRateRandomDrawAlgorithm);
        map.put(Constants.StrategyMode.SINGLE.getCode(), singleRateRandomDrawAlgorithm);
    }

}
