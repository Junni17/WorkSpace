package exercises_day1ofGUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise6 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Temperature");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private TextField celcius;
	private TextField fahrenheit;

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(!false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(20);
		// set vertical gap between components
		pane.setVgap(0);

		// add a label to the pane (at col=0, row=0)
		Label lblName = new Label("Celcius");
		pane.add(lblName, 0, 0);

		Label lblName2 = new Label("Fahrenheit");
		pane.add(lblName2, 2, 0);

		// add a text field to the pane (at col=1, row=0, spanning 2 columns and
		// 1 row)
		this.celcius = new TextField();
		pane.add(this.celcius, 0, 1, 1, 2);

		this.fahrenheit = new TextField();
		pane.add(this.fahrenheit, 2, 1, 1, 2);

		// add a button to the pane (at col=1, row=1)
		// Button calculate = new Button("<--- to Celcius");
		// pane.add(calculate, 1, 2);

		Button celcius = new Button("   <--Celcius   ");
		pane.add(celcius, 1, 2);
		GridPane.setMargin(celcius, new Insets(-25, 10, 2, 10));

		Button fahrenheit = new Button("Fahrenheit-->");
		pane.add(fahrenheit, 1, 2);
		GridPane.setMargin(fahrenheit, new Insets(25, 10, -2, 10));
		fahrenheit.setMaxWidth(100);

		// connect a method to the button
		fahrenheit.setOnAction(event -> this.toFahrenheit());
		celcius.setOnAction(event -> this.toCelcius());

	}

	// -------------------------------------------------------------------------
	// Button actions

	private void toFahrenheit() {
		int celcius = Integer.parseInt(this.celcius.getText().trim());
		double f_temp = (9.0 / 5) * celcius + 32;
		this.fahrenheit.setText((String.format("%.0f", f_temp)));
	}

	private void toCelcius() {
		int fahrenheit = Integer.parseInt(this.fahrenheit.getText().trim());
		double c_temp = (fahrenheit - 32) * 5.0 / 9;
		this.celcius.setText((String.format("%.0f", c_temp)));
	}
}
