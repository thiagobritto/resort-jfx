package br.com.sys.main.controller;

import java.net.URL;

public enum AppView {

	HOME("/fxml/reserve/home.fxml");
	
	private String path;
	
	private AppView(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return getClass().getResource(path).getFile();
	}
	
	public URL getURL() {
		return getClass().getResource(path);
	}
}
