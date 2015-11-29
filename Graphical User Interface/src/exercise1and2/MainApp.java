package exercise1and2;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
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
	private TextField name;
	private TextField title;
	private CheckBox senior;

	private void initContent(GridPane pane) {
		// this.initNames();

		// pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label name = new Label("Name:");
		pane.add(name, 0, 0);

		Label title = new Label("Title:");
		pane.add(title, 0, 1);

		Label persons = new Label("Persons:");
		pane.add(persons, 0, 3);

		this.senior = new CheckBox();
		pane.add(this.senior, 1, 2);

		Label seniorL = new Label("Senior");
		pane.add(seniorL, 2, 2);
		GridPane.setMargin(seniorL, new Insets(0, 0, 0, -10));

		this.lvwNames = new ListView<Person>();
		pane.add(this.lvwNames, 1, 4, 2, 1);
		this.lvwNames.setPrefWidth(200);
		this.lvwNames.setPrefHeight(200);
		this.lvwNames.getItems().setAll(this.persons);
		GridPane.setMargin(this.lvwNames, new Insets(-25, 0, 0, 0));

		ChangeListener<Person> listener = (ov, oldString, newString) -> this.namesItemSelected();
		this.lvwNames.getSelectionModel().selectedItemProperty().addListener(listener);

		this.name = new TextField();
		pane.add(this.name, 1, 0, 2, 1);

		this.title = new TextField();
		pane.add(this.title, 1, 1, 2, 1);

		Button add_person = new Button("Add Person");
		pane.add(add_person, 3, 2);
		add_person.setOnAction(event -> this.add_person());

	}

	private void add_person() {
		String name = this.name.getText();
		String title = this.title.getText();

		if (name.isEmpty() || title.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			String s = "Enter both name and title!";
			alert.setContentText(s);

			alert.showAndWait();
			// wait for the dialog to close
		} else {

			boolean senior = this.senior.isSelected();
			Person p1 = new Person(name, title, senior);
			this.persons.add(p1);
			this.lvwNames.getItems().setAll(this.persons);
			this.name.clear();
			this.title.clear();
			this.senior.setSelected(false);
		}

	}

	// -------------------------------------------------------------------------
	// Selected item changed in lvwNames

	private void namesItemSelected() {
		Person selected = this.lvwNames.getSelectionModel().getSelectedItem();
		if (selected != null) {
			this.name.setText(selected.getName());
			this.title.setText(selected.getTitle());
			if (selected.getSenior() == true) {
				this.senior.setSelected(true);
			} else {
				this.senior.setSelected(false);
			}
		} else {
			this.name.clear();
			this.title.clear();
			this.senior.setSelected(false);
		}
	}

}
