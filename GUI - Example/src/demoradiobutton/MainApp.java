package demoradiobutton;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
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
        stage.setTitle("Gui Demo: Radiobuttons");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private Label lblTxt;
    private ToggleGroup colorsGroup;

    private void initContent(GridPane pane)
    {
        //pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        HBox box = new HBox(20);
        pane.add(box, 0, 0);

        this.colorsGroup = new ToggleGroup();
        String[] colors = { "Red", "Blue", "Green", "Orange" };
        for (String s : colors) {
            RadioButton rb = new RadioButton();
            rb.setToggleGroup(this.colorsGroup);
            rb.setText(s);
            box.getChildren().add(rb);
        }

        ChangeListener<Toggle> listener = (ov, oldValue, newValue) -> this.colorsToggleSelected();
        this.colorsGroup.selectedToggleProperty().addListener(listener);

        this.lblTxt = new Label("Radiobutton example");
        pane.add(this.lblTxt, 0, 1);
        GridPane.setHalignment(this.lblTxt, HPos.CENTER);
    }

    // -------------------------------------------------------------------------
    // Selected RadioButton changed in colorsGroup

    private void colorsToggleSelected()
    {
        RadioButton selected = (RadioButton) this.colorsGroup.getSelectedToggle();
        Color color = Color.web(selected.getText());
        this.lblTxt.setTextFill(color);
    }

}
