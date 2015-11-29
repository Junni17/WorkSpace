package twowindows2;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewPhoneBookEntryDialog extends Stage {
	public NewPhoneBookEntryDialog(Stage owner) {
		this.initOwner(owner);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle("Custom Dialog");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	// -------------------------------------------------------------------------

	private TextField txfName, txfPhone;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(true);
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(10));

		Text txtHeader = new Text("New phone book entry");
		pane.add(txtHeader, 0, 0, 2, 1);
		txtHeader.setStyle("-fx-font-size: 15");
		GridPane.setMargin(txtHeader, new Insets(2, 0, 12, 0));

		Label lblName = new Label("Name: ");
		pane.add(lblName, 0, 1);

		this.txfName = new TextField();
		pane.add(this.txfName, 1, 1);

		Label lnlPhone = new Label("Phone: ");
		pane.add(lnlPhone, 0, 2);

		this.txfPhone = new TextField();
		pane.add(this.txfPhone, 1, 2);

		HBox buttonBox = new HBox(10);
		pane.add(buttonBox, 1, 3);
		buttonBox.setPadding(new Insets(11, 0, 0, 0));
		buttonBox.setAlignment(Pos.TOP_RIGHT);

		Button btnCancel = new Button("Cancel");
		buttonBox.getChildren().add(btnCancel);
		btnCancel.setPrefWidth(70);
		btnCancel.setCancelButton(true);
		btnCancel.setOnAction(event -> this.controller.cancelAction());

		Button btnOK = new Button("OK");
		buttonBox.getChildren().add(btnOK);
		btnOK.setPrefWidth(70);
		btnOK.setDefaultButton(true);
		btnOK.setOnAction(event -> this.controller.okAction());

		// prevent the dialog from closing if a text field is empty
		btnOK.addEventFilter(ActionEvent.ACTION, event -> this.controller.filterOkEvent(event));
	}

	public Optional<PhoneBook> getResult() {
		return this.controller.result;
	}

	// -------------------------------------------------------------------------

	private Controller controller = new Controller();

	private class Controller {
		private Optional<PhoneBook> result = Optional.empty();

		public void cancelAction() {
			NewPhoneBookEntryDialog.this.hide();
		}

		public void okAction() {
			PhoneBook pb = new PhoneBook(NewPhoneBookEntryDialog.this.txfName.getText(),
					NewPhoneBookEntryDialog.this.txfPhone.getText());
			this.result = Optional.of(pb);
			NewPhoneBookEntryDialog.this.hide();
		}

		public void filterOkEvent(ActionEvent event) {
			if (NewPhoneBookEntryDialog.this.txfName.getText().isEmpty()
					|| NewPhoneBookEntryDialog.this.txfPhone.getText().isEmpty()) {
				event.consume();
				NewPhoneBookEntryDialog.this.txfName.requestFocus();
			}
		}
	}
}
