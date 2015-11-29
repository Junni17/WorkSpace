package gui;

import java.util.Optional;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Newsflash;
import storage.Storage;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Newsflash");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private ListView<Newsflash> headers;
	private TextArea content;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(!true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label header = new Label("Headers");
		pane.add(header, 0, 0);

		this.headers = new ListView<Newsflash>();
		this.headers.getItems().setAll(Storage.getAllNewsflashes());
		this.headers.setPrefHeight(200);
		this.headers.setPrefWidth(150);
		pane.add(this.headers, 0, 1, 2, 1);

		Label content = new Label("Content");
		pane.add(content, 2, 0);

		this.content = new TextArea();
		this.content.setPrefHeight(200);
		this.content.setPrefWidth(400);
		this.content.setEditable(false);
		pane.add(this.content, 2, 1, 3, 1);

		ChangeListener<Newsflash> listener = (ov, oldString, newString) -> this.controller.newsflashItemSelected();
		this.headers.getSelectionModel().selectedItemProperty().addListener(listener);

		Button createNewsflash = new Button("Create");
		createNewsflash.setPrefWidth(60);
		createNewsflash.setOnAction(event -> this.controller.createOnAction());

		Button deleteNewsflash = new Button("Delete");
		deleteNewsflash.setPrefWidth(60);
		deleteNewsflash.setOnAction(event -> this.controller.deleteOnAction());

		Button updateNewsflash = new Button("Update");
		updateNewsflash.setPrefWidth(60);
		updateNewsflash.setOnAction(event -> this.controller.updateOnAction());

		HBox buttons = new HBox();
		pane.add(buttons, 0, 2, 2, 1);
		buttons.setSpacing(15);
		buttons.getChildren().add(createNewsflash);
		buttons.getChildren().add(deleteNewsflash);
		buttons.getChildren().add(updateNewsflash);

	}

	Controller controller = new Controller();

	private class Controller {

		private void newsflashItemSelected() {

			Newsflash selected = MainApp.this.headers.getSelectionModel().getSelectedItem();
			if (selected != null) {
				MainApp.this.content.setText(selected.getContent());
			}

		}

		private void createOnAction() {

			Stage stage = (Stage) MainApp.this.headers.getScene().getWindow();
			NewsflashAdministration dialog = new NewsflashAdministration(stage);
			dialog.existingNewsflash(null);
			dialog.showAndWait();

			if (dialog.getResult()) {
				MainApp.this.headers.getItems().setAll(Storage.getAllNewsflashes());
			}

			int index = Storage.getAllNewsflashes().size() - 1;
			MainApp.this.headers.getSelectionModel().select(index);

		}

		private void deleteOnAction() {

			if (MainApp.this.headers.getSelectionModel().getSelectedItem() != null) {

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Deletion");
				String s = "You are deleting a Newsflash. It can't be undone.";
				alert.setContentText(s);

				Optional<ButtonType> result = alert.showAndWait();

				if ((result.isPresent()) && (result.get() == ButtonType.OK)) {

					Newsflash selected = MainApp.this.headers.getSelectionModel().getSelectedItem();
					Storage.deleteNewsflash(selected);
					MainApp.this.headers.getItems().setAll(Storage.getAllNewsflashes());
					MainApp.this.content.clear();

				}

			}

		}

		private void updateOnAction() {

			if (MainApp.this.headers.getSelectionModel().getSelectedItem() != null) {

				Newsflash selected = MainApp.this.headers.getSelectionModel().getSelectedItem();
				int selectionIndex = MainApp.this.headers.getSelectionModel().getSelectedIndex();

				Stage stage = (Stage) MainApp.this.headers.getScene().getWindow();
				NewsflashAdministration dialog = new NewsflashAdministration(stage);
				dialog.setTitle("Update Newsflash");
				dialog.existingNewsflash(selected);
				dialog.showAndWait();

				if (dialog.getResult()) {
					MainApp.this.headers.getItems().setAll(Storage.getAllNewsflashes());
					MainApp.this.headers.getSelectionModel().select(selectionIndex);
				}

			}

		}

	}
}
