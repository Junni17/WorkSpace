package gui;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Conference;
import model.Excursion;
import model.Hotel;
import service.Service;
import storage.Storage;

public class ConferenceAdministration extends Stage
{

    public ConferenceAdministration(Stage owner)
    {
        this.initOwner(owner);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle("Create Conference");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private TextField name;
    private TextField price;
    private DatePicker startDate;
    private DatePicker endDate;
    private ArrayList<Excursion> arrExcursions = new ArrayList<>();
    private ListView<Excursion> listExcursions;
    private ListView<Hotel> availableHotels, addedHotels;
    private Label lblError;

    private void initContent(BorderPane pane)
    {
        GridPane paneInfo = new GridPane();
        paneInfo.setHgap(20);
        paneInfo.setVgap(10);
        paneInfo.setPadding(new Insets(20));

        pane.setLeft(paneInfo);

        Label lblCreate = new Label("Create Conference");
        paneInfo.add(lblCreate, 1, 0);
        Label lblName = new Label("Name:");
        paneInfo.add(lblName, 0, 1);
        Label lblPrice = new Label("Price:");
        paneInfo.add(lblPrice, 0, 2);
        Label lblstartDate = new Label("Start Date");
        paneInfo.add(lblstartDate, 0, 3);
        Label lblendDate = new Label("End Date");
        paneInfo.add(lblendDate, 0, 4);

        this.name = new TextField();
        paneInfo.add(this.name, 1, 1);
        this.price = new TextField();
        paneInfo.add(this.price, 1, 2);

        this.startDate = new DatePicker();
        paneInfo.add(this.startDate, 1, 3);
        this.endDate = new DatePicker();
        paneInfo.add(this.endDate, 1, 4);

        // -----------------------------------------------------------------------------------------

        Label lblExcursions = new Label("Excursions:");
        paneInfo.add(lblExcursions, 0, 5);

        this.listExcursions = new ListView<Excursion>();
        this.listExcursions.setPrefHeight(200);
        this.listExcursions.setPrefWidth(200);
        paneInfo.add(this.listExcursions, 1, 5, 2, 1);

        Button btnAddExcursion = new Button("Add");
        btnAddExcursion.setPrefWidth(60);
        btnAddExcursion.setOnAction(event -> this.controller.addExcursionAction());
        paneInfo.add(btnAddExcursion, 1, 6);

        // -----------------------------------------------------------------------------------------

        Label lblAvailableHotels = new Label("Available Hotels:");
        paneInfo.add(lblAvailableHotels, 1, 7);
        Label lblAddedHotels = new Label("Added Hotels:");
        paneInfo.add(lblAddedHotels, 2, 7);

        this.availableHotels = new ListView<Hotel>();
        this.availableHotels.setPrefSize(200, 200);
        paneInfo.add(this.availableHotels, 1, 8);
        this.availableHotels.getItems().addAll(this.controller.availableHotels);

        this.addedHotels = new ListView<Hotel>();
        this.addedHotels.setPrefSize(200, 200);
        paneInfo.add(this.addedHotels, 2, 8);

        Button btnAddHotel = new Button("Add");
        paneInfo.add(btnAddHotel, 1, 9);
        btnAddHotel.setPrefWidth(60);
        btnAddHotel.setOnAction(event -> this.controller.addHotelAction());

        Button btnRemoveHotel = new Button("Remove");
        paneInfo.add(btnRemoveHotel, 2, 9);
        btnRemoveHotel.setPrefWidth(60);
        btnRemoveHotel.setOnAction(event -> this.controller.removeHotelAction());

        // -----------------------------------------------------------------------------------------

        this.lblError = new Label();
        paneInfo.add(this.lblError, 1, 10);

        Button btnOK = new Button("OK");
        btnOK.setPrefWidth(60);
        btnOK.setOnAction(event -> this.controller.okAction());

        Button btnCancel = new Button("Cancel");
        btnCancel.setPrefWidth(60);
        btnCancel.setOnAction(event -> this.controller.cancelAction());

        HBox btnBox = new HBox();
        btnBox.setSpacing(15);
        btnBox.getChildren().add(btnOK);
        btnBox.getChildren().add(btnCancel);
        paneInfo.add(btnBox, 1, 11);

    }

    public Conference getConference()
    {
        return this.controller.conference;
    }

    public boolean getResult()
    {
        return this.controller.result;
    }

    private Controller controller = new Controller();

    private class Controller
    {

        private Conference conference;
        ArrayList<Hotel> availableHotels = new ArrayList<>(Storage.getAllHotels());
        ArrayList<Hotel> addedHotels = new ArrayList<>();
        private boolean result = false;

        private void okAction()
        {

            String name = ConferenceAdministration.this.name.getText();
            if (name.length() == 0) {
                ConferenceAdministration.this.lblError.setText("Name is empty");
                return;
            }

            if (ConferenceAdministration.this.startDate.getValue() == null
                    || ConferenceAdministration.this.endDate.getValue() == null) {
                ConferenceAdministration.this.lblError.setText("Select a Date");
                return;
            }

            LocalDate startDate = ConferenceAdministration.this.startDate.getValue();
            LocalDate endDate = ConferenceAdministration.this.endDate.getValue();

            if (endDate.isBefore(startDate)) {
                ConferenceAdministration.this.lblError
                        .setText("End date cannot be before start date");
                return;
            }

            int price = -1;
            try {
                price = Integer.parseInt(ConferenceAdministration.this.price.getText());
            } catch (NumberFormatException ex) {
                // do nothing
            }
            if (price < 0) {
                ConferenceAdministration.this.lblError.setText("Price is not a positive number");
                return;
            }

            this.conference = Service.createConference(name, price, startDate, endDate);

            for (Excursion excursion : ConferenceAdministration.this.arrExcursions) {
                Service.createExcursion(excursion.getName(), excursion.getDate(),
                        excursion.getPrice(), this.conference);
            }

            if (!this.addedHotels.isEmpty()) {
                for (Hotel hotel : this.addedHotels) {
                    this.conference.addHotel(hotel);
                }
            }

            this.result = true;
            ConferenceAdministration.this.hide();

        }

        private void addExcursionAction()
        {

            LocalDate startDate = ConferenceAdministration.this.startDate.getValue();
            LocalDate endDate = ConferenceAdministration.this.endDate.getValue();

            if (startDate == null || endDate == null) {
                ConferenceAdministration.this.lblError
                        .setText("Set the dates before adding excursions");
                return;
            }

            Stage stage = (Stage) ConferenceAdministration.this.listExcursions.getScene()
                    .getWindow();

            ExcursionAdministration dialog = new ExcursionAdministration(stage);
            dialog.getDates(startDate, endDate);
            dialog.showAndWait();

            if (dialog.getResult()) {
                Excursion excursion = dialog.returnResult();

                ConferenceAdministration.this.arrExcursions.add(excursion);
                ConferenceAdministration.this.listExcursions.getItems()
                        .setAll(ConferenceAdministration.this.arrExcursions);
            }
        }

        private void addHotelAction()
        {
            Hotel hotel = ConferenceAdministration.this.availableHotels.getSelectionModel()
                    .getSelectedItem();
            int index = ConferenceAdministration.this.availableHotels.getSelectionModel()
                    .getSelectedIndex();
            if (hotel == null) {
                return;
            }
            this.availableHotels.remove(index);
            this.addedHotels.add(hotel);
            ConferenceAdministration.this.availableHotels.getItems().clear();
            ConferenceAdministration.this.availableHotels.getItems().addAll(this.availableHotels);
            ConferenceAdministration.this.addedHotels.getItems().clear();
            ConferenceAdministration.this.addedHotels.getItems().addAll(this.addedHotels);
        }

        private void removeHotelAction()
        {
            Hotel hotel = ConferenceAdministration.this.addedHotels.getSelectionModel()
                    .getSelectedItem();
            int index = ConferenceAdministration.this.addedHotels.getSelectionModel()
                    .getSelectedIndex();
            if (hotel == null) {
                return;
            }
            this.addedHotels.remove(index);
            this.availableHotels.add(hotel);
            ConferenceAdministration.this.availableHotels.getItems().clear();
            ConferenceAdministration.this.availableHotels.getItems().addAll(this.availableHotels);
            ConferenceAdministration.this.addedHotels.getItems().clear();
            ConferenceAdministration.this.addedHotels.getItems().addAll(this.addedHotels);
        }

        private void cancelAction()
        {
            this.result = false;
            ConferenceAdministration.this.hide();
        }

    }

}
