package gui;

import java.util.Optional;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Employee;
import service.Service;
import storage.Storage;

public class EmployeePane extends GridPane {
	private Controller controller = new Controller();

	public EmployeePane() {
		this.initControls();
	}

	// -------------------------------------------------------------------------

	private TextField txfName, txfWage, txfCompany, txfSalary, txfEmployYear;
	private ListView<Employee> lvwEmployees;

	private void initControls() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Employees");
		this.add(lblComp, 0, 0);

		this.lvwEmployees = new ListView<>();
		this.add(this.lvwEmployees, 0, 1, 1, 6);
		this.lvwEmployees.setPrefWidth(200);
		this.lvwEmployees.setPrefHeight(200);
		this.lvwEmployees.getItems().setAll(Storage.getAllEmployees());

		ChangeListener<Employee> listener = (ov, oldEmployee, newEmployee) -> this.controller.selectedEmployeeChanged();
		this.lvwEmployees.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblName = new Label("Name:");
		this.add(lblName, 1, 1);

		this.txfName = new TextField();
		this.add(this.txfName, 2, 1);
		this.txfName.setPrefWidth(200);
		this.txfName.setEditable(false);

		Label lblWage = new Label("Hourly Wage:");
		this.add(lblWage, 1, 2);

		this.txfWage = new TextField();
		this.add(this.txfWage, 2, 2);
		this.txfWage.setEditable(false);

		Label lblCompany = new Label("Company:");
		this.add(lblCompany, 1, 3);

		this.txfCompany = new TextField();
		this.add(this.txfCompany, 2, 3);
		this.txfCompany.setEditable(false);

		Label lblSalary = new Label("Weekly Salary:");
		this.add(lblSalary, 1, 4);

		this.txfSalary = new TextField();
		this.add(this.txfSalary, 2, 4);
		this.txfSalary.setEditable(false);

		Label lblEmployYear = new Label("Employment Year:");
		this.add(lblEmployYear, 1, 5);

		this.txfEmployYear = new TextField();
		this.add(this.txfEmployYear, 2, 5);
		this.txfEmployYear.setEditable(false);

		HBox hbxButtons = new HBox(40);
		this.add(hbxButtons, 0, 7, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_CENTER);

		Button btnCreate = new Button("Create");
		hbxButtons.getChildren().add(btnCreate);
		btnCreate.setOnAction(event -> this.controller.createAction());

		Button btnUpdate = new Button("Update");
		hbxButtons.getChildren().add(btnUpdate);
		btnUpdate.setOnAction(event -> this.controller.updateAction());

		Button btnDelete = new Button("Delete");
		hbxButtons.getChildren().add(btnDelete);
		btnDelete.setOnAction(event -> this.controller.deleteAction());

		if (this.lvwEmployees.getItems().size() > 0) {
			this.lvwEmployees.getSelectionModel().select(0);
		}
	}

	public void updateControls() {
		this.controller.updateControls();
	}

	// -------------------------------------------------------------------------

	private class Controller {
		private EmployeeDialog createDialog, updateDialog;
		private Alert deleteAlert;

		public void updateControls() {
			Employee employee = EmployeePane.this.lvwEmployees.getSelectionModel().getSelectedItem();
			if (employee != null) {
				EmployeePane.this.txfName.setText(employee.getName());
				EmployeePane.this.txfWage.setText("kr " + employee.getWage());
				if (employee.getCompany() != null) {
					EmployeePane.this.txfCompany.setText("" + employee.getCompany());
					EmployeePane.this.txfSalary.setText("kr " + employee.weeklySalary());
					EmployeePane.this.txfEmployYear.setText("År " + employee.getEmploymentyear());
				} else {
					EmployeePane.this.txfCompany.clear();
					EmployeePane.this.txfSalary.clear();
					EmployeePane.this.txfEmployYear.clear();
				}
			} else {
				EmployeePane.this.txfName.clear();
				EmployeePane.this.txfWage.clear();
				EmployeePane.this.txfCompany.clear();
				EmployeePane.this.txfSalary.clear();
			}
		}

		// --------------------------------------------------------------------

		// Create button action
		public void createAction() {
			if (this.createDialog == null) {
				this.createDialog = new EmployeeDialog("Create Employee");
				Stage stage = (Stage) EmployeePane.this.lvwEmployees.getScene().getWindow();
				this.createDialog.initOwner(stage);
			}

			this.createDialog.setEmployee(null);
			this.createDialog.showAndWait();
			// ... wait for the dialog to close

			boolean isCreated = this.createDialog.getResult();
			if (isCreated) {
				EmployeePane.this.lvwEmployees.getItems().setAll(Storage.getAllEmployees());
				int index = EmployeePane.this.lvwEmployees.getItems().size() - 1;
				EmployeePane.this.lvwEmployees.getSelectionModel().select(index);
			}
			this.updateControls();
		}

		// Update button action
		public void updateAction() {
			Employee employee = EmployeePane.this.lvwEmployees.getSelectionModel().getSelectedItem();
			if (employee == null) {
				return;
			}

			if (this.updateDialog == null) {
				this.updateDialog = new EmployeeDialog("Update Employee");
				Stage stage = (Stage) EmployeePane.this.lvwEmployees.getScene().getWindow();
				this.updateDialog.initOwner(stage);
			}

			this.updateDialog.setEmployee(employee);
			this.updateDialog.showAndWait();
			// ... wait for the dialog to close

			boolean isUpdated = this.updateDialog.getResult();
			if (isUpdated) {
				int selectIndex = EmployeePane.this.lvwEmployees.getSelectionModel().getSelectedIndex();
				EmployeePane.this.lvwEmployees.getItems().setAll(Storage.getAllEmployees());
				EmployeePane.this.lvwEmployees.getSelectionModel().select(selectIndex);
			}
		}

		// Delete button action
		public void deleteAction() {
			Employee employee = EmployeePane.this.lvwEmployees.getSelectionModel().getSelectedItem();
			if (employee == null) {
				return;
			}

			if (this.deleteAlert == null) {
				this.deleteAlert = new Alert(AlertType.CONFIRMATION);
				this.deleteAlert.setTitle("Confirmation");
				this.deleteAlert.setHeaderText("Delete the employee?");
				this.deleteAlert.setContentText("Deletion can't be undone");
				Stage stage = (Stage) EmployeePane.this.lvwEmployees.getScene().getWindow();
				this.deleteAlert.initOwner(stage);
			}

			Optional<ButtonType> result = this.deleteAlert.showAndWait();
			// ... wait for the dialog to close

			if (result.isPresent() && result.get() == ButtonType.OK) {
				Service.deleteEmployee(employee);
				EmployeePane.this.lvwEmployees.getItems().setAll(Storage.getAllEmployees());
				this.updateControls();
			}
		}

		// Selected item in lvwEmployees changed
		public void selectedEmployeeChanged() {
			this.updateControls();
		}
	}

}
