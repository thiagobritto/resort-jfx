package br.com.sys.app.model.interfaces;

import javafx.stage.Stage;

@FunctionalInterface
public interface HookStage {
	
	void hang(Stage stage);
}
