package com.zlgewj.raffle.domain.strategy.service.algorithm;

import com.zlgewj.raffle.domain.strategy.model.vo.AwardRateInfo;

import java.util.List;

/**
 * 抽奖算法
 *
 * @Author zlgewj
 * @Since 2023/9/8
 */

public interface IDrawAlgorithm {


    void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList);

    boolean isInited(Long strategyId);

    String randomDraw(Long strategyId, List<String> excludeAwardIds);


}
