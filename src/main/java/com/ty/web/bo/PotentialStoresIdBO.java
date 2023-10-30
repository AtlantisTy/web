package com.ty.web.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ext.tianyuan13
 * @email ext.tianyuan13@jd.com
 * @date 2023/7/18 11:01
 * @description
 */
@Data
public class PotentialStoresIdBO implements Serializable {

    private Integer skuId;
    private Long storeCount;

}
