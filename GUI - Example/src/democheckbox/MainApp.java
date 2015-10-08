package democheckbox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Gui Demo: Checkbox");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private TextField txfName;
    private CheckBox checkBox;

    private void initContent(GridPane pane)
    {
//        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        this.txfName = new TextField("Mikael");
        pane.add(this.txfName, 1, 0);
        this.txfName.setDisable(true);

        this.checkBox = new CheckBox("Allow name change");
        pane.add(this.checkBox, 1, 1);
        this.checkBox.setOnAction(event -> this.checkBoxAction());
    }

    // -------------------------------------------------------------------------
    // CheckBox action

    private void checkBoxAction()
    {
        if (this.checkBox.isSelected()) {
            this.txfName.setDisable(false);
        }
        else {
            this.txfName.setDisable(true);
        }
    }

}
