package example1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HouseExercise extends Application {

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

		Rectangle house = new Rectangle();
		house.setX(50);
		house.setY(200);
		house.setWidth(120);
		house.setHeight(120);
		house.setFill(Color.RED);
		pane.getChildren().add(house);

		Rectangle window = new Rectangle();
		window.setX(70);
		window.setY(220);
		window.setWidth(40);
		window.setHeight(40);
		window.setFill(Color.BLACK);
		pane.getChildren().add(window);

		Line garden = new Line(40, 320, 300, 320);
		garden.setFill(Color.BLACK);
		pane.getChildren().add(garden);

		Circle sun = new Circle(250, 120, 35);
		sun.setFill(Color.YELLOW);
		sun.setStroke(Color.BLACK);
		pane.getChildren().add(sun);

		Polygon roof = new Polygon(40, 200, 180, 200, 110, 100);
		roof.setFill(Color.GREEN);
		pane.getChildren().add(roof);

	}

}
