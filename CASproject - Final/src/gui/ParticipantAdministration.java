package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Company;
import model.Participant;
import service.Service;
import storage.Storage;

public class ParticipantAdministration extends Stage
{

	public ParticipantAdministration(Stage owner) {
		this.initOwner(owner);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle("Add Participant");
		GridPane pane = new GridPane();
		this.initControls(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	private TextField txfname, txfcountry, txfcity, txfadress, txfphone;
	private ComboBox<Company> cmbCompanies;
	private CheckBox chbCompany;
	private Label lblerror;

	private void initControls(GridPane pane)
	{
		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblname = new Label("Name:");
		Label lblcountry = new Label("Country:");
		Label lblcity = new Label("City:");
		Label lbladress = new Label("Address:");
		Label lblphone = new Label("Phone:");
		lblerror = new Label();

		pane.add(lblname, 0, 0);
		pane.add(lblcountry, 0, 1);
		pane.add(lblcity, 0, 2);
		pane.add(lbladress, 0, 3);
		pane.add(lblphone, 0, 4);
		pane.add(lblerror, 0, 7, 2, 1);

		this.txfname = new TextField();
		pane.add(this.txfname, 1, 0);

		this.txfcountry = new TextField();
		pane.add(this.txfcountry, 1, 1);

		this.txfcity = new TextField();
		pane.add(this.txfcity, 1, 2);

		this.txfadress = new TextField();
		pane.add(this.txfadress, 1, 3);

		this.txfphone = new TextField();
		pane.add(this.txfphone, 1, 4);

		// -----------------------------------------------------------------------------------------

		this.chbCompany = new CheckBox("Company:");
		pane.add(this.chbCompany, 0, 5);
		this.chbCompany.setOnMouseClicked(event -> this.controller.updateControlls(event));

		this.cmbCompanies = new ComboBox<Company>();
		pane.add(this.cmbCompanies, 1, 5);
		this.cmbCompanies.getItems().addAll(Storage.getAllCompanies());
		this.cmbCompanies.setPromptText("Select a Company");
		this.cmbCompanies.setDisable(true);

		Button btnOK = new Button("OK");
		btnOK.setPrefWidth(60);
		btnOK.setOnAction(event -> this.controller.addAction());
		Button btnCancel = new Button("Cancel");
		btnCancel.setPrefWidth(60);
		btnCancel.setOnAction(event -> this.controller.cancelAction());

		HBox btnBox = new HBox();
		btnBox.getChildren().add(btnOK);
		btnBox.getChildren().add(btnCancel);
		btnBox.setSpacing(15);

		pane.add(btnBox, 1, 8);

	}

	public Participant returnResult()
	{
		return this.controller.participant;
	}

	public boolean getResult()
	{
		return this.controller.result;
	}

	private Controller controller = new Controller();

	private class Controller
	{

		private boolean result = false;
		private Participant participant;

		private void updateControlls(MouseEvent event)
		{

			if (ParticipantAdministration.this.chbCompany.isSelected()) {
				ParticipantAdministration.this.cmbCompanies.setDisable(false);
			} else {
				ParticipantAdministration.this.cmbCompanies.setDisable(true);
			}
		}

		private void cancelAction()
		{
			this.result = false;
			ParticipantAdministration.this.hide();
		}

		private void addAction()
		{
			if (this.checkinput() == true) {
				result = true;
				ParticipantAdministration.this.close();
				Service.createParticipant(txfname.getText(), txfadress.getText(), txfcity.getText(),
						txfcountry.getText(), txfphone.getText());
			}

		}

		// Checks if user input is valid
		private boolean checkinput()
		{
			if (txfname.getText().isEmpty() == true || txfcity.getText().isEmpty() == true
					|| txfcountry.getText().isEmpty() == true || txfadress.getText().isEmpty() == true
					|| txfphone.getText().isEmpty() == true) {
				ParticipantAdministration.this.lblerror.setText("Please fill in all the textfields");
				return false;
			}

			if (txfname.getText().matches(".*\\d+.*") || txfcity.getText().matches(".*\\d+.*")
					|| txfcountry.getText().matches(".*\\d+.*")) {
				ParticipantAdministration.this.lblerror
						.setText("No numbers and symbols in 'Name', 'City' and 'Country'!");
				return false;
			}

			if (txfphone.getText().matches(".*[a-zA-Z]+.*")) {

				ParticipantAdministration.this.lblerror.setText("Letters in 'Phone' textfield are not allowed!");
				return false;
			}

			if (cmbCompanies.getSelectionModel().getSelectedItem() == null && cmbCompanies.isDisable() != true) {

				ParticipantAdministration.this.lblerror.setText("Please select a company");
				return false;
			}
			return true;
		}

	}

}