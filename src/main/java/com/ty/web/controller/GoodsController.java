package com.ty.web.controller;

import com.ty.web.bo.HelloBO;
import com.ty.web.es.doc.GoodsDoc;
import com.ty.web.request.HelloRequest;
import com.ty.web.service.GoodsService;
import com.ty.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ext.tianyuan13
 * @email ext.tianyuan13@jd.com
 * @date 2023/7/18 11:01
 * @description
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/search")
    public GoodsDoc search (@RequestBody GoodsDoc goodsDoc){
        return goodsService.search(goodsDoc);
    }
}
