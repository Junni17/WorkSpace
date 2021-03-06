package exercises_day1ofGUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise7 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Gui Demo: TextArea");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private TextArea names;
	private TextField name;
	private String everything = "";

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(!false);

		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);

		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);

		this.name = new TextField();
		pane.add(this.name, 0, 1, 1, 1);

		this.names = new TextArea();
		pane.add(this.names, 0, 3);
		this.names.setPrefRowCount(10);
		this.names.setPrefWidth(200);
		this.names.setEditable(false);

		Button addName = new Button("Add");
		pane.add(addName, 0, 2);
		addName.setOnAction(event -> this.fillAction());
	}

	// -------------------------------------------------------------------------

	private void fillAction() {
		String temp = this.name.getText() + "\n";
		this.everything += temp;
		this.names.setText(this.everything);
	}

}