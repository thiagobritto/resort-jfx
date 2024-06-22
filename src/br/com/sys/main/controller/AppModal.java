package br.com.sys.main.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class AppModal extends AppStart {

	public static void load(AppView view) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(view.getURL());
			
			modal.setScene(new Scene(fxmlLoader.load()));
			modal.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static <T> void load(AppView view, ViewController<T> vc) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(view.getURL());
			
			modal.setScene(new Scene(fxmlLoader.load()));
			vc.up(modal, fxmlLoader.getController());
			modal.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
