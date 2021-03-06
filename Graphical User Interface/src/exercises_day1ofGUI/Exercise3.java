package exercises_day1ofGUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise3 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Gui Demo");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private TextField txfName;

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(30);
		// set vertical gap between components
		pane.setVgap(10);

		// add a label to the pane (at col=0, row=0)
		Label lblName = new Label("Number:");
		pane.add(lblName, 0, 0);

		// add a text field to the pane (at col=1, row=0, spanning 2 columns and
		// 1 row)
		this.txfName = new TextField("0");
		pane.add(this.txfName, 1, 0, 1, 1);
		this.txfName.setMaxWidth(50);
		this.txfName.setEditable(false);

		// add a button to the pane (at col=1, row=1)
		Button adding = new Button("   +   ");
		pane.add(adding, 2, 0);
		GridPane.setMargin(adding, new Insets(-25, 0, 2, -20));

		Button subtract = new Button("   -   ");
		pane.add(subtract, 2, 0);
		GridPane.setMargin(subtract, new Insets(25, 0, -2, -20));
		subtract.setMaxWidth(100);

		// connect a method to the button
		adding.setOnAction(event -> this.increment());
		subtract.setOnAction(event -> this.decrease());

		// // add a button to the pane (at col=2, row=1)
		// Button btnLowerCase = new Button("Lower Case");
		// pane.add(btnLowerCase, 2, 1);
		// GridPane.setMargin(btnLowerCase, new Insets(10, 10, 0, 10));
		//
		// // connect a method to the button
		// btnLowerCase.setOnAction(event -> this.lowerCaseAction());
	}

	// -------------------------------------------------------------------------
	// Button actions

	private void increment() {
		int number = Integer.parseInt(this.txfName.getText().trim());
		number++;
		this.txfName.setText("" + number);
	}

	private void decrease() {
		int number = Integer.parseInt(this.txfName.getText().trim());
		number--;
		this.txfName.setText("" + number);
	}

}
