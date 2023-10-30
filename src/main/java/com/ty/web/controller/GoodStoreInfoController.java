package com.ty.web.controller;

import com.ty.web.bo.FutureBo;
import com.ty.web.bo.HelloBO;
import com.ty.web.bo.PotentialStoresIdBO;
import com.ty.web.bo.QueryPotentialStores;
import com.ty.web.request.HelloRequest;
import com.ty.web.service.GoodStoreInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author ext.tianyuan13
 * @email ext.tianyuan13@jd.com
 * @date 2023/7/18 11:01
 * @description
 */
@RestController
@RequestMapping("/good")
@Slf4j
public class GoodStoreInfoController {

    @Autowired
    private GoodStoreInfoService goodStoreInfoService;

    @PostMapping("/queryPotentialStoresUnBrowseCount")
    public Long queryPotentialStoresUnBrowseCount (@RequestBody QueryPotentialStores queryPotentialStores){
        Long aLong = goodStoreInfoService.queryPotentialStoresUnBrowseCount(queryPotentialStores);
        return aLong;
    }

    @PostMapping("/queryPotentialStoresBrowseUnAddcartCount")
    public Long queryPotentialStoresBrowseUnAddcartCount(@RequestBody QueryPotentialStores queryPotentialStores) {
        return goodStoreInfoService.queryPotentialStoresBrowseUnAddcartCount(queryPotentialStores);
    }

    @PostMapping("queryPotentialStoresAddcartUnPaymentCount")
    public Long queryPotentialStoresAddcartUnPaymentCount(@RequestBody QueryPotentialStores queryPotentialStores) {
        return goodStoreInfoService.queryPotentialStoresAddcartUnPaymentCount(queryPotentialStores);
    }

    @PostMapping("/queryPotentialStoresPaymentCount")
    public Long queryPotentialStoresPaymentCount(@RequestBody QueryPotentialStores queryPotentialStores) {
        return goodStoreInfoService.queryPotentialStoresPaymentCount(queryPotentialStores);
    }

    @PostMapping("/queryPotentialStoresUnBrowse")
    public List<Integer> queryPotentialStoresUnBrowse(@RequestBody QueryPotentialStores queryPotentialStores) {
        return goodStoreInfoService.queryPotentialStoresUnBrowse(queryPotentialStores);
    }

    @PostMapping("/queryPotentialStoresBrowseUnAddcart")
    public List<Integer> queryPotentialStoresBrowseUnAddcart(@RequestBody QueryPotentialStores queryPotentialStores) {
        return goodStoreInfoService.queryPotentialStoresBrowseUnAddcart(queryPotentialStores);
    }

    @PostMapping("/queryPotentialStoresAddcartUnPayment")
    public List<Integer> queryPotentialStoresAddcartUnPayment(@RequestBody QueryPotentialStores queryPotentialStores) {
        return goodStoreInfoService.queryPotentialStoresAddcartUnPayment(queryPotentialStores);
    }

    @PostMapping("/queryPotentialStoresPayment")
    public List<Integer> queryPotentialStoresPayment(@RequestBody QueryPotentialStores queryPotentialStores) {
        return goodStoreInfoService.queryPotentialStoresPayment(queryPotentialStores);
    }

    @PostMapping("/potentialStoresCountBySkuId")
    public List<PotentialStoresIdBO> potentialStoresCountBySkuId(@RequestBody QueryPotentialStores queryPotentialStores) {
        return goodStoreInfoService.potentialStoresCountBySkuId(queryPotentialStores);
    }

    @PostMapping("/future")
    public FutureBo future(){
        long sec1 = System.currentTimeMillis()/1000;
        FutureBo future = goodStoreInfoService.future();
        long sec2 = System.currentTimeMillis()/1000;
        log.info("future耗时:"+(sec2-sec1));
        return future;
    }

    @PostMapping("/futureContinuous")
    public FutureBo futureContinuous(){
        long sec1 = System.currentTimeMillis()/1000;
        FutureBo future = goodStoreInfoService.futureContinuous();
        long sec2 = System.currentTimeMillis()/1000;
        log.info("future耗时:"+(sec2-sec1));
        return future;
    }

    @PostMapping("/foreach")
    public List<FutureBo> foreach(){
        long sec1 = System.currentTimeMillis()/1000;
        List<FutureBo> list = goodStoreInfoService.foreach();
        long sec2 = System.currentTimeMillis()/1000;
        log.info("future耗时:"+(sec2-sec1));
        return list;
    }

    /**
     * 测试线程阻塞等待
     * 当一个请求阻塞时，新的请求会等待，等待一段时间后。会重新进入方法
     * 不同请求暂未发现阻塞
     * @throws Exception
     */
    @GetMapping("/foreach_ever")
    public void foreachEver() throws Exception{
        long sec1 = System.currentTimeMillis()/1000;
        while (true){
            Thread.sleep(5000);
            System.out.println(System.currentTimeMillis());
        }
    }
}
