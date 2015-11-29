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
import model.Conference;

public class ExcursionAdministration extends Stage
{

    public ExcursionAdministration(Stage owner)
    {
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
    private DatePicker date;

    private void initContent(GridPane pane)
    {
        pane.setGridLinesVisible(true);
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setPadding(new Insets(20));

        Label lblCreate = new Label("Create Excursion");
        Label lblName = new Label("Name:");
        Label lblPrice = new Label("Price:");
        Label lblDate = new Label("Date:");

        pane.add(lblCreate, 1, 0);

        pane.add(lblName, 0, 1);

        this.name = new TextField();
        pane.add(this.name, 1, 1);

        pane.add(lblPrice, 0, 2);

        this.price = new TextField();
        pane.add(this.price, 1, 2);

        pane.add(lblDate, 0, 3);

        this.date = new DatePicker();
        pane.add(this.date, 1, 3);

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
        pane.add(btnBox, 1, 4);

    }

    public void getConference(Conference conference)
    {
        this.controller.conference = conference;
    }

    public boolean getResult()
    {
        return this.controller.result;
    }

    private Controller controller = new Controller();

    private class Controller
    {

        private Conference conference;
        private boolean result = false;

        private void okAction()
        {
            String name = ExcursionAdministration.this.name.getText();
            int price = Integer.parseInt(ExcursionAdministration.this.price.getText());
            LocalDate date = ExcursionAdministration.this.date.getValue();

            this.result = true;

            ExcursionAdministration.this.hide();

        }

        private void cancelAction()
        {
            ExcursionAdministration.this.hide();
        }

    }

}
