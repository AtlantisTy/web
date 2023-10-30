package com.ty.web.service;

import com.ty.web.bo.FutureBo;
import com.ty.web.bo.PotentialStoresIdBO;
import com.ty.web.bo.QueryPotentialStores;

import java.util.List;

/**
 * @author ext.tianyuan13
 * @email ext.tianyuan13@jd.com
 * @date 2023/7/19 10:56
 * @description
 */
public interface GoodStoreInfoService {

    /**
     * 查询单品潜力门店Tab-未浏览总数
     *
     * @param queryPotentialStores 查询单品潜力门店Tab-未浏览总数
     * @return {@link Long}
     */
    Long queryPotentialStoresUnBrowseCount(QueryPotentialStores queryPotentialStores);

    /**
     * 查询单品潜力门店Tab-浏览未加车总数
     *
     * @param queryPotentialStores 查询单品潜力门店Tab-浏览未加车总数
     * @return {@link Long}
     */
    Long queryPotentialStoresBrowseUnAddcartCount(QueryPotentialStores queryPotentialStores);

    /**
     * 查询单品潜力门店Tab-加车未下单总数
     *
     * @param queryPotentialStores 查询单品潜力门店Tab-加车未下单总数
     * @return {@link Long}
     */
    Long queryPotentialStoresAddcartUnPaymentCount(QueryPotentialStores queryPotentialStores);

    /**
     * 查询单品潜力门店Tab-已支付总数
     *
     * @param queryPotentialStores 查询单品潜力门店Tab-已支付总数
     * @return {@link Long}
     */
    Long queryPotentialStoresPaymentCount(QueryPotentialStores queryPotentialStores);

    /**
     * 查询单品潜力门店Tab-未浏览店铺id
     *
     * @param queryPotentialStores 查询单品潜力门店Tab-未浏览店铺id
     * @return {@link Integer}
     */
    List<Integer> queryPotentialStoresUnBrowse(QueryPotentialStores queryPotentialStores);

    /**
     * 查询单品潜力门店Tab-浏览未加车店铺id
     *
     * @param queryPotentialStores 查询单品潜力门店Tab-浏览未加车店铺id
     * @return {@link Integer}
     */
    List<Integer> queryPotentialStoresBrowseUnAddcart(QueryPotentialStores queryPotentialStores);

    /**
     * 查询单品潜力门店Tab-加车未下单店铺id
     *
     * @param queryPotentialStores 查询单品潜力门店Tab-加车未下单店铺id
     * @return {@link Integer}
     */
    List<Integer> queryPotentialStoresAddcartUnPayment(QueryPotentialStores queryPotentialStores);

    /**
     * 查询单品潜力门店Tab-已支付商品id
     *
     * @param queryPotentialStores 查询单品潜力门店Tab-已支付店铺id
     * @return {@link Integer}
     */
    List<Integer> queryPotentialStoresPayment(QueryPotentialStores queryPotentialStores);

    /**
     * 根据skuId统计对应的单品潜力门店(浏览未加车门店数+加车未下单门店数)
     *
     * @param queryPotentialStores 根据skuId统计对应的单品潜力门店(浏览未加车门店数+加车未下单门店数)
     * @return {@link Long}
     */
    List<PotentialStoresIdBO> potentialStoresCountBySkuId(QueryPotentialStores queryPotentialStores);


    FutureBo future();

    FutureBo futureContinuous();

    List<FutureBo> foreach();
}
