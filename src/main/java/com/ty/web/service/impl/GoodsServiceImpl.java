package com.ty.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ty.web.es.doc.GoodsDoc;
import com.ty.web.service.GoodsService;
import com.ty.web.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author ext.tianyuan13
 * @email ext.tianyuan13@jd.com
 * @date 2023/7/19 10:57
 * @description
 */
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public GoodsDoc search(GoodsDoc goodsDoc) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (goodsDoc != null){
            if (goodsDoc.getTitle() != null){
                boolQueryBuilder.must(QueryBuilders.termQuery("title", goodsDoc.getTitle()));
            }
            if (goodsDoc.getBrand() != null){
                boolQueryBuilder.must(QueryBuilders.termQuery("brand", goodsDoc.getBrand()));
            }
            if (goodsDoc.getPrice() != null){
                boolQueryBuilder.must(QueryBuilders.rangeQuery("price").gte(goodsDoc.getPrice()));
            }
        }

        Query query = new NativeSearchQueryBuilder().withQuery(boolQueryBuilder).build();
        SearchHits<GoodsDoc> search = elasticsearchRestTemplate.search(query, GoodsDoc.class);

        log.info("Es search->{}", JSONObject.toJSONString(search, SerializerFeature.WriteMapNullValue));
        if (search != null && !CollectionUtils.isEmpty(search.getSearchHits())){
            return search.getSearchHit(0).getContent();
        }
        return null;
    }
}
