package com.xiaomi.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import com.xiaomi.entity.Good;
import com.xiaomi.mapper.GoodMapper;
import com.xiaomi.service.GoodService;
import com.xiaomi.util.DBUtil;

class testGood {

	@Test
	void test() {
		GoodService service = new GoodService();
		List<Good> goodList = service.selectByGoodNameVagueLike("a");
		for(Good g:goodList) {
			System.out.println(g);
		}
	}
	
	@Test
	void test1() {
		GoodService service = new GoodService();
		List<Good> goodList = service.findGoodByGoodName("ะกรื5");
		System.out.println(goodList);
	}

}
