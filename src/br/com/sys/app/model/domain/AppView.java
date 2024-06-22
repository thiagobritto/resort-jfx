package br.com.sys.app.model.domain;

import java.net.URL;

public enum AppView {

	HOME("/fxml/app/home.fxml");
	
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
