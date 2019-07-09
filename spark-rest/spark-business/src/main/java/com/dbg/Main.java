package com.dbg;


import com.dbg.controller.test.Controllers;

public class Main {

	private static Controllers controllers;
	

	public static void main(String[] args) {
		init();
		
	}

	private static void init() {
		setTestController(new Controllers());
		
	}

	public static Controllers getTestController() {
		return controllers;
	}

	public static void setTestController(Controllers testController) {
		Main.controllers = testController;
	}

}
