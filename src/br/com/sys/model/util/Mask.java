package br.com.sys.model.util;

import javafx.scene.control.TextField;

public class Mask {

	public static void cpf(TextField field) {

		field.textProperty().addListener(($obs, $old, $new) -> {

			$new = $new.trim().replaceAll("[^0-9]", "");
			if ($new.length() <= 11) {
				field.setText($new.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4"));
			} else if ($new.length() <= 14) {
				field.setText($new.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5"));
			} else {
				field.setText($old);
			}

		});
	}

	public static void phone(TextField field) {

		field.textProperty().addListener(($obs, $old, $new) -> {

			$new = $new.trim().replaceAll("[^0-9]", "");
			if ($new.length() <= 10) {
				field.setText($new.replaceAll("(\\d{2})(\\d{4})(\\d{4})", "($1) $2-$3"));
			} else if ($new.length() <= 11) {
				field.setText($new.replaceAll("(\\d{2})(\\d{1})(\\d{4})(\\d{4})", "($1) $2 $3-$4"));
			} else {
				field.setText($old);
			}

		});
	}
	
	public static void rg(TextField field) {

		field.textProperty().addListener(($obs, $old, $new) -> {

			$new = $new.trim().replaceAll("[^0-9]", "");
			if ($new.length() < 10) {
				field.setText($new.replaceAll("(\\d{3})(\\d{3})(\\d{3})", "$1.$2.$3"));
			} else {
				field.setText($old);
			}

		});
	}

}
