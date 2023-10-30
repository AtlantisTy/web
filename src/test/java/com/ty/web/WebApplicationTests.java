package com.ty.web;

import com.ty.web.bo.PotentialStoresIdBO;
import com.ty.web.bo.QueryPotentialStores;
import com.ty.web.mapper.GoodStoreInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class WebApplicationTests {

	@Autowired
	private GoodStoreInfoMapper goodStoreInfoMapper;

	@Test
	void contextLoads() {
		QueryPotentialStores queryPotentialStores = new QueryPotentialStores();
		List<Integer> skuIds = new ArrayList<>();
		skuIds.add(10001);
		queryPotentialStores.setSkuIds(skuIds);
		List<PotentialStoresIdBO> maps = goodStoreInfoMapper.potentialStoresCountBySkuId(queryPotentialStores);
		System.out.println("xx");

	}

}
