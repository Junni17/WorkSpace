package exercise5;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BoysAndGirls extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Boys and Girls");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private ArrayList<String> boyNames = new ArrayList<>();
	private ArrayList<String> girlNames = new ArrayList<>();
	private ListView<String> names;
	private TextField name;
	private ToggleGroup namesGroup;

	private void initContent(GridPane pane) {

		pane.setGridLinesVisible(!true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label names = new Label("Names:");
		pane.add(names, 0, 1);

		Label name = new Label("Name:");
		pane.add(name, 0, 3);

		this.names = new ListView<String>();
		pane.add(this.names, 1, 1, 1, 2);
		this.names.setPrefWidth(200);
		this.names.setPrefHeight(200);
		this.names.getItems().setAll(this.boyNames);
		// GridPane.setMargin(this.boyNames, new Insets(-25, 0, 0, 0));

		this.name = new TextField();
		pane.add(this.name, 1, 3, 1, 1);

		HBox box = new HBox(20);
		pane.add(box, 1, 0);
		this.namesGroup = new ToggleGroup();
		String[] gender = { "Boy", "Girl" };
		for (String s : gender) {
			RadioButton rb = new RadioButton();
			rb.setToggleGroup(this.namesGroup);
			rb.setText(s);
			box.getChildren().add(rb);
			rb.setSelected(true);
		}

		ChangeListener<Toggle> listener = (ov, oldValue, newValue) -> this.namesToggleSelected();
		this.namesGroup.selectedToggleProperty().addListener(listener);

		Button add_name = new Button("Add");
		pane.add(add_name, 4, 3);
		add_name.setOnAction(event -> this.add_name());

	}

	private void add_name() {
		RadioButton selected = (RadioButton) this.namesGroup.getSelectedToggle();
		if (selected.getText().equals("Boy")) {
			if (!this.name.getText().equals("")) {
				String s = this.name.getText();
				this.boyNames.add(s);
				this.names.getItems().setAll(this.boyNames);
				this.name.clear();
			}
		} else {
			if (!this.name.getText().equals("")) {
				String s = this.name.getText();
				this.girlNames.add(s);
				this.names.getItems().setAll(this.girlNames);
				this.name.clear();
			}
		}

	}

	private void namesToggleSelected() {
		RadioButton selected = (RadioButton) this.namesGroup.getSelectedToggle();
		if (selected.getText().equals("Boy")) {
			this.names.getItems().setAll(this.boyNames);
		} else {
			this.names.getItems().setAll(this.girlNames);
		}
	}

}
