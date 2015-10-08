package exercises;

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
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		// add a label to the pane (at col=0, row=0)
		Label lblName = new Label("Celcius");
		pane.add(lblName, 0, 0);

		Label lblName2 = new Label("Fahrenheit");
		pane.add(lblName2, 0, 1);

		// add a text field to the pane (at col=1, row=0, spanning 2 columns and
		// 1 row)
		this.celcius = new TextField();
		pane.add(this.celcius, 1, 0, 2, 1);

		this.fahrenheit = new TextField();
		pane.add(this.fahrenheit, 1, 1, 2, 1);

		// add a button to the pane (at col=1, row=1)
		Button calculate = new Button("   Calculate   ");
		pane.add(calculate, 1, 2);

		// connect a method to the button
		calculate.setOnAction(event -> this.calculate());

	}

	// -------------------------------------------------------------------------
	// Button actions

	private void calculate() {

		double celcius = Integer.parseInt(this.celcius.getText().trim());
		// double fahrenheit =
		// Integer.parseInt(this.fahrenheit.getText().trim());

		double f_temp = (9.0 / 5) * celcius + 32;
		this.fahrenheit.setText((String.format("%.0f", f_temp)));
	}
}
