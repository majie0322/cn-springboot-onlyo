package cn.boot.onlyo.shiro.factory;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

	public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
		LinkedHashMap<String, String> map = new LinkedHashMap<>();

		map.put("/shiro/t1","anon");
		map.put("/src/main/webapp/view/login.jsp", "anon");
		map.put("/shiro/login", "anon");
		map.put("/shiro/logout", "logout");
		map.put("/src/main/webapp/view/user.jsp", "authc,roles[user]");
		map.put("/src/main/webapp/view/admin.jsp", "authc,roles[admin]");
		map.put("/src/main/webapp/view/list.jsp", "user");

		map.put("/**", "authc");
		
		return map;
	}
	
}
