import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Board extends Pane implements FourInARowConst {

	private final int NUMOFROWS_AND_COLS = 7;
	private final int NUM_OF_WIN_TOKENS = 4;
	private final int NUM_OF_TOKENS_TO_CHECK = 3;
	private final Color RED = Color.RED;
	private final Color GREEN = Color.GREEN;
	private int numOfPlayers = 2;
	private Player[] Players;
	private Cell[][] gameBoard = new Cell[NUMOFROWS_AND_COLS][NUMOFROWS_AND_COLS];
	private int[] cols_Cap = new int[NUMOFROWS_AND_COLS];// to update the place
															// on each col

	private SimpleIntegerProperty isWon = new SimpleIntegerProperty(IN_PROGRESS);

	private SimpleIntegerProperty playerTurn;
	private int lastColAdded, lastRowAdded;
	private Token nextToken;

	public Board(Player[] players) {
		setCellsOnBoard();
		this.Players = new Player[players.length];
		this.Players = players;
		playerTurn = new SimpleIntegerProperty((int) (Math.random() * 2));
		generalSettings();
	}


	public void generalSettings() {
		// sizes of panel ..
	}

	private void setGameStaus(int status) {
		this.isWon.set(status);

	}

	public SimpleIntegerProperty getGameStatus() {
		return this.isWon;
	}

	private void setCellsOnBoard() {
		for (int i = 0; i < gameBoard.length; i++)
			for (int j = 0; j < gameBoard[i].length; j++)
				this.getChildren().add(gameBoard[i][j] = new Cell(i, j));
	}

	public void isWon(Token token) {
		if (checkWinOnCol(lastColAdded, lastRowAdded, token))
			setGameStaus(WIN);
		else if (checkWinOnRow(lastRowAdded, lastColAdded, token))
			setGameStaus(WIN);
		else if (checkWinOnDiagonal(lastRowAdded, lastColAdded, token))
			;

	}

	private boolean checkSameColor(Token playerToken, Token tokenOnBoard) {
		if (playerToken.getColor().equals(tokenOnBoard.getColor()))
			return true;
		return false;
	}

	public boolean checkWinOnCol(int colNum, int rowNum, Token token) {
		int startCheck = rowNum + NUM_OF_WIN_TOKENS - 1;
		if (startCheck >= NUMOFROWS_AND_COLS)
			return false;
		if (cols_Cap[colNum] < NUM_OF_WIN_TOKENS)
			return false;
		for (int i = startCheck; i >= rowNum; i--)
			if (!(checkSameColor(token, gameBoard[i][colNum].getToken())))
				return false;
		return true;
	}

	public boolean checkWinOnRow(int rowNum, int startCheck, Token token) {
		if (checkWinOnRow_Right(rowNum, startCheck, token))
			return true;
		else if (checkWinOnRow_Left(rowNum, startCheck, token))
			return true;
		return false;
	}

	private boolean checkWinOnRow_Left(int rowNum, int startCheck, Token token) {

		if (startCheck < NUM_OF_TOKENS_TO_CHECK)
			return false;
		if (cols_Cap[startCheck - NUM_OF_WIN_TOKENS] >= cols_Cap[startCheck])
			for (int i = startCheck; i >= 0; i--)
				if (!(checkSameColor(token, gameBoard[rowNum][i].getToken())))
					return false;

		return true;
	}

	private boolean checkWinOnRow_Right(int rowNum, int startCheck, Token token) {
		if (startCheck + NUM_OF_TOKENS_TO_CHECK >= NUMOFROWS_AND_COLS)
			return false;
		if (cols_Cap[startCheck + NUM_OF_TOKENS_TO_CHECK] >= cols_Cap[startCheck])
			for (int i = startCheck; i <= (startCheck + NUM_OF_TOKENS_TO_CHECK); i++)
				if (!(checkSameColor(token, gameBoard[rowNum][i].getToken())))
					return false;

		return true;
	}

	public boolean checkWinOnDiagonal(int rowNum, int colNum, Token token) {
		if (!(checkWinOnDiagonal_DownLeft(rowNum, colNum, token)))
			return false;
		if (!(checkWinOnDiagonal_DownRight(rowNum, colNum, token)))
			return false;
		if (!(checkWinOnDiagonal_UpLeft(rowNum, colNum, token)))
			return false;
		if (!(checkWinOnDiagonal_UpRight(rowNum, colNum, token)))
			return false;
		return true;
	}

	public boolean checkWinOnDiagonal_UpLeft(int rowNum, int colNum, Token token) {
		if (rowNum < NUM_OF_TOKENS_TO_CHECK || colNum < NUM_OF_TOKENS_TO_CHECK)
			return false;
		for (int i = 1; i < NUM_OF_WIN_TOKENS; i++)
			if (!(checkSameColor(token, gameBoard[rowNum - i][colNum - i].getToken())))
				return false;

		return true;
	}

	public boolean checkWinOnDiagonal_DownLeft(int rowNum, int colNum, Token token) {
		if (rowNum > NUM_OF_TOKENS_TO_CHECK || colNum >= NUM_OF_TOKENS_TO_CHECK)
			return false;
		for (int i = 1; i < NUM_OF_WIN_TOKENS; i++)
			if (!(checkSameColor(token, gameBoard[rowNum + i][colNum - i].getToken())))
				return false;

		return true;
	}

	public boolean checkWinOnDiagonal_DownRight(int rowNum, int colNum, Token token) {
		if (rowNum > NUM_OF_TOKENS_TO_CHECK || colNum > NUM_OF_TOKENS_TO_CHECK)
			return false;

		for (int i = 1; i < NUM_OF_WIN_TOKENS; i++)
			if (!(checkSameColor(token, gameBoard[rowNum + i][colNum + i].getToken())))
				return false;
		return true;
	}

	public boolean checkWinOnDiagonal_UpRight(int rowNum, int colNum, Token token) {
		if (rowNum < NUM_OF_TOKENS_TO_CHECK || colNum > NUM_OF_TOKENS_TO_CHECK)
			return false;

		for (int i = 1; i < NUM_OF_WIN_TOKENS; i++)
			if (!(checkSameColor(token, gameBoard[rowNum - i][colNum + i].getToken())))
				return false;
		return true;
	}
}
class twoPlayersListner extends ActionEvent{
	
}
