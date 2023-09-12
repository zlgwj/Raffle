package com.zlgewj.raffle.domain.strategy.model.aggregates;

import com.zlgewj.raffle.infrastructure.po.Strategy;
import com.zlgewj.raffle.infrastructure.po.StrategyDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author zlgewj
 * @Since 2023/9/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StrategyRich {
    private Long strategyId;

    private Strategy strategy;

    private List<StrategyDetail> strategyDetailList;

}
