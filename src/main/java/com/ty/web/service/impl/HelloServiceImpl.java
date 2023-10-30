package com.ty.web.service.impl;

import com.ty.web.bo.FutureBo;
import com.ty.web.bo.PotentialStoresIdBO;
import com.ty.web.bo.QueryPotentialStores;
import com.ty.web.mapper.GoodStoreInfoMapper;
import com.ty.web.service.GoodStoreInfoService;
import com.ty.web.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.net.HttpURLConnection;
import java.net.URL;
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
public class HelloServiceImpl implements HelloService {

    @Override
    public Boolean hello(String url) {
        return isImagesTrue(url);
    }

    public static Boolean isImagesTrue(String imgUrl) {
        Integer RESPONSE_CODE = 0;
        try {
            URL url = new URL(imgUrl);
            HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
            RESPONSE_CODE = urlcon.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (RESPONSE_CODE == HttpURLConnection.HTTP_OK) {
            System.out.println("posted ok!");
            return true;
        } else {
            System.out.println("Bad post...");
            return false;
        }
    }
}
