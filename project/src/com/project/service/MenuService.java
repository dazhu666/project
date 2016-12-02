package com.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.dao.MenuDao;
import com.project.model.Menu;
import com.project.utils.DateUtil;

public class MenuService {
	public List<Map<String, Object>> getMenu(){
		List<Map<String, Object>> list=new ArrayList<>();
		MenuDao dao=new MenuDao();
		List<Menu> menuList=dao.getMenuList();
		for (Menu menu : menuList) {
			Map<String, Object> rs=new HashMap<>();
			rs.put("id", menu.getId());
			rs.put("title", menu.getTitle());
			rs.put("code", menu.getCode());
			rs.put("parentNode", menu.getParentNode());
			rs.put("haveChild", menu.isHaveChild());
			rs.put("link", menu.getLink());
			rs.put("dateCreated", DateUtil.Format(menu.getDateCreated()));
			rs.put("lastUpdated", DateUtil.Format(menu.getLastUpdated()));
			rs.put("rank", menu.getRank());
			list.add(rs);
		}
		return list;
	}

}
