package com.ty.web.service;

import com.ty.web.es.doc.GoodsDoc;

/**
 * @author ext.tianyuan13
 * @email ext.tianyuan13@jd.com
 * @date 2023/7/19 10:56
 * @description
 */
public interface GoodsService {
    GoodsDoc search(GoodsDoc goodsDoc);
}
