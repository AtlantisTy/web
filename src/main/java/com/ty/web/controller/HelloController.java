package com.ty.web.controller;

import com.ty.web.bo.HelloBO;
import com.ty.web.entity.GoodStoreInfo;
import com.ty.web.request.HelloRequest;
import com.ty.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author ext.tianyuan13
 * @email ext.tianyuan13@jd.com
 * @date 2023/7/18 11:01
 * @description
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @PostMapping("/test")
    public HelloBO hello (@RequestBody HelloRequest helloRequest){
        HelloBO helloBO = new HelloBO();
        helloBO.setMessage("success");
        return helloBO;
    }

    @PostMapping("/test2")
    public Boolean hello2(@RequestParam(name = "url") String url){
        return helloService.hello(url);
    }

    @PostMapping("/test3")
    public Boolean hello2(@RequestBody GoodStoreInfo goodStoreInfo,
                          @ModelAttribute("helloRequest") HelloRequest helloRequest){
        try {
            URL url = new URL("https://img14.360buyimg.com/btr/jfs/t1/159754/29/33543/83525/64f8744dF3e2c91ef/8ec29c5c64510069.jpg");
            url.openStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
