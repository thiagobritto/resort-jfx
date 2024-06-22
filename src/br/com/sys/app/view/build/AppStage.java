package br.com.sys.app.view.build;

import br.com.sys.app.controller.AppStart;
import br.com.sys.app.model.domain.AppView;
import br.com.sys.app.model.interfaces.HookController;
import br.com.sys.app.model.interfaces.HookStage;
import br.com.sys.app.model.interfaces.HookStageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class AppStage extends AppStart {

	public static void load(AppView view) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(view.getURL());

			if (stage.getScene() == null) {
				stage.setScene(new Scene(fxmlLoader.load()));				
			} else {
				double width = stage.getScene().getWidth();
				double height = stage.getScene().getHeight();
				stage.setScene(new Scene(fxmlLoader.load(), width,height));								
			}

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

			if (stage.getScene() == null) {
				stage.setScene(new Scene(fxmlLoader.load()));				
			} else {
				double width = stage.getScene().getWidth();
				double height = stage.getScene().getHeight();
				stage.setScene(new Scene(fxmlLoader.load(), width,height));								
			}

			hookStage.hang(modal);

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

			if (stage.getScene() == null) {
				stage.setScene(new Scene(fxmlLoader.load()));				
			} else {
				double width = stage.getScene().getWidth();
				double height = stage.getScene().getHeight();
				stage.setScene(new Scene(fxmlLoader.load(), width,height));								
			}

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

			if (stage.getScene() == null) {
				stage.setScene(new Scene(fxmlLoader.load()));				
			} else {
				double width = stage.getScene().getWidth();
				double height = stage.getScene().getHeight();
				stage.setScene(new Scene(fxmlLoader.load(), width,height));								
			}

			hookStageController.hang(stage, fxmlLoader.getController());

			if (!stage.isShowing())
				stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
