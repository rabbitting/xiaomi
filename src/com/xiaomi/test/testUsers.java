package com.xiaomi.test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

import com.xiaomi.entity.Users;
import com.xiaomi.service.UsersService;
import com.xiaomi.util.CommonUtil;

import net.sf.json.JSONObject;


class testUsers {

	@Test
	void test() {
		Users user = new Users("addd", "123456", "123456", "123456", "123456", "123456");
	}
	
	@Test
	void test1() {
		UsersService service = new UsersService();
		Users user = service.findUsersById(1);
		System.out.println(user);
	}
	
	@Test
	void test2() {
		UsersService service = new UsersService();
		Users user = service.findUsersById(1);
		user.setPassword("123456");
		service.updateUsers(user);
	}
	

}
