package br.com.sys.client.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.sys.client.model.domain.Client;
import br.com.sys.client.model.rule.ClientValidation;
import br.com.sys.model.util.Mask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ManageClientViewController implements Initializable {

	private Client client;

	@FXML
	private Button btnDelete, btnEdit, btnSave, btnSearch;

	@FXML
	private TableView<?> tableView;

	@FXML
	private TableColumn<?, ?> colCode;

	@FXML
	private TableColumn<?, ?> colCpf, colName, colPhonr;

	@FXML
	private TextField txtCpf, txtName, txtPhone, txtRg, txtSearch;

	@FXML
	private DatePicker dateNas;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// FOCUS NAME
		Platform.runLater(() -> txtName.requestFocus());
				
		// MASK
		Mask.cpf(txtCpf);
		Mask.phone(txtPhone);
		Mask.rg(txtRg);

		// SEARCH
		txtSearch.setOnKeyReleased(e -> onSearch());
		btnSearch.setOnAction(e -> onSearch());
		
		// REGISTER
		txtName.setOnKeyReleased(e -> verifyValide());
		txtCpf.setOnKeyReleased(e -> verifyValide());
		txtPhone.setOnKeyReleased(e -> verifyValide());
		txtRg.setOnKeyReleased(e -> verifyValide());
		dateNas.setOnAction(e -> verifyValide());
	}

	@FXML
	void handleDelete(ActionEvent event) {

	}

	@FXML
	void handleEdit(ActionEvent event) {

	}

	@FXML
	void handleSave(ActionEvent event) {
		clearFormClient();
	}

	private void onSearch() {

	}

	private void verifyValide() {

		if (ClientValidation.valide(getClient())) {
			btnSave.setDisable(false);			
		} else {
			btnSave.setDisable(true);						
		}

	}

	private Client getClient() {
		client = new Client();
		client.setCpf(txtCpf.getText());
		client.setName(txtName.getText());
		client.setPhone(txtPhone.getText());
		client.setRg(txtRg.getText());
		client.setBirthday(dateNas.getValue());
		return client;
	}
	
	private void clearFormClient() {
		client = null;
		txtCpf.setText("");
		txtName.setText("");
		txtPhone.setText("");
		txtRg.setText("");
		dateNas.setValue(null);;
	}

}
