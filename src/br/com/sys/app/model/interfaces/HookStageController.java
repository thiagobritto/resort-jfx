package br.com.sys.app.model.interfaces;

import javafx.stage.Stage;

@FunctionalInterface
public interface HookStageController<T> {
	
	void hang(Stage stage, T controller);
}
