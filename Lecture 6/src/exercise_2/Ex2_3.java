package exercise_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ex2_3 extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		GridPane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Loops");
		stage.setScene(scene);
		stage.show();
	}

	private GridPane initContent() {
		GridPane pane = new GridPane();
		Canvas canvas = new Canvas(200, 200);
		pane.add(canvas, 0, 0);
		this.drawShapes(canvas.getGraphicsContext2D());
		return pane;
	}

	// ------------------------------------------------------------------------

	// Figure 1:

	// private void drawShapes(GraphicsContext gc) {
	// int x = 20; // start point: (x1, y1)
	// int y1 = 190;
	// int y2 = 10;
	// while (x <= 180) {
	// gc.strokeLine(x, y1, x, y2);
	// x = x + 40;
	// }
	// }

	// Figure 2:

	// private void drawShapes(GraphicsContext gc) {
	// int x = 20; // start point: (x1, y1)
	// int x1 = 190;
	// int y = 20;
	// while (y <= 180) {
	// gc.strokeLine(x, y, x1, y);
	// y = y + 40;
	// }
	// }

	// Figure 3:

	private void drawShapes(GraphicsContext gc) {
		gc.strokeRect(0, 0, 200, 200);
		int x = 90; // start point: (x1, y1)
		int x1 = 110;
		int y = 20;
		while (x1 <= 190) {
			gc.strokeLine(x, y, x1, y);
			x = x - 20;
			x1 = x1 + 20;
			y = y + 40;
		}
	}

}
