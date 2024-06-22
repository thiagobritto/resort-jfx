package br.com.sys.main.controller;

import javafx.stage.Stage;

@FunctionalInterface
public interface ViewController<T> {

	void up(Stage stage, T controller);

}
