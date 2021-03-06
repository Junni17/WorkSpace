package exercises_day1ofGUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise1 extends Application {

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
	private TextField txf2Name;
	private TextField txf3Name;

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
		// Label lblName = new Label("Name:");
		// pane.add(lblName, 0, 0);

		// add a text field to the pane (at col=1, row=0, spanning 2 columns and
		// 1 row)
		this.txfName = new TextField();
		pane.add(this.txfName, 0, 0, 2, 1);

		this.txf2Name = new TextField();
		pane.add(this.txf2Name, 2, 0, 3, 1);

		this.txf3Name = new TextField();
		pane.add(this.txf3Name, 0, 1, 3, 2);

		// add a button to the pane (at col=1, row=1)
		Button btnUpperCase = new Button("Combine");
		pane.add(btnUpperCase, 0, 3);
		GridPane.setMargin(btnUpperCase, new Insets(10, 10, 0, 10));

		// connect a method to the button
		btnUpperCase.setOnAction(event -> this.upperCaseAction());

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

	private void upperCaseAction() {
		String name = this.txfName.getText().trim() + this.txf2Name.getText().trim();
		this.txf3Name.setText(name);
	}

}
