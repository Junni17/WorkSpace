package example1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise2 extends Application {
	int random = 100;
	Color color = Color.BLUE;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Pane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Shapes");
		stage.setScene(scene);
		stage.show();
	}

	private Pane initContent() {
		Pane pane = new Pane();
		pane.setPrefSize(400, 400);
		this.drawShapes(pane);
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(Pane pane)

	{

		Rectangle rectangle = new Rectangle();
		rectangle.setX(this.random);
		rectangle.setY(100);
		rectangle.setWidth(200);
		rectangle.setHeight(100);
		rectangle.setFill(this.color);
		rectangle.setStroke(this.color);
		pane.getChildren().add(rectangle);

		Text text = new Text(135, 162, "Jonas");
		text.setFill(Color.RED);
		text.setStyle("-fx-font-size:50");
		pane.getChildren().add(text);
	}

}
