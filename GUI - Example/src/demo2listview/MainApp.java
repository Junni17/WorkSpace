package demo2listview;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
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
		stage.setTitle("ListView Demo2");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private ArrayList<String> names;
	private TextField txfName;
	private ListView<String> lvwNames;

	private void initContent(GridPane pane) {
		this.initNames();

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

		this.initNames();
		this.lvwNames = new ListView<String>();
		pane.add(this.lvwNames, 1, 1);
		this.lvwNames.setPrefWidth(200);
		this.lvwNames.setPrefHeight(200);
		this.lvwNames.getItems().setAll(this.names);

		ChangeListener<String> listener = (ov, oldString, newString) -> this.namesItemSelected();
		this.lvwNames.getSelectionModel().selectedItemProperty().addListener(listener);

		Button btnAdd = new Button("Add");
		pane.add(btnAdd, 2, 0);
		btnAdd.setOnAction(event -> this.addAction());

		Button btnDelete = new Button("Delete");
		pane.add(btnDelete, 2, 1);
		btnDelete.setOnAction(event -> this.deleteAction());
	}

	private void initNames() {
		String[] items = { "Jane", "Eva", "Lene", "Mette", "Tine", "Line", "Lone", "Alberte", "Pia" };
		this.names = new ArrayList<String>(Arrays.asList(items));

	}

	// -------------------------------------------------------------------------
	// Selected item changed in lvwNames

	private void namesItemSelected() {
		String selected = this.lvwNames.getSelectionModel().getSelectedItem();
		if (selected != null) {
			this.txfName.setText(selected);
		} else {
			this.txfName.clear();
		}
	}

	// -------------------------------------------------------------------------
	// Button actions

	private void addAction() {
		String name = this.txfName.getText().trim();
		if (name.length() > 0) {
			this.names.add(name);
			this.lvwNames.getItems().setAll(this.names);
			this.txfName.clear();
		}
	}

	private void deleteAction() {
		int index = this.lvwNames.getSelectionModel().getSelectedIndex();
		if (index >= 0) {
			this.names.remove(index);
			this.txfName.clear();
			this.lvwNames.getItems().setAll(this.names);
		}
	}

}
