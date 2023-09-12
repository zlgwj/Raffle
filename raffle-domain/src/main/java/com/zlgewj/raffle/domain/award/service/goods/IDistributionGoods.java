package com.zlgewj.raffle.domain.award.service.goods;

import com.zlgewj.raffle.domain.award.model.req.GoodsReq;
import com.zlgewj.raffle.domain.award.model.resp.DistributionResp;

/**
 * @Author zlgewj
 * @Since 2023/9/9
 */

public interface IDistributionGoods {

    DistributionResp doDistribution(GoodsReq goodsReq);

    Integer getDistributionGoodsName();

}
