package com.ty.web.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangquanli5
 * @name GoodStoreInfo
 * @date 2023-07-18  10:29
 * @description GoodStoreInfo
 */
@Data
public class GoodStoreInfo implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * skuId
     */
    private Long skuId;

    /**
     * 门店Id
     */
    private Long storeId;

    /**
     * 浏览次数
     */
    private Long pv;

    /**
     * 周期:0今天,1昨日,7近七天,30近30天
     */
    private Integer period;

    /**
     * dt，大数据推送时间
     */
    private Date dt;

    /**
     * 加车数
     */
    private Long addCart;

    /**
     * 支付数
     */
    private Long payment;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 修改时间
     */
    private Date modified;

}
