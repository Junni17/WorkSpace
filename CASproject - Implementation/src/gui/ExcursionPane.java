package gui;

import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Conference;
import model.Excursion;

public class ExcursionPane extends GridPane
{

    public ExcursionPane()
    {
        this.initContent();
    }

    // -------------------------------------------------------------------------

    private ListView<Excursion> excursions;

    private void initContent()
    {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(true);

        Label lblComp = new Label("Excursions:");
        this.add(lblComp, 0, 0);
        GridPane.setValignment(lblComp, VPos.BASELINE);

        this.excursions = new ListView<>();
        this.add(this.excursions, 0, 1);
        this.excursions.setPrefWidth(300);
        this.excursions.setPrefHeight(300);
        GridPane.setValignment(this.excursions, VPos.BASELINE);

        Button btnCreate = new Button("Create");
        this.add(btnCreate, 0, 2);
        btnCreate.setOnAction(event -> this.controller.createOnAction());
        GridPane.setValignment(btnCreate, VPos.BASELINE);

        if (this.excursions.getItems().size() > 0) {
            this.excursions.getSelectionModel().select(0);
        }
    }

    // Sets the excursion listview according to the chosen conference
    public void setExcursions(Conference conference)
    {
        ExcursionPane.this.excursions.getItems().setAll(conference.getExcursions());
    }

    // Sets the conference which to add another conference (if creation is
    // chosen)
    public void setConference(Conference conference)
    {
        this.controller.conference = conference;
    }

    Controller controller = new Controller();

    private class Controller
    {

        private Conference conference;

        private void createOnAction()
        {

            Stage stage = (Stage) ExcursionPane.this.excursions.getScene().getWindow();
            ExcursionAdministration dialog = new ExcursionAdministration(stage);
            dialog.getConference(this.conference);

            dialog.showAndWait();

            if (dialog.getResult()) {
                ExcursionPane.this.excursions.getItems().setAll(this.conference.getExcursions());
            }

        }

    }

}
