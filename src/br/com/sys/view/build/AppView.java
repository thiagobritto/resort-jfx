package br.com.sys.view.build;

import java.net.URL;

public enum AppView {

	HOME("/fxml/home.fxml"),
	CLIENT_MANAGE("/fxml/client/manage.fxml");
	
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
