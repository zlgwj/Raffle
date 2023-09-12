package com.zlgewj.raffle.domain.award.model.vo;

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
public class ShippingAddress {

    private String name;

    private String provinceId;

    private String provinceName;

    private String cityId;

    private String cityName;

    private String countyId;

    private String countyName;

    private String townId;

    private String townName;

    private String address;

    private String phone;

    private String email;

    private String remark;

}
