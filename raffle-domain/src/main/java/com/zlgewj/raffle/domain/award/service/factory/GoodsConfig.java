package com.zlgewj.raffle.domain.award.service.factory;

import com.zlgewj.raffle.common.Constants;
import com.zlgewj.raffle.domain.award.service.goods.IDistributionGoods;
import com.zlgewj.raffle.domain.award.service.goods.impl.CouponGoods;
import com.zlgewj.raffle.domain.award.service.goods.impl.DescGoods;
import com.zlgewj.raffle.domain.award.service.goods.impl.PhysicalGoods;
import com.zlgewj.raffle.domain.award.service.goods.impl.RedeemCodeGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zlgewj
 * @Since 2023/9/9
 */


public class GoodsConfig {

    @Resource
    DescGoods descGoods;
    @Resource
    CouponGoods couponGoods;
    @Resource
    PhysicalGoods physicalGoods;
    @Resource
    RedeemCodeGoods redeemCodeGoods;

    protected static Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();
    @PostConstruct
    public void init() {
        goodsMap.put(Constants.AwardType.DESC.getCode(), descGoods);
        goodsMap.put(Constants.AwardType.CouponGoods.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.PhysicalGoods.getCode(), physicalGoods);
        goodsMap.put(Constants.AwardType.RedeemCodeGoods.getCode(), redeemCodeGoods);
    }

}
