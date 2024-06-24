package br.com.sys.app.controller;

import java.util.Locale;

import br.com.sys.app.model.domain.AppView;
import br.com.sys.app.view.build.AppStage;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AppStart extends Application {
	
	protected static Stage stage;
	protected static Stage modal;	

	public static void main(String[] args) {
		Locale.setDefault(new Locale("pt", "BR"));
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Image image = new Image("/img/icon/favicon.png");
		
		AppStart.stage = stage;
		AppStart.stage.getIcons().add(image);
		
		AppStart.modal = new Stage();
		AppStart.modal.initOwner(stage);
		AppStart.modal.setResizable(false);
		AppStart.modal.getIcons().add(image);
		AppStart.modal.initModality(Modality.WINDOW_MODAL);
		
		AppStage.load(AppView.HOME);
		AppStage.setTitle("System - Home");
	}

}
