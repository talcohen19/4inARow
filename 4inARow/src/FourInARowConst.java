
public interface FourInARowConst {

	final int TIE = 0, WIN = 1, IN_PROGRESS = -1, NUM_OF_PLAYERS = 2, RADIUS = 20, PADDING = 10, PADDING_TOKENS = 40,
			TRANSPERENT = 0,
			SCENE_SIZE = 300, SPACEING = 60, SPACEING_TOKEN_COLOR_BOX = 125, PADDING_COLOR_BOX = (int) (SPACEING * 1.5),
			PADDING_ZERO = 0, PADDING_BOTTON_LEFT = 120, PADDING_BOTTON_UP = 0, PADDING_BOTTON_RIGHT = 50,
			PADDING_BOTTON_DOWN = PADDING_BOTTON_RIGHT / PADDING, NUMOFROWS_AND_COLS = 7, NUM_OF_WIN_TOKENS = 4,
			PAINT = TRANSPERENT + 1, PAUSE_SCENE_SIZE = 150;

	final String SAMECOLOR_ERR = "cant start game with 2 tokens at the same color", TITLE_BOARD = "The Game Board",
			STYLE = "-fx-prompt-text-fill: transparent;", TITLE = "4 In Row", START_PLAY_TEXT = "Start Play",
			TITLE_PAUSE = "pause";
	final String ARROWIMAGE="Arrow.png",LOGOIMAGE="title.png";

}
