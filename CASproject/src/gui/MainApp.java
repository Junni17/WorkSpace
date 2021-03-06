
package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Conference;
import service.Service;

public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Conference Administration System");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	ListView<Conference> conferences = new ListView<Conference>();

	private void initContent(BorderPane pane) {

		TabPane tabPane = new TabPane();
		this.initTabPane(tabPane);
		pane.setCenter(tabPane);

		MenuBar menubar = new MenuBar();
		this.initMenus(menubar);
		pane.setTop(menubar);
	}

	@Override
	public void init() {
		Service.initStorage();
	}

	private void initMenus(MenuBar menubar) {
		Menu menuPrint = new Menu("Info");
		menubar.getMenus().add(menuPrint);

		MenuItem companies = new MenuItem("Something");
		menuPrint.getItems().add(companies);
		// companies.setOnAction(event -> this.ctrl.companiesAction());

		MenuItem employees = new MenuItem("Something 2");
		menuPrint.getItems().add(employees);
		// employees.setOnAction(event -> this.ctrl.employeesAction());

		menuPrint.getItems().add(new SeparatorMenuItem());

		MenuItem exit = new MenuItem("Exit");
		menuPrint.getItems().add(exit);
		// exit.setOnAction(event -> this.ctrl.exitAction());
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

		// ChangeListener<Conference> listener = (ov, oldEmployee, newEmployee)
		// -> excursionPane
		// .setConference(this.conferences.getSelectionModel().getSelectedItem());
		//
		// ChangeListener<Conference> listener2 = (ov, oldEmployee, newEmployee)
		// -> excursionPane
		// .setExcursions(this.conferences.getSelectionModel().getSelectedItem());

		// this.conferences.getSelectionModel().selectedItemProperty().addListener(listener);
		// this.conferences.getSelectionModel().selectedItemProperty().addListener(listener2);
	}

	// -------------------------------------------------------------------------

	// private Controller controller = new Controller();
	//
	// private class Controller {
	//
	// private void createAction() {
	//
	// Stage stage = (Stage) MainApp.this.conferences.getScene().getWindow();
	// ConferenceAdministration dialog = new ConferenceAdministration(stage);
	// dialog.showAndWait();
	//
	// if (dialog.getResult()) {
	// MainApp.this.conferences.getItems().setAll(Storage.getAllConferences());
	// }
	//
	// }
	//
	// }

}
