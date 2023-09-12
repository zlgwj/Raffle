package com.zlgewj.raffle.domain.strategy.service.draw;

import com.zlgewj.raffle.domain.strategy.model.req.DrawReq;
import com.zlgewj.raffle.domain.strategy.model.resp.DrawResp;

/**
 * 抽奖执行器
 *
 * @Author zlgewj
 * @Since 2023/9/8
 */

public interface IDrawExec {
    DrawResp doDrawExec(DrawReq req);
}
