package exercise3;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PersonInformation extends Dialog<Person> {

	public PersonInformation() {
		this.setTitle("Person Information");

		// set content of the dialog's pane
		GridPane pane = new GridPane();
		this.initContent(pane);
		this.getDialogPane().setContent(pane);

		// add buttons to the dialog
		this.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

		// convert result to Person object
		this.setResultConverter(buttonType -> this.convertResult(buttonType));

		// prevent dialog from closing if a text field is empty
		Button btOk = (Button) this.getDialogPane().lookupButton(ButtonType.OK);
		btOk.addEventFilter(ActionEvent.ACTION, event -> this.filterOkEvent(event));
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

	}

	private Person convertResult(ButtonType buttonType) {
		if (buttonType == ButtonType.OK) {
			return new Person(this.name.getText(), this.title.getText(), this.senior.isSelected());
		}
		return null;
	}

	private void filterOkEvent(ActionEvent event) {
		if (this.name.getText().isEmpty() || this.title.getText().isEmpty()) {
			event.consume();
		}
	}

}
