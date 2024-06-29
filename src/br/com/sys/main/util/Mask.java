package br.com.sys.main.util;

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

	public static void code(TextField field) {

		field.textProperty().addListener(($obs, $old, $new) -> {

			field.setText($new.trim().replaceAll("[^0-9]", ""));

		});
	}

	public static void codeLimit(TextField field, Integer limit) {

		field.textProperty().addListener(($obs, $old, $new) -> {

			$new = $new.trim().replaceAll("[^0-9]", "");
			if ($new.length() <= limit) {
				field.setText($new);
			} else {
				field.setText($old);
			}

		});
	}

	public static void weight(TextField field) {

		field.textProperty().addListener(($obs, $old, $new) -> {

			$new = $new.trim().replaceAll("[^0-9]|^0\\.0*", "");
			if ($new.length() < 1) {
				field.setText("0.000");
			} else if ($new.length() == 1) {
				field.setText("0.00" + $new);
			} else if ($new.length() == 2) {
				field.setText("0.0" + $new);
			} else if ($new.length() == 3) {
				field.setText("0." + $new);
			} else if ($new.length() > 3) {
				field.setText($new.replaceAll("(\\d*)(\\d{3})", "$1.$2"));
			}

		});
	}
	
	public static void money(TextField field) {

		field.textProperty().addListener(($obs, $old, $new) -> {

			$new = $new.trim().replaceAll("[^0-9]|^0\\,0*", "");
			if ($new.length() < 1) {
				field.setText("0,00");
			} else if ($new.length() == 1) {
				field.setText("0,0" + $new);
			} else if ($new.length() == 2) {
				field.setText("0," + $new);
			} else if ($new.length() > 2 && $new.length() <= 12) {
				field.setText($new.replaceAll("(\\d*)(\\d{2})", "$1,$2"));
			} else if ($new.length() > 12) {
				field.setText($old);
			}

		});
	}

}
