package br.com.sys.main.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class AppStage extends AppStart {

	public static void load(AppView view) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(view.getURL());
			
			stage.setScene(new Scene(fxmlLoader.load()));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static <T> void load(AppView view, ViewController<T> vc) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(view.getURL());
			
			stage.setScene(new Scene(fxmlLoader.load()));
			vc.up(stage, fxmlLoader.getController());
			stage.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
