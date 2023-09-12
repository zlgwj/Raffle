package com.zlgewj.raffle.domain.strategy.model.resp;

import com.zlgewj.raffle.common.Constants;
import com.zlgewj.raffle.domain.strategy.model.vo.DrawAwardInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 抽奖响应类
 *
 * @Author zlgewj
 * @Since 2023/9/8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DrawResp {

    private String userId;

    private Long strategyId;

    private Integer drawState = Constants.DrawState.FAIL.getCode();

    private DrawAwardInfo drawAwardInfo;
}
