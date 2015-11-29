package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Enrollment;
import model.Participant;

public class ParticipantInfoWindow extends Stage {

	public ParticipantInfoWindow(Stage owner) {
		this.initOwner(owner);
		this.setTitle("Participant Info");

		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	// -------------------------------------------------------------------------

	private ListView<Enrollment> enrollments;
	private TextField name;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblComp = new Label("Participant:");
		pane.add(lblComp, 0, 0);

		this.name = new TextField();
		pane.add(this.name, 0, 1);
		this.name.setEditable(false);

		this.enrollments = new ListView<>();
		pane.add(this.enrollments, 0, 2);
		this.enrollments.setPrefWidth(300);
		this.enrollments.setPrefHeight(300);

		Button btnAdd = new Button("Close");
		btnAdd.setPrefWidth(60);
		btnAdd.setOnAction(event -> this.controller.closeOnAction());
		pane.add(btnAdd, 0, 3);

	}

	public void setParticipant(Participant participant) {
		this.controller.participant = participant;
		this.controller.updateControlls();
	}

	private Controller controller = new Controller();

	private class Controller {

		private Participant participant;

		private void updateControlls() {
			ParticipantInfoWindow.this.name.setText(this.participant.getName());
			ParticipantInfoWindow.this.enrollments.getItems().setAll(this.participant.getEnrollments());
		}

		private void closeOnAction() {
			ParticipantInfoWindow.this.hide();
		}

	}
}
