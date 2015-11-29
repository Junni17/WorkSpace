package customdialog2;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewPhoneBookEntryDialog extends Dialog<PhoneBook>
{
    public NewPhoneBookEntryDialog(Stage owner)
    {
        this.initOwner(owner);
        this.setTitle("Custom Dialog");

        // a dialog (a subclass of the Dialog class) has 3 parts:
        // header, content and buttons

        // set the dialog's header
        this.getDialogPane().setHeaderText("New phone book entry");

        // set the dialog's content
        GridPane pane = new GridPane();
        this.initContent(pane);
        this.getDialogPane().setContent(pane);

        // set the dialog's buttons
        this.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        // convert result to PhoneBook object
        this.setResultConverter(buttonType -> controller.convertResult(buttonType));

        // prevent the dialog from closing if a text field is empty
        Button btnOk = (Button) this.getDialogPane().lookupButton(ButtonType.OK);
        btnOk.addEventFilter(ActionEvent.ACTION, event -> controller.filterOkEvent(event));
    }

    //-------------------------------------------------------------------------

    private TextField txfName, txfPhone;

    private void initContent(GridPane pane)
    {
        pane.setGridLinesVisible(true);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10));

        Label lblName = new Label("Name: ");
        pane.add(lblName, 0, 0);

        txfName = new TextField();
        pane.add(txfName, 1, 0);

        Label lblPhone = new Label("Phone: ");
        pane.add(lblPhone, 0, 1);

        txfPhone = new TextField();
        pane.add(txfPhone, 1, 1);
    }

    //-------------------------------------------------------------------------

    private Controller controller = new Controller();

    private class Controller
    {
        public PhoneBook convertResult(ButtonType buttonType)
        {
            if (buttonType == ButtonType.OK) {
                return new PhoneBook(txfName.getText(), txfPhone.getText());
            }
            return null;
        }

        public void filterOkEvent(ActionEvent event)
        {
            if (txfName.getText().isEmpty() || txfPhone.getText().isEmpty()) {
                event.consume();
                txfName.requestFocus();
            }
        }
    }

}
