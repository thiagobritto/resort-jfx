package br.com.sys.resort.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.sys.main.util.Mask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ManageRoomViewConreoller implements Initializable {

    @FXML
    private Button btnClear, btnDelete, btnSave, btnSearch;

    @FXML
    private CheckBox checkView;

    @FXML
    private TableView<?> tableView;
    
    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colNumber;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colView;

    @FXML
    private TextField txtAmount, txtNumber, txtPrice, txtSearch;

    @FXML
    private TextArea txtDescription;
    
    @FXML
    private ComboBox<?> comboStatus;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Mask.codeLimit(txtNumber, 6);
		Mask.brl(txtPrice);
		
	}
    
    @FXML
    void handleDelete(ActionEvent event) {

    }

    @FXML
    void handleSave(ActionEvent event) {

    }

}
