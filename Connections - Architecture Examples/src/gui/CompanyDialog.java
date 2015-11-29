package gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Company;
import service.Service;

public class CompanyDialog extends Stage
{
    private Controller controller = new Controller();

    public CompanyDialog(String title)
    {
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private TextField txfName, txfHours;
    private Label lblError;

    private void initContent(GridPane pane)
    {
        pane.setPadding(new Insets(20, 20, 0, 20));
        pane.setHgap(10);
        pane.setVgap(5);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Name");
        pane.add(lblName, 0, 0);

        txfName = new TextField();
        pane.add(txfName, 0, 1);
        txfName.setPrefWidth(200);

        Label lblHours = new Label("Weekly Hours");
        pane.add(lblHours, 0, 2);
        GridPane.setMargin(lblHours, new Insets(10, 0, 0, 0));

        txfHours = new TextField();
        pane.add(txfHours, 0, 3);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 4);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        GridPane.setMargin(btnCancel, new Insets(10, 0, 0, 30));
        btnCancel.setOnAction(event -> controller.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 4);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        GridPane.setMargin(btnOK, new Insets(10, 30, 0, 0));
        btnOK.setOnAction(event -> controller.okAction());

        lblError = new Label();
        pane.add(lblError, 0, 5);
        GridPane.setMargin(lblError, new Insets(0, 0, 10, 0));
        lblError.setStyle("-fx-text-fill: red");
    }

    /**
     * Sets the company to be updated.<br/>
     * Note: company is null, if a new company is to be cerated.
     */
    public void setCompany(Company company)
    {
        controller.company = company;
        controller.updateControls();
    }

    /**
     * Return true, if a company is created or updated.
     */
    public boolean getResult()
    {
        return controller.result;
    }

    // -------------------------------------------------------------------------

    private class Controller
    {
        private boolean result = false;
        private Company company;

        public void updateControls()
        {
            if (controller.company != null) {
                txfName.setText(controller.company.getName());
                txfHours.setText("" + controller.company.getHours());
            } else {
                txfName.clear();
                txfHours.clear();
            }
            lblError.setText("");
        }

        // ---------------------------------------------------------------------

        // Cancel button action
        public void cancelAction()
        {
            result = false;
            CompanyDialog.this.hide();
        }

        // Ok button action
        public void okAction()
        {
            String name = txfName.getText().trim();
            if (name.length() == 0) {
                lblError.setText("Name is empty");
                return;
            }

            int hours = -1;
            try {
                hours = Integer.parseInt(txfHours.getText().trim());
            } catch (NumberFormatException ex) {
                // do nothing
            }
            if (hours < 0) {
                lblError.setText("Hours is not a positive number");
                return;
            }

            // Call service methods
            if (company != null) {
                Service.updateCompany(company, name, hours);
            } else {
                Service.createCompany(name, hours);
            }

            result = true;
            CompanyDialog.this.hide();
        }
    }

}
