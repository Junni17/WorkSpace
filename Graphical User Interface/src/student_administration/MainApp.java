package student_administration;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Student Administration");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private TextArea txaDescription;
	private TextField name;
	private TextField age;
	private CheckBox active;
	private Student student;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);

		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(20);

		Label name = new Label("Name:");
		pane.add(name, 0, 1);

		this.name = new TextField();
		pane.add(this.name, 1, 1, 1, 1);
		GridPane.setMargin(this.name, new Insets(0, 0, 0, -250));
		this.name.setMaxWidth(170);

		Label age = new Label("Age:");
		pane.add(age, 0, 2);

		this.age = new TextField();
		pane.add(this.age, 1, 2, 1, 1);
		GridPane.setMargin(this.age, new Insets(0, 0, 0, -250));
		this.age.setMaxWidth(85);

		Label active = new Label("Active:");
		pane.add(active, 0, 3);

		this.active = new CheckBox();
		pane.add(this.active, 1, 3);
		GridPane.setMargin(this.active, new Insets(0, 0, 0, -250));

		this.txaDescription = new TextArea();
		pane.add(this.txaDescription, 0, 0);
		this.txaDescription.setPrefRowCount(7);
		this.txaDescription.setPrefWidth(270);
		this.txaDescription.setEditable(false);

		Button create = new Button("Create");
		pane.add(create, 0, 4);
		GridPane.setMargin(create, new Insets(0, 0, 0, 25));
		create.setMaxWidth(55);

		Button save = new Button("Save");
		pane.add(save, 0, 4);
		GridPane.setMargin(save, new Insets(0, 0, 0, 100));
		save.setMaxWidth(55);

		Button delete = new Button("Delete");
		pane.add(delete, 0, 4);
		GridPane.setMargin(delete, new Insets(0, 0, 0, 175));
		delete.setMaxWidth(55);

		Button inc = new Button("Inc");
		pane.add(inc, 2, 2);
		GridPane.setMargin(inc, new Insets(0, 0, 0, -165));
		inc.setMaxWidth(55);

		Button reset = new Button("Reset");
		pane.add(reset, 2, 1);
		GridPane.setMargin(reset, new Insets(0, 0, 0, -80));
		reset.setMaxWidth(55);

		create.setOnAction(event -> this.create());
		save.setOnAction(event -> this.save());
		delete.setOnAction(event -> this.delete());
		inc.setOnAction(event -> this.increment());
		reset.setOnAction(event -> this.reset());
	}

	// -------------------------------------------------------------------------

	// private void fillAction() {
	// this.txaDescription.setText(this.getDescription());
	// }

	private void create() {
		if (this.name.getText().equals("") || this.age.getText().equals("")) {
		} else {
			this.student = new Student();
			this.student.setName(this.name.getText());
			this.student.setAge(Integer.parseInt(this.age.getText()));
			if (this.active.isSelected()) {
				this.student.setActive(true);
			} else {
				this.student.setActive(false);
			}
			this.txaDescription.setText(this.getDescription());
			this.name.clear();
			this.age.clear();
			this.active.setSelected(false);
		}
	}

	private void save() {
		if (this.student != null) {
			if (!this.name.getText().isEmpty()) {
				this.student.setName(this.name.getText());
			}
			if (!this.age.getText().isEmpty()) {
				this.student.setAge(Integer.parseInt(this.age.getText()));
			}
			this.txaDescription.setText(this.getDescription());
			this.name.clear();
			this.age.clear();
			this.active.setSelected(false);
		}
	}

	private void delete() {
		this.student = null;
		this.txaDescription.clear();
		this.name.clear();
		this.age.clear();
		this.active.setSelected(false);
	}

	private void increment() {
		if (!this.age.getText().equals("") && this.student != null) {
			this.student.incAge();
			this.age.setText(Integer.toString(this.student.getAge()));
		}
	}

	private void reset() {
		if (this.student != null) {
			this.name.setText(this.student.getName());
			this.age.setText(Integer.toString(this.student.getAge()));
			if (this.student.getActive() == true) {
				this.active.setSelected(true);
			} else {
				this.active.setSelected(false);
			}
			this.txaDescription.clear();
		}
	}

	private String getDescription() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: " + this.student.getName() + "\n");
		sb.append("Age: " + this.student.getAge() + "\n");
		sb.append("Active: " + this.student.getActive() + "\n");
		return sb.toString();
	}

}
