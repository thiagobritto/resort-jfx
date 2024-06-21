module resort-jfx {
	requires javafx.controls;
	
	opens sys to javafx.graphics, javafx.fxml;
}
