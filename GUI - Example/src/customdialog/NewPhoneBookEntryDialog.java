package customdialog;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class NewPhoneBookEntryDialog extends Dialog<PhoneBook>
{
    public NewPhoneBookEntryDialog()
    {
        this.setTitle("Custom Dialog");
        this.getDialogPane().setHeaderText("New phone book entry");

        // set content of the dialog's pane
        GridPane pane = new GridPane();
        this.initContent(pane);
        this.getDialogPane().setContent(pane);

        // add buttons to the dialog
        this.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        // convert result to PhoneBook object
        this.setResultConverter(buttonType -> this.convertResult(buttonType));

        // prevent dialog from closing if a text field is empty
        Button btOk = (Button) this.getDialogPane().lookupButton(ButtonType.OK);
        btOk.addEventFilter(ActionEvent.ACTION, event -> this.filterOkEvent(event));
    }

    //-------------------------------------------------------------------------

    private TextField text1, text2;

    private void initContent(GridPane pane)
    {
        //pane.setGridLinesVisible(true);
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setPadding(new Insets(20));

        Label label1 = new Label("Name: ");
        pane.add(label1, 0, 0);

        text1 = new TextField();
        pane.add(text1, 1, 0);

        Label label2 = new Label("Phone: ");
        pane.add(label2, 0, 1);

        text2 = new TextField();
        pane.add(text2, 1, 1);
    }

    private PhoneBook convertResult(ButtonType buttonType)
    {
        if (buttonType == ButtonType.OK) {
            return new PhoneBook(text1.getText(), text2.getText());
        }
        return null;
    }

    private void filterOkEvent(ActionEvent event)
    {
        if (text1.getText().isEmpty() || text2.getText().isEmpty()) {
            event.consume();
        }
    }

}
