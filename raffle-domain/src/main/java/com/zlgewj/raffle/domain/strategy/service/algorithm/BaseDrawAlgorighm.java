package com.zlgewj.raffle.domain.strategy.service.algorithm;

import com.zlgewj.raffle.domain.strategy.model.vo.AwardRateInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zlgewj
 * @Since 2023/9/8
 */

public abstract class BaseDrawAlgorighm implements IDrawAlgorithm {


    private final int HASH_INCREMENT = 0x61c88647;

    private final int RATE_TUPLE_LENGTH = 128;

    protected Map<Long, String[]> initedTuple = new ConcurrentHashMap<>();

    protected Map<Long, List<AwardRateInfo>> awardRateInfoMap = new ConcurrentHashMap<>();

    @Override
    public void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList) {
        awardRateInfoMap.put(strategyId, awardRateInfoList);
        String[] tuple = initedTuple.computeIfAbsent(strategyId, k -> new String[RATE_TUPLE_LENGTH]);
        int curIdx = 0;
        BigDecimal hundred = new BigDecimal(100);
        for (AwardRateInfo awardRateInfo : awardRateInfoList) {
            int rate = awardRateInfo.getAwardRate().multiply(hundred).intValue();

//            循环的作用是 1~20    21 ~ 70 71 ~ 100
            for (int i = curIdx + 1; i <= (rate + curIdx); i++) {
                tuple[hashIdx(i)] = awardRateInfo.getAwardId();
            }
            curIdx += rate;
        }
    }

    @Override
    public boolean isInited(Long strategyId) {
        return initedTuple.containsKey(strategyId);
    }

    protected int hashIdx(int val) {
        int hashCode = val * HASH_INCREMENT + HASH_INCREMENT;
        return hashCode & (RATE_TUPLE_LENGTH - 1);
    }
}
