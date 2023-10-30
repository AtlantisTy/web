package com.ty.web.service.impl;

import com.ty.web.bo.FutureBo;
import com.ty.web.bo.PotentialStoresIdBO;
import com.ty.web.bo.QueryPotentialStores;
import com.ty.web.mapper.GoodStoreInfoMapper;
import com.ty.web.service.GoodStoreInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author ext.tianyuan13
 * @email ext.tianyuan13@jd.com
 * @date 2023/7/19 10:57
 * @description
 */
@Service
@Slf4j
public class GoodStoreInfoServiceImpl implements GoodStoreInfoService {

    @Autowired
    private GoodStoreInfoMapper goodStoreInfoMapper;

    @Override
    public Long queryPotentialStoresUnBrowseCount(QueryPotentialStores queryPotentialStores) {
        Long aLong = goodStoreInfoMapper.queryPotentialStoresUnBrowseCount(queryPotentialStores);
        return aLong;
    }

    @Override
    public Long queryPotentialStoresBrowseUnAddcartCount(QueryPotentialStores queryPotentialStores) {
        return goodStoreInfoMapper.queryPotentialStoresBrowseUnAddcartCount(queryPotentialStores);
    }

    @Override
    public Long queryPotentialStoresAddcartUnPaymentCount(QueryPotentialStores queryPotentialStores) {
        return goodStoreInfoMapper.queryPotentialStoresBrowseUnAddcartCount(queryPotentialStores);
    }

    @Override
    public Long queryPotentialStoresPaymentCount(QueryPotentialStores queryPotentialStores) {
        return goodStoreInfoMapper.queryPotentialStoresBrowseUnAddcartCount(queryPotentialStores);
    }

    @Override
    public List<Integer> queryPotentialStoresUnBrowse(QueryPotentialStores queryPotentialStores) {
        return goodStoreInfoMapper.queryPotentialStoresUnBrowse(queryPotentialStores);
    }

    @Override
    public List<Integer> queryPotentialStoresBrowseUnAddcart(QueryPotentialStores queryPotentialStores) {
        return goodStoreInfoMapper.queryPotentialStoresBrowseUnAddcart(queryPotentialStores);
    }

    @Override
    public List<Integer> queryPotentialStoresAddcartUnPayment(QueryPotentialStores queryPotentialStores) {
        return goodStoreInfoMapper.queryPotentialStoresAddcartUnPayment(queryPotentialStores);
    }

    @Override
    public List<Integer> queryPotentialStoresPayment(QueryPotentialStores queryPotentialStores) {
        return goodStoreInfoMapper.queryPotentialStoresPayment(queryPotentialStores);
    }

    @Override
    public List<PotentialStoresIdBO> potentialStoresCountBySkuId(QueryPotentialStores queryPotentialStores) {
        return goodStoreInfoMapper.potentialStoresCountBySkuId(queryPotentialStores);
    }

    @Override
    public FutureBo future() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("多线程测试");
        FutureBo futureBo = new FutureBo();
        try {
            CompletableFuture<Integer> completableFutureA = CompletableFuture.supplyAsync(()->{
                try {
                    Thread.sleep(3*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return 1;
            });
            CompletableFuture<Integer> completableFutureB = CompletableFuture.supplyAsync(()->{
                try {
                    Thread.sleep(2*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return 2;
            });

            CompletableFuture.allOf(completableFutureA, completableFutureB);
            Integer a = completableFutureA.get(5,TimeUnit.SECONDS);
            futureBo.setA(a);
            Integer b = completableFutureB.get(5,TimeUnit.SECONDS);
            futureBo.setB(b);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
        }
        stopWatch.stop();
        log.info("总耗时:{}秒",stopWatch.getTotalTimeSeconds());
        log.info("--end--");
        return futureBo;
    }

    @Override
    public FutureBo futureContinuous() {
        FutureBo futureBo = new FutureBo();
        try {
            CompletableFuture<Integer> completableFutureA = CompletableFuture.supplyAsync(()->{
                System.out.println("开始1");
                try {
                    Thread.sleep(2*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return 1;
            }).thenApplyAsync(a->{
                System.out.println("开始+1");
                try {
                    Thread.sleep(1*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return a+1;
            });
            Integer i = completableFutureA.get();
            futureBo.setA(i);
        }catch (Exception e){
            log.error("Exception");
        }
        return futureBo;
    }

    @Override
    public List<FutureBo> foreach() {
        List<FutureBo> list = new ArrayList<>();
        for (int i = 0 ; i < 9 ;i++){
            FutureBo futureBo = new FutureBo();
            list.add(futureBo);
        }

        List<CompletableFuture> futures = new ArrayList();
        for (FutureBo futureBo:list){
            int i = 0;
            int finalI = i;
            futures.add(CompletableFuture.runAsync(()->{
                futureBo.setA(1);
                futureBo.setB(2);
                System.out.println("当前执行"+ finalI);
                System.out.println("当前执行"+System.currentTimeMillis());
                }
            ));
            i++;
        }
        CompletableFuture.allOf(futures.toArray(new  CompletableFuture[futures.size()])).join();
        System.out.println("执行完毕"+System.currentTimeMillis());
        return list;
    }
}
