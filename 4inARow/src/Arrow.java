
import javafx.scene.shape.*;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Arrow extends Pane {
	private final double WIDTH_MAIN_REC = 10.0;
	private final double LENGTH_MAIN_REC = 20.0;
	private final double CHANGE_SIZE = 3;
	private final double ZERO = 0.0;

	private Polygon theTriangle = new Polygon();
	private Rectangle mainRec = new Rectangle(WIDTH_MAIN_REC, LENGTH_MAIN_REC, Color.RED);
	private Rectangle connectRec = new Rectangle(WIDTH_MAIN_REC / CHANGE_SIZE, LENGTH_MAIN_REC / CHANGE_SIZE,
			Color.RED);

	// private double [] thePoints = new double [3];

	public Arrow() {
		theTriangle.getPoints()
				.addAll(new Double[] { ZERO, ZERO, LENGTH_MAIN_REC, WIDTH_MAIN_REC, WIDTH_MAIN_REC, LENGTH_MAIN_REC });
		VBox arrowVbox=new VBox(0);
		
		arrowVbox.getChildren().add(mainRec);
		arrowVbox.getChildren().add(connectRec);
		arrowVbox.getChildren().add(theTriangle);
		this.getChildren().add(arrowVbox);
	}

	public Polygon getTheTriangle() {
		return theTriangle;
	}

	public Rectangle getMainRec() {
		return mainRec;
	}

	public Rectangle getConnectRec() {
		return connectRec;
	}

}
