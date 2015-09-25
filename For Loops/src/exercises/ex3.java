package exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ex3 extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent()
    {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------

   
        /*We want to draw 20 vertical lines with a distance of 8. The first line has to be at x = 10. So the xvalues
        of the lines will be 10, 18, 26, 34, and so forth.
        These x-values fit in with the formula 10 + i * 8, where i is the index variable: i = 0, 1, 2, �, 19.
        A way to make the drawing is to use a for-statement:*/
    	
//
//    	private void drawShapes(GraphicsContext gc)
//    	{
//    		 int y1 = 30; // start point: (x,y1)
//    		 int y2 = 60; // end point: (x,y2)
//    		 	for (int i = 0; i < 20; i++) {
//    		 		int x = 10 + i * 8;
//    		 		gc.strokeLine(x, y1, x, y2);
//    		 	}
//    	}
    
    //Create an application that draws an x-axis (the axis has 11 ticks, must use for loop)
    //Make every fifth vertical stroke twice as long
    
    private void drawShapes(GraphicsContext gc){
    	int y = 170;
    	
    	gc.strokeLine(0, y, 190, y);
    	
    	for (int i = 0; i < 11; i++){
    		
    		int x = 5 + i * 17 ;
    		

    		
    		if (i % 5 == 0){
    			gc.strokeLine(x, y - 10, x, y + 10);
    			gc.fillText(Integer.toString(i), x, y + 25);		
    		}else{
        		gc.strokeLine(x, y + 5, x, y - 5);
    		}
    		
    	}
    	
    	
    
    	
    	gc.strokeLine(185, y + 5, 190, y);
    	gc.strokeLine(185, y - 5, 190, y);
    	
    }
    
    

    	
}


