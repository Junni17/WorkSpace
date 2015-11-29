package demo4listview;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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
		stage.setTitle("ListView Demo3");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private ArrayList<Person> persons;
	private TextField txfName;
	private ListView<Person> lvwPersons;

	private void initContent(GridPane pane) {
		this.initPersons();

		// pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);

		Label lblNames = new Label("Names:");
		pane.add(lblNames, 0, 1);
		GridPane.setValignment(lblNames, VPos.TOP);

		this.txfName = new TextField();
		pane.add(this.txfName, 1, 0);

		this.lvwPersons = new ListView<Person>();
		pane.add(this.lvwPersons, 1, 1);
		this.lvwPersons.setPrefWidth(200);
		this.lvwPersons.setPrefHeight(200);
		this.lvwPersons.getItems().setAll(this.persons);

		ChangeListener<Person> listener = (ov, oldPerson, newPerson) -> this.personsItemSelected();
		this.lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

		Button btnAdd = new Button("Add");
		pane.add(btnAdd, 2, 0);
		btnAdd.setOnAction(event -> this.addAction());

		Button btnDelete = new Button("Delete");
		pane.add(btnDelete, 2, 1);
		btnDelete.setOnAction(event -> this.deleteAction());
	}

	private void initPersons() {
		this.persons = new ArrayList<Person>();
		this.persons.add(new Person("Jens", "Jensen", "jj@eaaa.dk"));
		this.persons.add(new Person("Hans", "Hansen", "hh@eaaa.dk"));
		this.persons.add(new Person("Pia", "Peters", "pp@eaaa.dk"));
	}

	// -------------------------------------------------------------------------
	// Selected item changed in lvwPersons

	private void personsItemSelected() {
		Person selected = this.lvwPersons.getSelectionModel().getSelectedItem();
		if (selected != null) {
			this.txfName.setText(selected.toString());
		} else {
			this.txfName.clear();
		}
	}

	// -------------------------------------------------------------------------
	// Button actions

	private void addAction() {
		String name = this.txfName.getText().trim();
		if (name.length() > 0) {
			Person p = new Person(name, "Hansen", "123@mail.com");
			this.persons.add(p);
			this.lvwPersons.getItems().setAll(this.persons);
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Add person");
			alert.setHeaderText("Nothing added.");
			alert.setContentText("The text field is empty.");
			alert.showAndWait();
			// wait for the modal dialog to close
		}
	}

	private void deleteAction() {
		int index = this.lvwPersons.getSelectionModel().getSelectedIndex();
		if (index >= 0) {
			this.persons.remove(index);
			this.txfName.clear();
			this.lvwPersons.getItems().setAll(this.persons);
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Delete Name");
			alert.setHeaderText("Nothing deleted.");
			alert.setContentText("No person is selected in the list view.");
			alert.showAndWait();
			// wait for the modal dialog to close
		}
	}

}
