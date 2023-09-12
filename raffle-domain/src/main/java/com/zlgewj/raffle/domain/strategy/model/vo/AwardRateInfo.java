package com.zlgewj.raffle.domain.strategy.model.vo;

import com.zlgewj.raffle.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 奖品概率信息
 *
 * @Author zlgewj
 * @Since 2023/9/8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwardRateInfo {

    private String awardId;

    private BigDecimal awardRate;


}
