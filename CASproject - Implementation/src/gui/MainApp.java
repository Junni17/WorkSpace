
package gui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Conference;
import storage.Storage;

public class MainApp extends Application
{

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Conference Administration System");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    ListView<Conference> conferences = new ListView<Conference>();

    private void initContent(BorderPane pane)
    {

        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);

        GridPane conferencePane = new GridPane();
        conferencePane.setPadding(new Insets(20));
        conferencePane.setHgap(20);
        conferencePane.setVgap(10);
        conferencePane.setGridLinesVisible(true);

        pane.setLeft(conferencePane);
        pane.setCenter(separator);

        Label lblConference = new Label("Conferences:");
        conferencePane.add(lblConference, 0, 3);

        conferencePane.add(this.conferences, 0, 4);
        this.conferences.setPrefHeight(300);
        this.conferences.setPrefWidth(300);

        Button confCreate = new Button("Create");
        confCreate.setOnAction(event -> this.controller.createAction());
        conferencePane.add(confCreate, 0, 5);

        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setRight(tabPane);

        MenuBar menubar = new MenuBar();
        this.initMenus(menubar);
        pane.setTop(menubar);
    }

    private void initMenus(MenuBar menubar)
    {
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

    private void initTabPane(TabPane tabPane)
    {
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        Tab tabParticipants = new Tab("Participants");
        tabPane.getTabs().add(tabParticipants);

        // Tab tabHotels = new Tab("Hotels");
        // tabPane.getTabs().add(tabHotels);

        Tab tabExcursions = new Tab("Excursions");
        tabPane.getTabs().add(tabExcursions);

        ExcursionPane excursionPane = new ExcursionPane();
        tabExcursions.setContent(excursionPane);

        ChangeListener<Conference> listener = (ov, oldEmployee, newEmployee) -> excursionPane
                .setConference(this.conferences.getSelectionModel().getSelectedItem());

        ChangeListener<Conference> listener2 = (ov, oldEmployee, newEmployee) -> excursionPane
                .setExcursions(this.conferences.getSelectionModel().getSelectedItem());

        this.conferences.getSelectionModel().selectedItemProperty().addListener(listener);
        this.conferences.getSelectionModel().selectedItemProperty().addListener(listener2);
    }

    // -------------------------------------------------------------------------

    private Controller controller = new Controller();

    private class Controller
    {

        private void createAction()
        {

            Stage stage = (Stage) MainApp.this.conferences.getScene().getWindow();
            ConferenceAdministration dialog = new ConferenceAdministration(stage);
            dialog.showAndWait();

            if (dialog.getResult()) {
                MainApp.this.conferences.getItems().setAll(Storage.getAllConferences());
            }

        }

    }

}
