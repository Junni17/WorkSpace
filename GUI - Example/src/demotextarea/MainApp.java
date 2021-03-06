package demotextarea;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
        stage.setTitle("Gui Demo: TextArea");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private TextArea txaDescription;

    private void initContent(GridPane pane)
    {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        Label lblName = new Label("TextArea:");
        pane.add(lblName, 0, 0);

        this.txaDescription = new TextArea();
        pane.add(this.txaDescription, 0, 1);
        this.txaDescription.setPrefRowCount(7);
        this.txaDescription.setPrefWidth(270);
        this.txaDescription.setEditable(false);

        Button btnFill = new Button("Fill TextArea");
        pane.add(btnFill, 1, 1);
        btnFill.setOnAction(event -> this.fillAction());
    }

    // -------------------------------------------------------------------------

    private void fillAction()
    {
        this.txaDescription.setText(this.getDescription());
    }

    private String getDescription()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("A text area is often used for output.\n");
        sb.append("This text has so many lines\n");
        sb.append("that a scrollbar is added to the right, \n");
        sb.append("as you can see for yourself.\n");
        sb.append("You will have to scroll down\n");
        sb.append("to see the last line.\n");
        sb.append("\n");
        sb.append("This is the last line.");
        return sb.toString();
    }

}
