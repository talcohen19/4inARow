import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class Cell extends Label {
	private Token token;
	private boolean available;
	private int rowNum;
	private int colNum;

	public Cell(int rowNum,int colNum) {
		this.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, null, null)));
		available=true;
		this.rowNum=rowNum;
		this.colNum=colNum;
	}
	public void setToken(Token token){
		if(available){
		this.token=token;
		this.available=false;
		}
	}
	public Token getToken(){
		return this.token;
	}
	public int getRowNum() {
		return rowNum;
	}
	public int getColNum() {
		return colNum;
	}
}

