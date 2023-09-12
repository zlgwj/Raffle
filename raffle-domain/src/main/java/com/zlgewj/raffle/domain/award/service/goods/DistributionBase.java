package com.zlgewj.raffle.domain.award.service.goods;

import com.zlgewj.raffle.domain.award.repository.IAwardRepository;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * @Author zlgewj
 * @Since 2023/9/9
 */

@Slf4j
public class DistributionBase {

    @Resource
    private IAwardRepository awardRepository;

    protected void updateUserAwardState(String uId, String orderId, String awardId, Integer awardState, String awardStateInfo) {
        // TODO: 2023/9/9 每个人中奖状态
    }

}
