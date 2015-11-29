package exercise4;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PersonInformation extends Stage {

	public PersonInformation(Stage owner) {
		this.initOwner(owner);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle("Person Information");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	private TextField name, title;
	private CheckBox senior;

	private void initContent(GridPane pane) {
		// pane.setGridLinesVisible(true);
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setPadding(new Insets(20));

		Label label1 = new Label("Name: ");
		pane.add(label1, 0, 0);

		this.name = new TextField();
		pane.add(this.name, 3, 0);

		Label label2 = new Label("Title: ");
		pane.add(label2, 0, 1);

		this.title = new TextField();
		pane.add(this.title, 3, 1);

		this.senior = new CheckBox();
		pane.add(this.senior, 0, 2);

		Label label3 = new Label("Senior");
		pane.add(label3, 1, 2);
		GridPane.setMargin(label3, new Insets(0, 0, 0, -30));

		Button btOK = new Button("OK");
		pane.add(btOK, 3, 3);
		btOK.setPrefWidth(60);
		GridPane.setMargin(btOK, new Insets(0, 0, 0, +60));
		btOK.setOnAction(event -> this.controller.ok_action());

		Button btNotOK = new Button("Cancel");
		pane.add(btNotOK, 3, 3);
		btNotOK.setPrefWidth(60);
		GridPane.setMargin(btNotOK, new Insets(0, 0, 0, 0));
		btNotOK.setOnAction(event -> this.controller.not_ok_action());

		btOK.addEventFilter(ActionEvent.ACTION, event -> this.controller.filterOkEvent(event));
	}

	public Optional<Person> returnResult() {
		return this.controller.result;
	}

	Controller controller = new Controller();

	private class Controller {

		Optional<Person> result = Optional.empty();

		private void ok_action() {
			Person p1 = new Person(PersonInformation.this.name.getText(), PersonInformation.this.title.getText(),
					PersonInformation.this.senior.isSelected());
			this.result = Optional.of(p1);
			PersonInformation.this.hide();
		}

		private void not_ok_action() {
			PersonInformation.this.hide();
		}

		private void filterOkEvent(ActionEvent event) {
			if (PersonInformation.this.name.getText().isEmpty() || PersonInformation.this.title.getText().isEmpty()) {
				event.consume();
			}
		}

	}

}
