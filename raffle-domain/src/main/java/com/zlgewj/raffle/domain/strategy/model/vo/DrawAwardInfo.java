package com.zlgewj.raffle.domain.strategy.model.vo;

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
public class DrawAwardInfo {

    private String awardId;

    private Integer awardType;

    private String awardName;

    private String awardContent;
}
