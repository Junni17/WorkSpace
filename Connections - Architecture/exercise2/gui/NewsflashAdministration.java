package gui;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Newsflash;
import service.Service;

public class NewsflashAdministration extends Stage {

	public NewsflashAdministration(Stage owner) {
		this.initOwner(owner);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle("Create Newsflash");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	private TextField header;
	private TextArea content;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(!true);
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setPadding(new Insets(20));

		this.header = new TextField();
		pane.add(this.header, 0, 1);
		this.header.setPrefWidth(400);

		this.content = new TextArea();
		this.content.setPrefWidth(400);
		pane.add(this.content, 0, 3);

		Label header = new Label("Header:");
		pane.add(header, 0, 0);

		Label content = new Label("Content:");
		pane.add(content, 0, 2);

		Button create = new Button("OK");
		create.setOnAction(event -> this.controller.okAction());
		create.setPrefWidth(50);
		create.addEventFilter(ActionEvent.ACTION, event -> this.controller.filterOkEvent(event));

		Button cancel = new Button("Cancel");
		cancel.setOnAction(event -> this.controller.cancelAction());

		HBox buttons = new HBox();
		buttons.setSpacing(15);
		buttons.getChildren().add(create);
		buttons.getChildren().add(cancel);
		pane.add(buttons, 0, 4);

	}

	public void existingNewsflash(Newsflash newsflash) {
		this.controller.newsflash = newsflash;
		this.controller.updateFields();
	}

	public boolean getResult() {
		return this.controller.result;
	}

	Controller controller = new Controller();

	private class Controller {

		private Newsflash newsflash;
		private boolean result = false;

		private void updateFields() {

			if (this.newsflash == null) {
				NewsflashAdministration.this.content.clear();
				NewsflashAdministration.this.header.clear();
			} else {
				NewsflashAdministration.this.content.setText(this.newsflash.getContent());
				NewsflashAdministration.this.header.setText(this.newsflash.getHeader());
			}

		}

		private void cancelAction() {
			NewsflashAdministration.this.hide();
		}

		private void filterOkEvent(ActionEvent event) {
			if (NewsflashAdministration.this.header.getText().isEmpty()
					|| NewsflashAdministration.this.content.getText().isEmpty()) {
				event.consume();
			}
		}

		private void okAction() {

			String header = NewsflashAdministration.this.header.getText();
			String content = NewsflashAdministration.this.content.getText();

			if (this.newsflash == null) {
				this.result = true;
				Service.createNewsflash(header, content);
				NewsflashAdministration.this.hide();
			} else {
				if (!this.newsflash.getContent().equals(content)) {
					this.result = true;
					Service.updateNewsflash(this.newsflash, header, content);
					NewsflashAdministration.this.hide();
				}
			}
			// NewsflashAdministration.this.hide();

		}

	}
}
