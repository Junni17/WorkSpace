package example1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise1 extends Application {
	int random = 100;
	Color color = Color.YELLOW;

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

		Circle circle = new Circle(this.random, 200, 30);
		pane.getChildren().add(circle);
		circle.setFill(this.color);
		circle.setStroke(this.color);

		Circle circle2 = new Circle(300, 200, 30);
		pane.getChildren().add(circle2);
		circle2.setFill(this.color);
		circle2.setStroke(this.color);

		Line line = new Line(this.random, 300, 200, 300);
		pane.getChildren().add(line);
		line.setStrokeWidth(10);
		line.setFill(Color.BLACK);
		line.setStroke(Color.BLACK);

	}

}
