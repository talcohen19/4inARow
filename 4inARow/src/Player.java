import javafx.scene.paint.Color;

public class Player {

	private String name;
	private Color theColor;

	public Player(String name, Color theColor) {
		this.name = name;
		this.theColor = theColor;
	}

	public String getName() {
		return name;
	}

	public Color getTheColor() {
		return theColor;
	}

}
