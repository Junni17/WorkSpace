package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Conference;
import storage.Storage;

public class ConferencePane extends GridPane {

	public ConferencePane() {
		this.initContent();
	}

	// -------------------------------------------------------------------------

	private ListView<Conference> conferences;
	private Label lblError;

	private void initContent() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Conferences - (double click for statistics)");
		this.add(lblComp, 0, 0);

		this.conferences = new ListView<>();
		this.add(this.conferences, 0, 1);
		this.conferences.setPrefWidth(600);
		this.conferences.setPrefHeight(300);
		this.conferences.getItems().setAll(Storage.getAllConferences());

		this.lblError = new Label();
		this.add(this.lblError, 0, 2);

		Button btnCreate = new Button("Create");
		btnCreate.setPrefWidth(60);
		btnCreate.setOnAction(event -> this.controller.createOnAction());
		Button btnEnroll = new Button("Enroll Participant");
		btnEnroll.setOnAction(event -> this.controller.enrollOnAction());
		btnEnroll.setPrefWidth(120);

		HBox btnBox = new HBox();
		btnBox.getChildren().add(btnCreate);
		btnBox.getChildren().add(btnEnroll);
		btnBox.setSpacing(15);
		this.add(btnBox, 0, 3);

		this.conferences.setOnMouseClicked(event -> this.controller.getStatistics(event));
	}

	private Controller controller = new Controller();

	private class Controller {

		private void createOnAction() {

			Stage stage = (Stage) ConferencePane.this.conferences.getScene().getWindow();
			ConferenceAdministration dialog = new ConferenceAdministration(stage);

			dialog.showAndWait();

			if (dialog.getResult()) {
				ConferencePane.this.conferences.getItems().setAll(Storage.getAllConferences());
			}

		}

		private void enrollOnAction() {

			Conference conference = ConferencePane.this.conferences.getSelectionModel().getSelectedItem();

			if (conference == null) {
				ConferencePane.this.lblError.setText("No conference selected");
				return;
			}

			Stage stage = (Stage) ConferencePane.this.conferences.getScene().getWindow();
			EnrollmentAdministration dialog = new EnrollmentAdministration(stage);

			dialog.setConference(conference);
			dialog.showAndWait();

		}

		private void getStatistics(MouseEvent event) {
			if (event.getClickCount() == 2) {
				Conference conference = ConferencePane.this.conferences.getSelectionModel().getSelectedItem();
				if (conference != null) {
					Stage stage = (Stage) ConferencePane.this.conferences.getScene().getWindow();
					StatisticsPane test = new StatisticsPane(stage);
					test.setConference(conference);
					test.showAndWait();
				}
			}
		}

	}

}
