package br.com.sys.app.view.build;

import br.com.sys.app.controller.AppStart;
import br.com.sys.app.model.domain.AppView;
import br.com.sys.app.model.interfaces.HookController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.WindowEvent;

public class AppModal extends AppStart {

	public static void load(AppView view) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(view.getURL());
			
			setScene(fxmlLoader.load());
			
			if (!modal.isShowing())
				modal.show();
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
			
			if (!modal.isShowing())
				modal.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static <T> void loadAndWhenClose(AppView view, HookController<T> hookController) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(view.getURL());
			
			setScene(fxmlLoader.load());
			modal.setOnCloseRequest(e -> hookController.hang(fxmlLoader.getController()));

			
			if (!modal.isShowing())
				modal.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setTitle(String title) {
		modal.setTitle(title);
	}
	
	public static void close() {
		modal.fireEvent(new WindowEvent(modal, WindowEvent.WINDOW_CLOSE_REQUEST));
	}
	
	private static void setScene(Parent parent) {
		modal.setScene(new Scene(parent));
		modal.getScene().getRoot().setStyle(AppStyle.getVars());
	}
}
