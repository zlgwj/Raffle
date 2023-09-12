package com.zlgewj.raffle.domain.strategy.service.draw;

import com.zlgewj.raffle.domain.strategy.model.aggregates.StrategyRich;
import com.zlgewj.raffle.domain.strategy.model.req.DrawReq;
import com.zlgewj.raffle.domain.strategy.model.resp.DrawResp;
import com.zlgewj.raffle.domain.strategy.model.vo.AwardRateInfo;
import com.zlgewj.raffle.domain.strategy.model.vo.DrawAwardInfo;
import com.zlgewj.raffle.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.zlgewj.raffle.infrastructure.po.Award;
import com.zlgewj.raffle.infrastructure.po.StrategyDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zlgewj
 * @Since 2023/9/8
 */

public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec{

    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList) {
        if (1 != strategyMode) {
            return;
        }
        IDrawAlgorithm iDrawAlgorithm = map.get(strategyMode);
        boolean inited = iDrawAlgorithm.isInited(strategyId);
        if (inited) {
            return;
        }

        ArrayList<AwardRateInfo> awardRateInfos = new ArrayList<>(strategyDetailList.size());

        for (StrategyDetail strategyDetail : strategyDetailList) {
            awardRateInfos.add(new AwardRateInfo(strategyDetail.getAwardId(),strategyDetail.getAwardRate()));
        }
        iDrawAlgorithm.initRateTuple(strategyId,awardRateInfos);

    }

    @Override
    public DrawResp doDrawExec(DrawReq req) {
        StrategyRich strategyRich = this.queryStrategyRich(req.getStrategyId());
        List<String> excludedAwardsIds = this.queryExcludedAwardsIds(req.getStrategyId());

        checkAndInitRateData(strategyRich.getStrategyId(),strategyRich.getStrategy().getStrategyMode(), strategyRich.getStrategyDetailList());

        String s = this.drawAlgorithm(req.getStrategyId(),
                map.get(strategyRich.getStrategy().getStrategyMode()),
                excludedAwardsIds);

        Award award = this.queryAwardInfo(s);

        return DrawResp.builder()
                .userId(req.getUserId())
                .strategyId(req.getStrategyId())
                .drawAwardInfo(new DrawAwardInfo(award.getAwardId(), award.getAwardType(), award.getAwardName(), award.getAwardContent()))
                .build();
    }

    protected abstract List<String> queryExcludedAwardsIds(Long strategyId);

    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludedAwards);
}
