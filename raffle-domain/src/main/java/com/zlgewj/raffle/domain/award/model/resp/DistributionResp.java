package com.zlgewj.raffle.domain.award.model.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zlgewj
 * @Since 2023/9/9
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DistributionResp {

    private String uId;

    private Integer code;

    private String info;

    private String statementId;

    public DistributionResp(String uId, Integer code, String info) {
        this.uId = uId;
        this.code = code;
        this.info = info;
    }
}
