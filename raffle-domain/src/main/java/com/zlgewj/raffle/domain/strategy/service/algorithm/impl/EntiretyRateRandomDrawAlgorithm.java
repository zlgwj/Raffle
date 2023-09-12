package com.zlgewj.raffle.domain.strategy.service.algorithm.impl;

import com.zlgewj.raffle.domain.strategy.model.vo.AwardRateInfo;
import com.zlgewj.raffle.domain.strategy.service.algorithm.BaseDrawAlgorighm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * 必中奖，一个奖品抽空以后概率均摊
 * 随机，并比较区间
 * @Author zlgewj
 * @Since 2023/9/8
 */
@Component("entiretyRateRandomDrawAlgorithm")
public class EntiretyRateRandomDrawAlgorithm extends BaseDrawAlgorighm {
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        BigDecimal totalRate = BigDecimal.ZERO;
        ArrayList<AwardRateInfo> existedAwards = new ArrayList<>();
        BigDecimal hundred = new BigDecimal(100);

        List<AwardRateInfo> awardRateInfos = super.awardRateInfoMap.get(strategyId);
        for (AwardRateInfo awardRateInfo : awardRateInfos) {
            String awardId = awardRateInfo.getAwardId();
            if (excludeAwardIds.contains(awardId)) {
                continue;
            }
            totalRate = totalRate.add(awardRateInfo.getAwardRate());
            existedAwards.add(awardRateInfo);
        }

        if (existedAwards.size() == 0) {
            throw new RuntimeException("没奖品了");
        }
        if (existedAwards.size() == 1) {
            return existedAwards.get(0).getAwardId();
        }
        int cnt = 0;
        int random = new SecureRandom().nextInt(100) + 1;
        for (AwardRateInfo awardRateInfo : existedAwards) {
            int rateVal = awardRateInfo.getAwardRate().divide(totalRate, 2, BigDecimal.ROUND_UP).multiply(hundred).intValue();
            if (random <= rateVal + cnt) {
                return awardRateInfo.getAwardId();
            }
            cnt += rateVal;
        }
        return "";
    }
}
