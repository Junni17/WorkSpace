package exercises_day1ofGUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise5 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Calculating Interest");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private TextField investment;
	private TextField years;
	private TextField interest;
	private TextField future_value;

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
		Label lblName = new Label("Investment");
		pane.add(lblName, 0, 0);

		Label lblName2 = new Label("Years");
		pane.add(lblName2, 0, 1);

		Label lblName3 = new Label("Interest");
		pane.add(lblName3, 0, 2);

		Label lblName4 = new Label("Future Value");
		pane.add(lblName4, 0, 3);

		// add a text field to the pane (at col=1, row=0, spanning 2 columns and
		// 1 row)
		this.investment = new TextField();
		pane.add(this.investment, 1, 0, 2, 1);

		this.years = new TextField();
		pane.add(this.years, 1, 1, 2, 1);

		this.interest = new TextField();
		pane.add(this.interest, 1, 2, 2, 1);

		this.future_value = new TextField();
		pane.add(this.future_value, 1, 3, 2, 1);
		this.future_value.setEditable(false);

		// add a button to the pane (at col=1, row=1)
		Button calculate = new Button("   Calculate   ");
		pane.add(calculate, 1, 4);

		// connect a method to the button
		calculate.setOnAction(event -> this.calculate());

	}

	// -------------------------------------------------------------------------
	// Button actions

	private void calculate() {

		int investment = Integer.parseInt(this.investment.getText().trim());
		int years = Integer.parseInt(this.years.getText().trim());
		double interest = Integer.parseInt(this.interest.getText().trim());
		double future_value = investment * Math.pow((1 + (interest / 12) / 100), (years * 12));

		this.future_value.setText(String.format("%.2f", future_value));

	}
}
