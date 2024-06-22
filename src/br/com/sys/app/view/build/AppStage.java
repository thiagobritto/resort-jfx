package br.com.sys.app.view.build;

import br.com.sys.app.controller.AppStart;
import br.com.sys.app.model.domain.AppView;
import br.com.sys.app.model.interfaces.HookController;
import br.com.sys.app.model.interfaces.HookStage;
import br.com.sys.app.model.interfaces.HookStageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

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

	public static void load(AppView view, HookStage hookStage) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(view.getURL());

			setScene(fxmlLoader.load());		
			hookStage.hang(stage);

			if (!stage.isShowing())
				stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static <T> void load(AppView view, HookController<T> hookController) {
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

	public static <T> void load(AppView view, HookStageController<T> hookStageController) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(view.getURL());

			setScene(fxmlLoader.load());
			hookStageController.hang(stage, fxmlLoader.getController());

			if (!stage.isShowing())
				stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setTitle(String title) {
		stage.setTitle(title);
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
