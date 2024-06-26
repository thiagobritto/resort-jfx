package br.com.sys.controller;

import java.io.IOException;

import br.com.sys.view.build.AppView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;

public class HomeViewController {

	@FXML
	private ScrollPane mainPane;

	@FXML
	void handleManageClient(ActionEvent event) throws IOException {
		mainPane.setContent(FXMLLoader.load(AppView.CLIENT_MANAGE.getURL()));
	}

	@FXML
	void handleManageRoom(ActionEvent event) {
		System.out.println("quarto");
	}

}
