package com.zlgewj.raffle.domain.award.service.goods.impl;

import com.zlgewj.raffle.common.Constants;
import com.zlgewj.raffle.domain.award.model.req.GoodsReq;
import com.zlgewj.raffle.domain.award.model.resp.DistributionResp;
import com.zlgewj.raffle.domain.award.service.goods.DistributionBase;
import com.zlgewj.raffle.domain.award.service.goods.IDistributionGoods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.util.concurrent.RecursiveTask;

/**
 * @Author zlgewj
 * @Since 2023/9/9
 */
@Component
@Slf4j
public class CouponGoods extends DistributionBase implements IDistributionGoods {
    @Override
    public DistributionResp doDistribution(GoodsReq goodsReq) {
        log.info("调用优惠券发放接口");
        super.updateUserAwardState(goodsReq.getUId(), goodsReq.getOrderId(), goodsReq.getAwardId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
        return new DistributionResp(goodsReq.getUId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }

    @Override
    public Integer getDistributionGoodsName() {
        return Constants.AwardType.CouponGoods.getCode();
    }
}
