package exercises_day1ofGUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise4 extends Application {

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

	private TextField input;
	private TextField first_half;
	private TextField second_half;

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
		// Label lblName = new Label("Number:");
		// pane.add(lblName, 0, 0);

		// add a text field to the pane (at col=1, row=0, spanning 2 columns and
		// 1 row)
		this.input = new TextField();
		pane.add(this.input, 0, 0, 4, 1);
		this.input.setMaxWidth(200);

		this.first_half = new TextField();
		pane.add(this.first_half, 0, 1, 1, 2);
		this.first_half.setMaxWidth(85);
		this.first_half.setEditable(false);

		this.second_half = new TextField();
		pane.add(this.second_half, 1, 1, 2, 2);
		this.second_half.setMaxWidth(85);
		this.second_half.setEditable(false);

		// add a button to the pane (at col=1, row=1)
		Button split = new Button("   Split   ");
		pane.add(split, 0, 4);
		GridPane.setMargin(split, new Insets(10, 10, 10, 10));

		// connect a method to the button
		split.setOnAction(event -> this.split());

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

	private void split() {

		for (int i = 0; i < this.input.getLength(); i++) {

			this.first_half.setText(this.input.getText(0, i));

			if (this.input.getText().charAt(i) == ' ') {
				this.second_half.setText(this.input.getText(i + 1, this.input.getLength()));
				break;
			}

		}
	}

}
