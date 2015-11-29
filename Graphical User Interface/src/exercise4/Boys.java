package exercise4;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Boys extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Boys");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private ArrayList<String> names = new ArrayList<>();
	private ListView<String> boyNames;
	private TextField name;

	private void initContent(GridPane pane) {

		pane.setGridLinesVisible(!true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label names = new Label("Names:");
		pane.add(names, 0, 0);

		Label name = new Label("Name:");
		pane.add(name, 0, 2);

		this.boyNames = new ListView<String>();
		pane.add(this.boyNames, 1, 0, 1, 2);
		this.boyNames.setPrefWidth(200);
		this.boyNames.setPrefHeight(200);
		this.boyNames.getItems().setAll(this.names);
		// GridPane.setMargin(this.boyNames, new Insets(-25, 0, 0, 0));

		this.name = new TextField();
		pane.add(this.name, 1, 2, 1, 1);

		Button add_name = new Button("Add");
		pane.add(add_name, 4, 2);
		add_name.setOnAction(event -> this.add_name());

	}

	private void add_name() {
		if (!this.name.getText().equals("")) {
			String s = this.name.getText();
			this.names.add(s);
			this.boyNames.getItems().setAll(this.names);
			this.name.clear();
		}
	}

}
