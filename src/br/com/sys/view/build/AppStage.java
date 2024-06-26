package br.com.sys.view.build;

import br.com.sys.controller.AppStart;
import br.com.sys.model.interfaces.Hook;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.WindowEvent;

public class AppStage extends AppStart {

	public static void load(AppView view) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(view.getURL());

			setScene(fxmlLoader.load());
			
			if (!stage.isShowing())
				stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static <T> void load(AppView view, Hook<T> hookController) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(view.getURL());

			setScene(fxmlLoader.load());
			hookController.hang(fxmlLoader.getController());

			if (!stage.isShowing())
				stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static <T> void loadAndWhenClose(AppView view, Hook<T> hookController) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(view.getURL());
			
			setScene(fxmlLoader.load());
			stage.setOnCloseRequest(e -> hookController.hang(fxmlLoader.getController()));

			
			if (!stage.isShowing())
				stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setTitle(String title) {
		stage.setTitle(title);
	}
	
	public static void close() {
		stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}
	
	private static void setScene(Parent parent) {
		if (stage.getScene() == null) {
			stage.setScene(new Scene(parent));				
		} else {
			double width = stage.getScene().getWidth();
			double height = stage.getScene().getHeight();
			stage.setScene(new Scene(parent, width, height));								
		}
		
		stage.getScene().getRoot().setStyle(AppStyle.getVars());
	}
}
