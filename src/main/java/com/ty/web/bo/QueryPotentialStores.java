package com.ty.web.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ext.tianyuan13
 * @email ext.tianyuan13@jd.com
 * @date 2023/7/18 10:56
 * @description 查询潜力门店请求参数
 */
@Data
public class QueryPotentialStores implements Serializable {

    private static final long serialVersionUID = 6895087787100246495L;

    /*
     *商品Id
     */
    private String skuId;

    /*
     *商品Id集合
     */
    private List<Integer> skuIds;

    /*
     *时期 （0-当天；1-昨日；7-近七天；30-近30天）
     */
    private Integer period;

    /*
     *单品潜力门店Tab页分类 (1-未浏览；2-浏览未加车；3-加车未下单；4-已支付)
     */
    private Integer tabType;

}
