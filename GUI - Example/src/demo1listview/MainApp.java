package demo1listview;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
        stage.setTitle("ListView Demo1");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private ArrayList<String> names;
    private TextField txfName;
    private ListView<String> lvwNames;

    private void initContent(GridPane pane)
    {
        this.initNames();

//        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 0);

        lvwNames = new ListView<String>();
        pane.add(lvwNames, 0, 1);
        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);
        lvwNames.getItems().setAll(names);

        ChangeListener<String> listener =
            (ov, oldString, newString) -> this.namesItemSelected();
        lvwNames.getSelectionModel().selectedItemProperty().addListener(listener);

        VBox vbox = new VBox(5);
        pane.add(vbox, 1, 1);

        Label lblSelected = new Label("Selected:");
        vbox.getChildren().add(lblSelected);

        txfName = new TextField();
        vbox.getChildren().add(txfName);

    }

    private void initNames()
    {
        String[] items =
        { "Jane", "Eva", "Lene", "Mette", "Tine", "Line", "Lone", "Alberte", "Pia" };
        names = new ArrayList<>(Arrays.asList(items));
    }

    // -------------------------------------------------------------------------
    // Selected item changed in lvwNames

    private void namesItemSelected()
    {
        String selected = lvwNames.getSelectionModel().getSelectedItem();
        if (selected != null) {
            txfName.setText(selected);
        }
        else {
            txfName.clear();
        }
    }

}
