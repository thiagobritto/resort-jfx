package br.com.sys.reserve.controller;

import br.com.sys.main.model.dao.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeViewController {
	
	private Database db = new Database();

    @FXML
    private Label lblNum;

    @FXML
    void handleAdd(ActionEvent event) {
    	
    }

}
