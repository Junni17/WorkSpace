package exercise3;

import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PersonAdministration extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Person Administration");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private ArrayList<Person> persons = new ArrayList<>();
	private ListView<Person> lvwNames;

	private void initContent(GridPane pane) {

		// pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		this.lvwNames = new ListView<Person>();
		pane.add(this.lvwNames, 0, 0, 4, 4);
		this.lvwNames.setPrefWidth(200);
		this.lvwNames.setPrefHeight(200);
		this.lvwNames.getItems().setAll(this.persons);

		Button add_person = new Button("Add Person");
		pane.add(add_person, 6, 2);
		add_person.setOnAction(event -> this.add_person());

	}

	private void add_person() {
		PersonInformation dialog = new PersonInformation();

		Optional<Person> result = dialog.showAndWait();

		if (result.isPresent()) {
			this.persons.add(result.get());
			this.lvwNames.getItems().setAll(this.persons);
		}
	}

}
