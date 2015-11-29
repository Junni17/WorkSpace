package gui;

import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Company;
import model.Employee;
import service.Service;
import storage.Storage;

public class EmployeeDialog extends Stage {
	private Controller controller = new Controller();

	public EmployeeDialog(String title) {
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	// -------------------------------------------------------------------------

	private TextField txfName, txfWage, txfEmploymentYear;
	private CheckBox chbCompany;
	private ComboBox<Company> cbbCompany;
	private Label lblError;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(20, 20, 0, 20));
		pane.setHgap(10);
		pane.setVgap(5);
		pane.setGridLinesVisible(false);

		Label lblName = new Label("Name");
		pane.add(lblName, 0, 0);

		this.txfName = new TextField();
		pane.add(this.txfName, 0, 1);
		this.txfName.setPrefWidth(200);

		Label lblWage = new Label("Hourly Wage");
		pane.add(lblWage, 0, 2);
		GridPane.setMargin(lblWage, new Insets(10, 0, 0, 0));

		this.txfWage = new TextField();
		pane.add(this.txfWage, 0, 3);

		this.chbCompany = new CheckBox("Company");
		pane.add(this.chbCompany, 0, 4);
		GridPane.setMargin(this.chbCompany, new Insets(10, 10, 0, 1));
		ChangeListener<Boolean> listener = (ov, oldValue, newValue) -> this.controller.selectedCompanyChanged(newValue);
		this.chbCompany.selectedProperty().addListener(listener);

		this.cbbCompany = new ComboBox<>();
		pane.add(this.cbbCompany, 0, 5);
		this.cbbCompany.getItems().addAll(Storage.getAllCompanies());

		Label lblEmploymentYear = new Label("Employment Year");
		pane.add(lblEmploymentYear, 0, 6);

		this.txfEmploymentYear = new TextField();
		pane.add(this.txfEmploymentYear, 0, 7);

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 8);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		GridPane.setMargin(btnCancel, new Insets(10, 0, 0, 30));
		btnCancel.setOnAction(event -> this.controller.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 8);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		GridPane.setMargin(btnOK, new Insets(10, 30, 0, 0));
		btnOK.setOnAction(event -> this.controller.okAction());

		this.lblError = new Label();
		pane.add(this.lblError, 0, 9);
		GridPane.setMargin(this.lblError, new Insets(0, 0, 10, 0));
		this.lblError.setStyle("-fx-text-fill: red");
	}

	public void setEmployee(Employee employee) {
		this.controller.employee = employee;
		this.controller.updateControls();
	}

	public boolean getResult() {
		return this.controller.result;
	}

	// -------------------------------------------------------------------------

	private class Controller {
		private boolean result = false;
		private Employee employee;

		public void updateControls() {
			if (this.employee != null) {
				EmployeeDialog.this.txfName.setText(this.employee.getName());
				EmployeeDialog.this.txfWage.setText("" + this.employee.getWage());
				if (this.employee.getCompany() != null) {
					EmployeeDialog.this.chbCompany.setSelected(true);
					EmployeeDialog.this.cbbCompany.getSelectionModel().select(this.employee.getCompany());
					EmployeeDialog.this.cbbCompany.setDisable(false);
					EmployeeDialog.this.txfEmploymentYear.setText("" + this.employee.getEmploymentyear());
				} else {
					EmployeeDialog.this.cbbCompany.getSelectionModel().select(0);
					EmployeeDialog.this.cbbCompany.setDisable(true);
					EmployeeDialog.this.txfEmploymentYear.setDisable(true);
				}
			} else {
				EmployeeDialog.this.txfName.clear();
				EmployeeDialog.this.txfWage.clear();
				EmployeeDialog.this.chbCompany.setSelected(false);
				EmployeeDialog.this.cbbCompany.getSelectionModel().select(0);
				EmployeeDialog.this.cbbCompany.setDisable(true);
				EmployeeDialog.this.txfEmploymentYear.setDisable(true);
				EmployeeDialog.this.txfEmploymentYear.clear();
			}
			EmployeeDialog.this.lblError.setText("");
		}

		// ---------------------------------------------------------------------

		// Cancel button action
		public void cancelAction() {

			this.result = false;
			EmployeeDialog.this.hide();
		}

		// Ok Button action
		public void okAction() {
			String name = EmployeeDialog.this.txfName.getText().trim();
			if (name.length() == 0) {
				EmployeeDialog.this.lblError.setText("Name is empty");
				return;
			}

			int wage = -1;
			try {
				wage = Integer.parseInt(EmployeeDialog.this.txfWage.getText().trim());
			} catch (NumberFormatException ex) {
				// do nothing
			}
			if (wage < 0) {
				EmployeeDialog.this.lblError.setText("Wage is not a positive number");
				return;
			}

			boolean companyIsSelected = EmployeeDialog.this.chbCompany.isSelected();
			Company newCompany = EmployeeDialog.this.cbbCompany.getSelectionModel().getSelectedItem();

			if (companyIsSelected) {
				int year = -1;
				try {
					year = Integer.parseInt(EmployeeDialog.this.txfEmploymentYear.getText().trim());
				} catch (NumberFormatException ex) {
					// do nothing
				}
				if (year < 0) {
					EmployeeDialog.this.lblError.setText("Year is not a valid number");
					return;
				}
			}

			// Call Service methods
			if (this.employee != null) {
				Service.updateEmployee(this.employee, name, wage);
				if (companyIsSelected) {
					Service.setCompanyOfEmployee(this.employee, newCompany,
							Integer.parseInt(EmployeeDialog.this.txfEmploymentYear.getText()));
				}
			} else {
				Employee newEmployee = Service.createEmployee(name, wage);
				if (companyIsSelected) {

					Service.setCompanyOfEmployee(newEmployee, newCompany,
							Integer.parseInt(EmployeeDialog.this.txfEmploymentYear.getText()));

				}
			}

			this.result = true;
			EmployeeDialog.this.hide();
		}

		// Selection in chbCompany changed
		public void selectedCompanyChanged(boolean checked) {
			EmployeeDialog.this.cbbCompany.setDisable(!checked);
			EmployeeDialog.this.txfEmploymentYear.setDisable(!checked);
		}
	}

}
