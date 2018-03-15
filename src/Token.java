
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Token extends Circle {
public Token(Paint color){
	this.setFill(color);
	
}
public Paint getColor(){
	return this.getFill();
}

}
