package br.com.sys.main.window;

import java.net.URL;

public enum AppView {

	HOME("/fxml/admin/dashboard.fxml"),
	CLIENT_MANAGE("/fxml/client/manage.fxml"),
	RESORT_ROOM("/fxml/resort/room.fxml");
	
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
