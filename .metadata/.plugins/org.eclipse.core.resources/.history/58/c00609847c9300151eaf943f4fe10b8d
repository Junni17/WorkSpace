package gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Conference;
import service.Service;

public class StatisticsPane extends Stage {

	public StatisticsPane(Stage owner) {
		this.initOwner(owner);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle("Statistics");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public void setConference(Conference conference) {
		this.controller.conference = conference;
		this.controller.updateControlls();
	}

	private TextArea excursions, hotels, participants;

	private void initContent(GridPane pane) {

		pane.setGridLinesVisible(!true);
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setPadding(new Insets(20));

		Label lblExcursions = new Label("EXCURSIONS");
		Label lblHotels = new Label("HOTELS");
		Label lblParticipants = new Label("PARTICIPANTS");

		pane.add(lblExcursions, 0, 0);
		pane.add(lblHotels, 0, 2);
		pane.add(lblParticipants, 0, 4);

		lblExcursions.setFont(Font.font("Verdana", 15));
		GridPane.setHalignment(lblExcursions, HPos.CENTER);
		lblHotels.setFont(Font.font("Verdana", 15));
		GridPane.setHalignment(lblHotels, HPos.CENTER);
		lblParticipants.setFont(Font.font("Verdana", 15));
		GridPane.setHalignment(lblParticipants, HPos.CENTER);

		this.excursions = new TextArea();
		this.excursions.setEditable(false);
		this.excursions.setPrefHeight(100);
		this.excursions.setPrefWidth(450);
		pane.add(this.excursions, 0, 1);

		this.hotels = new TextArea();
		this.hotels.setEditable(false);
		this.hotels.setPrefHeight(100);
		this.hotels.setPrefWidth(450);
		pane.add(this.hotels, 0, 3);

		this.participants = new TextArea();
		this.participants.setEditable(false);
		this.participants.setPrefHeight(100);
		this.participants.setPrefWidth(450);
		pane.add(this.participants, 0, 5);

		Button btnClose = new Button("Close");
		pane.add(btnClose, 0, 6);
		btnClose.setOnAction(event -> this.controller.closeOnAction());
	}

	private Controller controller = new Controller();

	private class Controller {

		private Conference conference;

		private void updateControlls() {
			StatisticsPane.this.excursions.setText(Service.getExcursionInfo(this.conference));
			StatisticsPane.this.hotels.setText(Service.getHotelsInfo(this.conference));
			StatisticsPane.this.participants.setText(Service.getParticipants(this.conference));
		}

		private void closeOnAction() {
			StatisticsPane.this.hide();
		}
	}

}