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

			stage.setScene(new Scene(fxmlLoader.load()));

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

			stage.setScene(new Scene(fxmlLoader.load()));
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

			stage.setScene(new Scene(fxmlLoader.load()));
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

			stage.setScene(new Scene(fxmlLoader.load()));
			hookStageController.hang(stage, fxmlLoader.getController());

			if (!stage.isShowing())
				stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
