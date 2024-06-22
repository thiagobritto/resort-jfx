package br.com.sys.main.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.function.Consumer;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertView extends AppStart {

	private static Alert alert;
	private static Label label;
	private static TextArea textArea;	
	
	public static void info(String msg) {
		info();
		alert.setHeaderText(msg);
		alert.showAndWait();
	}
	
	public static void info(String msg, String contentText) {
		info();
		alert.setHeaderText(msg);
		alert.setContentText(contentText);		
		alert.showAndWait();
	}
	
	private static void info() {
		alert = new Alert(AlertType.INFORMATION);
		alert.initModality(Modality.WINDOW_MODAL);
		alert.initOwner(getStage());
		alert.setTitle("Informação");
	}
	
	public static void warn(String msg) {
		warn();
		alert.setHeaderText(msg);
		alert.showAndWait();
	}
	
	public static void warn(String msg, String contentText) {
		warn();
		alert.setHeaderText(msg);
		alert.setContentText(contentText);
		alert.showAndWait();
	}
	
	private static void warn() {
		alert = new Alert(AlertType.WARNING);
		alert.initModality(Modality.WINDOW_MODAL);
		alert.initOwner(getStage());
		alert.setTitle("Aviso");
	}
	
	public static void error(String msg) {
		error();
		alert.setHeaderText(msg);
		alert.showAndWait();
	}
	
	public static void error(String msg, String contentText) {
		error();
		alert.setHeaderText(msg);
		alert.setContentText(contentText);		
		alert.showAndWait();
	}
	
	public static void error(String msg, Throwable e) {
		error();
		alert.setHeaderText(msg);
		alert.getDialogPane().setExpandableContent(getStackLayout(getStackText(e)));
		alert.showAndWait();
	}
	
	private static void error() {
		alert = new Alert(AlertType.ERROR);
		alert.initModality(Modality.WINDOW_MODAL);
		alert.initOwner(getStage());
		alert.setTitle("Erro");
	}
	
	public static void confirm(String msg, Consumer<Boolean> res) {
		confirm();
		alert.setHeaderText(msg);
		alert.showAndWait().ifPresent( button -> {
			if(button == ButtonType.YES) {
				res.accept(true);
			} else {
				res.accept(false);				
			}
		});
	}
	
	private static void confirm() {
		alert = new Alert(AlertType.CONFIRMATION);
		alert.initModality(Modality.WINDOW_MODAL);
		alert.initOwner(getStage());
		alert.setTitle("Confirmação");
		alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
	}
	
	private static Stage getStage() {
		
		if(modal.isShowing())
			return modal;
		
		if(stage.isShowing())
			return stage;
	
		return null;
	}
	
	private static String getStackText(Throwable e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}
	
	private static GridPane getStackLayout(String stack) {
		
		label = new Label("Segue a pilha de exceções:");
		
		textArea = new TextArea(stack);
		textArea.setEditable(false);
		textArea.setWrapText(false);
		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);
		
		GridPane content = new GridPane();
		content.setMaxWidth(Double.MAX_VALUE);
		content.add(label, 0, 0);
		content.add(textArea, 0, 1);
		
		return content;
	}
}
