package com.zlgewj.raffle.domain.award.service.factory;

import com.zlgewj.raffle.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/**
 * @Author zlgewj
 * @Since 2023/9/9
 */
@Service
public class DistributionGoodsFactory extends GoodsConfig{

    public IDistributionGoods getDistributionGoodsService(Integer awardType) {
        return goodsMap.get(awardType);
    }

}
