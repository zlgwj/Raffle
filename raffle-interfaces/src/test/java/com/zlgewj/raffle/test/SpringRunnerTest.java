package com.zlgewj.raffle.test;

import com.alibaba.fastjson.JSON;
import com.zlgewj.raffle.common.Constants;
import com.zlgewj.raffle.domain.award.model.req.GoodsReq;
import com.zlgewj.raffle.domain.award.model.resp.DistributionResp;
import com.zlgewj.raffle.domain.award.service.factory.DistributionGoodsFactory;
import com.zlgewj.raffle.domain.award.service.goods.IDistributionGoods;
import com.zlgewj.raffle.domain.strategy.model.req.DrawReq;
import com.zlgewj.raffle.domain.strategy.model.resp.DrawResp;
import com.zlgewj.raffle.domain.strategy.model.vo.DrawAwardInfo;
import com.zlgewj.raffle.domain.strategy.service.draw.IDrawExec;
import com.zlgewj.raffle.infrastructure.dao.IActivityDao;
import com.zlgewj.raffle.infrastructure.po.Activity;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author zlgewj
 * @Since 2023/9/8
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRunnerTest {


    @Resource
    private IActivityDao activityDao;

    @Resource
    private IDrawExec drawExec;
    @Resource
    private DistributionGoodsFactory distributionGoodsFactory;

    @Test
    public void test_drawExec() {
        DrawResp d1= drawExec.doDrawExec(new DrawReq("小傅哥", 1L));
        DrawResp d2 = drawExec.doDrawExec(new DrawReq("小佳佳", 1L));
        DrawResp d3 = drawExec.doDrawExec(new DrawReq("小蜗牛", 1L));
        DrawResp d4 = drawExec.doDrawExec(new DrawReq("八杯水", 1L));
    }

    @Test
    public void test_insert() {
        Activity activity = new Activity();
        activity.setActivityId(100001L);
        activity.setActivityName("测试活动");
        activity.setActivityDesc("仅用于插入数据测试");
        activity.setBeginDateTime(new Date());
        activity.setEndDateTime(new Date());
        activity.setStockCount(100);
        activity.setTakeCount(10);
        activity.setState(0);
        activity.setCreator("xiaofuge");
    }

    @Test
    public void test_select() {
        DrawResp drawResult = drawExec.doDrawExec(new DrawReq("小傅哥", 10001L));

        // 判断抽奖结果
        Integer drawState = drawResult.getDrawState();
        if (Constants.DrawState.FAIL.getCode().equals(drawState)) {
            System.out.println("未中奖");
            return;
        }

        // 封装发奖参数，orderId：2109313442431 为模拟ID，需要在用户参与领奖活动时生成
        DrawAwardInfo drawAwardInfo = drawResult.getDrawAwardInfo();
        GoodsReq goodsReq = new GoodsReq(drawResult.getUserId(), "2109313442431", drawAwardInfo.getAwardId(), drawAwardInfo.getAwardName(), drawAwardInfo.getAwardContent());

        // 根据 awardType 从抽奖工厂中获取对应的发奖服务
        IDistributionGoods distributionGoodsService = distributionGoodsFactory.getDistributionGoodsService(drawAwardInfo.getAwardType());
        DistributionResp distributionRes = distributionGoodsService.doDistribution(goodsReq);
        log.info("测试结果:{}", JSON.toJSONString(distributionRes));


    }

}