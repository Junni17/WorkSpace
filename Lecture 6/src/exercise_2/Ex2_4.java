package exercise_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ex2_4 extends Application {
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

	private void drawShapes(GraphicsContext gc) {
		gc.strokeRect(0, 0, 200, 200);
		// gc.strokeOval(x - r, y - 2, 2 * r, 2 * r);
		// kan man bruge når man vil tegne en cirkel med centrum i (x, y) r =
		// radius

		// Figure 1

		// int x = 100; // center: (x,y)
		// int y = 100;
		// int r = 20; // radius
		// while (r <= 100) {
		// gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
		// r = r + 20;
		// }

		// Figure 2

		int x = 30; // center: (x,y)
		int y = 110;
		int r = 10; // radius
		while (r <= 80) {
			gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
			r = r + 10;
			x = x + 10;
		}

		// Figure 3

		// int x = 85;
		// int y = 50;
		// int l = 30; // length
		// int h = 100; // height
		// while (x >= 10) {
		// gc.strokeOval(x, y, l, h);
		// l = l + 20;
		// x = x - 10;
		// }
	}
}
