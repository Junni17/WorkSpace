package customdialog2;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustomDialogExample extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("JavaFX Dialogs Example");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private Text txtStatus;

    private void initContent(GridPane pane)
    {
        //pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(20);

        VBox vbox = new VBox(30);
        pane.add(vbox, 0, 0);
        vbox.setAlignment(Pos.CENTER);

        // header label
        Label lblHeader = new Label("Custom Dialog");
        vbox.getChildren().add(lblHeader);
        lblHeader.setTextFill(Color.DARKBLUE);
        lblHeader.setFont(Font.font("Calibri", FontWeight.BOLD, 36));

        // new PhoneBook entry button
        Button btnNewEntry = new Button("New PhoneBook Entry");
        vbox.getChildren().add(btnNewEntry);
        btnNewEntry.setOnAction(event -> controller.newEntryAction());

        // status text
        txtStatus = new Text("No text");
        vbox.getChildren().add(this.txtStatus);
        txtStatus.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
        txtStatus.setFill(Color.FIREBRICK);
    }

    //-------------------------------------------------------------------------

    private Controller controller = new Controller();

    private class Controller
    {
        public void newEntryAction()
        {
            Stage stage = (Stage) txtStatus.getScene().getWindow();
            NewPhoneBookEntryDialog dialog = new NewPhoneBookEntryDialog(stage);

            Optional<PhoneBook> result = dialog.showAndWait();
            // ... wait for the dialog to close

            if (result.isPresent()) {
                txtStatus.setText("Result: " + result.get());
            } else {
                txtStatus.setText("Result cancelled");
            }
        }
    }

}