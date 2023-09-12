package com.zlgewj.raffle.infrastructure.dao;

import com.zlgewj.raffle.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author zlgewj
 * @Since 2023/9/6
 */
@Mapper
public interface IAwardDao {
    Award queryAward(@Param("awardId") String awardId);

}
