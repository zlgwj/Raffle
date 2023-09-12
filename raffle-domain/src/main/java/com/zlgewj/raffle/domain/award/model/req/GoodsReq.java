package com.zlgewj.raffle.domain.award.model.req;

import com.zlgewj.raffle.domain.award.model.vo.ShippingAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zlgewj
 * @Since 2023/9/9
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsReq {

    private String uId;

    private String orderId;

    private String awardId;

    private String awardName;

    private String awardContent;

    private ShippingAddress shippingAddress;

    private String extInfo;

    public GoodsReq(String uId, String orderId, String awardId, String awardName, String awardContent) {
        this.uId = uId;
        this.orderId = orderId;
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardContent = awardContent;
    }

    public GoodsReq(String uId, String orderId, String awardId, String awardName, String awardContent, ShippingAddress shippingAddress) {
        this.uId = uId;
        this.orderId = orderId;
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardContent = awardContent;
        this.shippingAddress = shippingAddress;
    }
}
