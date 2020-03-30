package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardListController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}