package gui;

import java.time.LocalDate;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Excursion;

public class ExcursionAdministration extends Stage
{

	public ExcursionAdministration(Stage owner) {
		this.initOwner(owner);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle("Add Excursions");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	private TextField name;
	private TextField price;
	private DatePicker date;
	private Label lblError;

	private void initContent(GridPane pane)
	{
		pane.setGridLinesVisible(!true);
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setPadding(new Insets(20));
		pane.getColumnConstraints().add(new ColumnConstraints(60));

		Label lblName = new Label("Name:");
		Label lblPrice = new Label("Price:");
		Label lblDates = new Label("Date:");

		this.lblError = new Label();
		pane.add(this.lblError, 1, 3, 2, 1);

		pane.add(lblName, 0, 0);
		pane.add(lblPrice, 0, 1);
		pane.add(lblDates, 0, 2);

		this.name = new TextField();
		pane.add(this.name, 1, 0);

		this.price = new TextField();
		pane.add(this.price, 1, 1);

		this.date = new DatePicker();
		pane.add(this.date, 1, 2);

		Button btnAdd = new Button("Add");
		btnAdd.setPrefWidth(60);
		btnAdd.setOnAction(event -> this.controller.okAction());

		Button btnCancel = new Button("Cancel");
		btnCancel.setPrefWidth(60);
		btnCancel.setOnAction(event -> this.controller.cancelAction());

		HBox btnBox = new HBox();
		btnBox.setSpacing(15);
		btnBox.getChildren().add(btnAdd);
		btnBox.getChildren().add(btnCancel);
		pane.add(btnBox, 1, 4);

	}

	// returns the created excursion
	public Excursion returnResult()
	{
		return this.controller.excursion;
	}

	public boolean getResult()
	{
		return this.controller.result;
	}

	public void getDates(LocalDate startDate, LocalDate endDate)
	{
		this.controller.startDate = startDate;
		this.controller.endDate = endDate;
	}

	private Controller controller = new Controller();

	private class Controller
	{

		private Excursion excursion;
		private boolean result = false;
		private LocalDate startDate;
		private LocalDate endDate;

		private void okAction()
		{
			String name = ExcursionAdministration.this.name.getText();

			if (name.length() == 0) {
				ExcursionAdministration.this.lblError.setText("Name is empty");
				return;
			}

			int price = -1;
			try {
				price = Integer.parseInt(ExcursionAdministration.this.price.getText());
			} catch (NumberFormatException ex) {
				// do nothing
			}
			if (price < 0) {
				ExcursionAdministration.this.lblError.setText("Price is not a positive number");
				return;
			}

			if (date.getValue() == null) {
				ExcursionAdministration.this.lblError.setText("Enter a Date");
				return;
			}

			LocalDate date = ExcursionAdministration.this.date.getValue();

			if (date.isAfter(this.endDate) || date.isBefore(this.startDate)) {
				ExcursionAdministration.this.lblError.setText("Invalid dates");
				return;
			}

			this.excursion = new Excursion(name, date, price);

			this.result = true;
			ExcursionAdministration.this.hide();
		}

		private void cancelAction()
		{
			this.result = false;
			ExcursionAdministration.this.hide();
		}

	}

}
