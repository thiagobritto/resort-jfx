package br.com.sys.client.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.sys.client.model.dao.ClientDao;
import br.com.sys.client.model.dao.ClientDaoInterface;
import br.com.sys.client.model.domain.Client;
import br.com.sys.client.model.rule.ClientValidation;
import br.com.sys.model.exceptions.DialogErrorException;
import br.com.sys.model.util.Mask;
import br.com.sys.view.build.AlertView;
import javafx.application.Platform;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ManageClientViewController implements Initializable {

	private ObservableList<Client> obsClient = FXCollections.observableArrayList();
	private ClientDaoInterface clientDao = new ClientDao();
	private Client client = new Client();

	@FXML
	private Button btnDelete, btnSave, btnClear, btnSearch;

	@FXML
	private TableView<Client> tableView;

	@FXML
	private TableColumn<Client, Long> colCode;

	@FXML
	private TableColumn<Client, String> colCpf, colName, colPhonr;

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

		// VALIDATE REGISTER
		txtName.setOnKeyReleased(e -> verifyValide());
		txtCpf.setOnKeyReleased(e -> verifyValide());
		txtPhone.setOnKeyReleased(e -> verifyValide());
		txtRg.setOnKeyReleased(e -> verifyValide());
		dateNas.setOnAction(e -> verifyValide());

		// TABLE VIEW SETTINGS
		colCode.setCellValueFactory(d -> new SimpleLongProperty(d.getValue().getIdClient()).asObject());
		colName.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getName()));
		colCpf.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCpf()));
		colPhonr.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getPhone()));
		tableView.setItems(obsClient);

		// SHOW DATA
		obsClient.addAll(clientDao.getAll());

		// SELECTED
		tableView.getSelectionModel().selectedItemProperty().addListener(($obs, $old, $new) -> {
			if ($new != null)
				fillFormClient($new);
		});

		// FORM CLEAR
		btnClear.setOnAction(e -> clearFormClient());
	}

	@FXML
	void handleDelete(ActionEvent event) {
		try {

			AlertView.confirm("Deseja excluir o cliente " + getClient().getIdClient() + "?", () -> {
				clientDao.delete(getClient());
				AlertView.info("Cliente excluido com sucesso!");				
				clearFormClient();
			});	

		} catch (DialogErrorException e) {
			AlertView.error(e.getMessage(), e);
		}
	}

	@FXML
	void handleSave(ActionEvent event) {
		try {

			if (getClient().getIdClient() <= 0) {
				clientDao.save(getClient());
				AlertView.info("Cliente cadastrado com sucesso!");
			} else {
				clientDao.update(getClient());
				AlertView.info("Cliente atualizado com sucesso!");
			}

			clearFormClient();

		} catch (DialogErrorException e) {
			AlertView.error(e.getMessage(), e);
		}
	}

	private void onSearch() {
		obsClient.clear();
		obsClient.addAll(clientDao.getByNameOrCpf(txtSearch.getText()));
	}

	private void verifyValide() {

		if (ClientValidation.valide(getClient())) {
			btnSave.setDisable(false);
		} else {
			btnSave.setDisable(true);
		}

	}

	private Client getClient() {
		client.setCpf(txtCpf.getText());
		client.setName(txtName.getText());
		client.setPhone(txtPhone.getText());
		client.setRg(txtRg.getText());
		client.setBirthday(dateNas.getValue());
		return client;
	}

	private void fillFormClient(Client client) {
		this.client = client;
		txtCpf.setText(client.getCpf());
		txtName.setText(client.getName());
		txtPhone.setText(client.getPhone());
		txtRg.setText(client.getRg());
		dateNas.setValue(client.getBirthday());
		btnSave.setText("Alterar");
		btnSave.setDisable(false);
		btnDelete.setDisable(false);
	}

	private void clearFormClient() {
		client = new Client();
		txtCpf.setText("");
		txtName.setText("");
		txtPhone.setText("");
		txtRg.setText("");
		dateNas.setValue(null);
		btnSave.setText("Salvar");
		btnSave.setDisable(true);
		btnDelete.setDisable(true);

		onSearch();
	}

}
