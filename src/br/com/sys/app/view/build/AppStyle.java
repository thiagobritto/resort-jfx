package br.com.sys.app.view.build;

public class AppStyle {

	private static String cssVars = ""
			+ "-fx-color-1: red;"
			+ "-fx-color-2: blue;";

	public static void setVar(String key, String value) {
		cssVars += key + ":" + value + ";";		
	}
	
	public static String getVars() {
		return cssVars;		
	}

}
