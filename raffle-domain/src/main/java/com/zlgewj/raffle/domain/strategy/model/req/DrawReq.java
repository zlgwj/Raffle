package com.zlgewj.raffle.domain.strategy.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 抽奖请求类
 *
 * @Author zlgewj
 * @Since 2023/9/8
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DrawReq {

    private String userId;
    private Long strategyId;


}
