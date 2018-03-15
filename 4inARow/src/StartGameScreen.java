import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class StartGameScreen extends Application implements FourInARowConst {

	private Player thePlayers[];

	private mainPanel theMainPanel;
	private Label msgLabel;
	private Circle playerCircles[];
	private TextField playerNames[];
	private ColorPicker colorTokens[];
	private Button bootGameBtn = new Button(START_PLAY_TEXT);

	private StackPane titlePane;
	private StackPane startGameButtonPane;
	private StackPane namesAndTokensPanel;

	private BorderPane general = new BorderPane();

	private HBox tokensColorsBox;
	private HBox colorsPickerBox;
	private HBox namesOfPlayersBox;
	private VBox startGameBox;
	private VBox namesAndTokens;

	public static void main(String[] args) {
		launch(args);
	}

	public void initzailseDetails() {
		this.thePlayers = new Player[NUM_OF_PLAYERS];
		this.playerCircles = new Circle[NUM_OF_PLAYERS];
		this.playerNames = new TextField[NUM_OF_PLAYERS];
		this.colorTokens = new ColorPicker[NUM_OF_PLAYERS];
		for (int i = 0; i < NUM_OF_PLAYERS; i++) {
			playerCircles[i] = new Circle(RADIUS, Color.BLACK);
			colorTokens[i] = new ColorPicker(new Color(Math.random(), Math.random(), Math.random(), PAINT));
			playerCircles[i].fillProperty().bind(colorTokens[i].valueProperty());
			playerNames[i] = new TextField();
		}
	}

	public void initzailsePlayerDetails() {
		for (int i = 0; i < NUM_OF_PLAYERS; i++) {
			thePlayers[i] = new Player(playerNames[i].getText().toString(), colorTokens[i].getValue());
		}

	}

	public boolean sameColorChoosen() {
		for (int i = 0; i < NUM_OF_PLAYERS; i++) {
			for (int j = 0; j < NUM_OF_PLAYERS; j++) {
				if (i != j)
					if (colorTokens[i].getValue().equals(colorTokens[j].getValue()))
						return true;
			}
		}
		return false;
	}

	public void showErrMsgLabel(String errMsg) {
		this.msgLabel.setOpacity(1);
		this.msgLabel.setText(errMsg);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		initzailseDetails();
		// top
		ImageView logoImage = new ImageView(new Image(LOGOIMAGE));
		titlePane = new StackPane(logoImage);
		// center
		tokensColorsBox = new HBox(SPACEING_TOKEN_COLOR_BOX);
		colorsPickerBox = new HBox(SPACEING);
		namesOfPlayersBox = new HBox(SPACEING);

		for (int i = 0; i < NUM_OF_PLAYERS; i++) {
			tokensColorsBox.getChildren().add(playerCircles[i]);
			namesOfPlayersBox.getChildren().add(playerNames[i]);
			colorsPickerBox.getChildren().add(colorTokens[i]);
		}
		Insets mainPanelsInsets = new Insets(SPACEING);
		namesOfPlayersBox.setPadding(mainPanelsInsets);
		colorsPickerBox.setPadding(mainPanelsInsets);
		tokensColorsBox.setPadding(new Insets(PADDING_COLOR_BOX));

		tokensColorsBox.setPadding(new Insets(PADDING, PADDING, PADDING_ZERO, PADDING_TOKENS));
		colorsPickerBox.setPadding(new Insets(PADDING, PADDING, PADDING_ZERO, PADDING));
		namesOfPlayersBox.setPadding(new Insets(PADDING, PADDING, PADDING_ZERO, PADDING));

		namesOfPlayersBox.setStyle(STYLE);

		namesAndTokens = new VBox(PADDING, tokensColorsBox, colorsPickerBox, namesOfPlayersBox);
		namesAndTokens.setPadding(new Insets(PADDING));
		namesAndTokensPanel = new StackPane(namesAndTokens);

		// down
		bootGameBtn.setOnAction(e -> {

			// checks
			if (sameColorChoosen())
				showErrMsgLabel(SAMECOLOR_ERR);

			// init game
			initzailsePlayerDetails();
			Stage boardStage = new Stage();
			theMainPanel = new mainPanel(thePlayers);
			Scene boardScene = new Scene(theMainPanel, SCENE_SIZE, SCENE_SIZE);
			boardStage.setScene(boardScene);
			boardStage.setTitle(TITLE_BOARD);
			boardStage.setResizable(false);
			boardStage.setAlwaysOnTop(true);
			boardStage.centerOnScreen();
			boardStage.show();

		});

		msgLabel = new Label();
		msgLabel.setOpacity(TRANSPERENT);
		startGameBox = new VBox(PADDING);
		startGameBox.setPadding(
				new Insets(PADDING_BOTTON_UP, PADDING_BOTTON_RIGHT, PADDING_BOTTON_DOWN, PADDING_BOTTON_LEFT));
		startGameBox.getChildren().add(msgLabel);
		startGameBox.getChildren().add(bootGameBtn);
		startGameButtonPane = new StackPane(startGameBox);

		// general
		general.setTop(titlePane);
		general.setCenter(namesAndTokensPanel);
		general.setBottom(startGameButtonPane);
		Scene scene = new Scene(general, SCENE_SIZE, SCENE_SIZE);
		primaryStage.setScene(scene);
		primaryStage.setTitle(TITLE);
		primaryStage.setResizable(false);
		primaryStage.setAlwaysOnTop(true);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

}
