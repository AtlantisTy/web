package com.ty.web.mapper;

import com.ty.web.bo.PotentialStoresIdBO;
import com.ty.web.bo.QueryPotentialStores;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangquanli5
 * @name GoodStoreInfoMapper
 * @date 2023-07-18  10:35
 * @description GoodStoreInfoMapper
 */
@Mapper
public interface GoodStoreInfoMapper{

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
    List<PotentialStoresIdBO> potentialStoresCountBySkuId(@Param("queryPotentialStores") QueryPotentialStores queryPotentialStores);

}
