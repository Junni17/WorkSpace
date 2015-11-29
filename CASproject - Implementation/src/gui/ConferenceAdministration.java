package gui;

import java.time.LocalDate;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.Service;

public class ConferenceAdministration extends Stage {

	public ConferenceAdministration(Stage owner) {
		this.initOwner(owner);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle("Create Conference");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	private TextField name;
	private TextField price;
	private DatePicker startDate;
	private DatePicker endDate;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(!true);
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setPadding(new Insets(20));

		Label lblCreate = new Label("Create Conference");
		pane.add(lblCreate, 1, 0);

		this.name = new TextField();
		pane.add(this.name, 1, 1);

		this.price = new TextField();
		pane.add(this.price, 1, 2);

		this.startDate = new DatePicker();
		pane.add(this.startDate, 1, 3);

		this.endDate = new DatePicker();
		pane.add(this.endDate, 1, 4);

		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 1);

		Label lblPrice = new Label("Price:");
		pane.add(lblPrice, 0, 2);

		Label lblstartDate = new Label("Start Date");
		pane.add(lblstartDate, 0, 3);

		Label lblendDate = new Label("End Date");
		pane.add(lblendDate, 0, 4);

		Button btnOK = new Button("OK");
		btnOK.setPrefWidth(60);
		btnOK.setOnAction(event -> this.controller.ok_action());

		Button btnCancel = new Button("Cancel");
		btnCancel.setPrefWidth(60);
		btnCancel.setOnAction(event -> this.controller.cancelAction());

		HBox buttons = new HBox();
		buttons.setSpacing(15);
		buttons.getChildren().add(btnOK);
		buttons.getChildren().add(btnCancel);
		pane.add(buttons, 1, 5);

	}

	public boolean getResult() {
		return this.controller.result;
	}

	private Controller controller = new Controller();

	private class Controller {

		private boolean result = false;

		private void ok_action() {

			String name = ConferenceAdministration.this.name.getText();
			int price = Integer.parseInt(ConferenceAdministration.this.price.getText());
			LocalDate startDate = ConferenceAdministration.this.startDate.getValue();
			LocalDate endDate = ConferenceAdministration.this.endDate.getValue();

			Service.createConference(name, price, startDate, endDate);

			this.result = true;

			ConferenceAdministration.this.hide();
		}

		private void cancelAction() {
			ConferenceAdministration.this.hide();
		}

	}

}
