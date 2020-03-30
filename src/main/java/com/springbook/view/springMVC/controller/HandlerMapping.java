package com.springbook.view.springMVC.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.springMVC.board.DeleteBoardController;
import com.springbook.view.springMVC.board.GetBoardController;
import com.springbook.view.springMVC.board.GetBoardListController;
import com.springbook.view.springMVC.board.InsertBoardController;
import com.springbook.view.springMVC.board.UpdateBoardController;
import com.springbook.view.springMVC.user.LoginController;
import com.springbook.view.springMVC.user.LogoutController;
 
public class HandlerMapping {
	private Map<String, Controller> mappings;
	  
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
		
	}
	 
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
