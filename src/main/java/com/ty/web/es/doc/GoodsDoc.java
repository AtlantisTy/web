package com.ty.web.es.doc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author ext.tianyuan13
 * @email ext.tianyuan13@jd.com
 * @date 2023/8/7 11:50
 * @description
 */
@Document(indexName = "student",createIndex = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDoc {

    @Id
    private Long id;

    //标题 使用ik进行分词
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;

    //品牌 不被分词
    @Field(type=FieldType.Keyword)
    private String brand;

    //价格
    @Field(type=FieldType.Double)
    private Double price;

    //图片 不被分词，且不创建索引
    @Field(index = false,type = FieldType.Keyword)
    private String images;
}
