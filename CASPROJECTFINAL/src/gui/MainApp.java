
package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import service.Service;

public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		System.setProperty("glass.accessible.force", "false");
		stage.setTitle("Conference Administration System");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {

		TabPane tabPane = new TabPane();
		this.initTabPane(tabPane);
		pane.setCenter(tabPane);
	}

	@Override
	public void init() {
		Service.initStorage();
	}

	private void initTabPane(TabPane tabPane) {
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		Tab tabParticipants = new Tab("Participants");
		tabPane.getTabs().add(tabParticipants);

		ParticipantPane participantPane = new ParticipantPane();
		tabParticipants.setContent(participantPane);

		Tab tabConferences = new Tab("Conferences");
		tabPane.getTabs().add(tabConferences);

		ConferencePane conferencePane = new ConferencePane();
		tabConferences.setContent(conferencePane);
	}

}
