package br.com.sys.view.build;

public class AppStyle {

	private static String cssVars = ""
			+ "-fx-color-1: #4F2263;"
			+ "-fx-color-2: #895AA8;"
			+ "-fx-color-3: #E3DADD;"
			+ "-fx-color-4: #7D8A80;"
			+ "-fx-color-5: #E3C4B0;"
			+ "-fx-fill-1: #FFFFFFFF;";

	public static void setVar(String key, String value) {
		cssVars += key + ":" + value + ";";		
	}
	
	public static String getVars() {
		return cssVars;		
	}

}
