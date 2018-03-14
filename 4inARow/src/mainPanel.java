

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class mainPanel extends BorderPane implements FourInARowConst {

	private Board theBoard;
	private Arrow theArrow = new Arrow();
	private Player thePlayers[] = new Player[NUM_OF_PLAYERS];
	private ArrowT arrow=new ArrowT(100, 0, 100, 70,20);
	private ArrowT2 arrow2=new ArrowT2();
	private StackPane gameCanvas;
	private ClickPanel clicksPanel = new ClickPanel();

	public mainPanel(Player[] thePlayers) {

		for (int i = 0; i < NUM_OF_PLAYERS; i++) {
			this.thePlayers[i] = thePlayers[i];
		}

		this.theBoard = new Board(this.thePlayers);

		gameCanvas = new StackPane(this.theBoard);

		this.setCenter(gameCanvas);
		this.setBottom(clicksPanel);
		this.setTop(arrow);



		
	}

	class ClickPanel extends HBox {

		private Text playerTurn = new Text();
		private Button restartButton = new Button("restart");
		private Button playButton = new Button("play");
		private Button pauseButton = new Button("pause");

		public ClickPanel() {

			setPadding(new Insets(PADDING));
			getChildren().add(playerTurn);
			getChildren().add(playButton);
			getChildren().add(pauseButton);
			getChildren().add(restartButton);

			playButton.setOnAction(e -> {
				// what enter do
			});

			pauseButton.setOnAction(e -> {
				Stage pauseStage = new Stage();
				Label pauseLabel = new Label(TITLE_PAUSE);
				Scene pauseScene = new Scene(pauseLabel, PAUSE_SCENE_SIZE, PAUSE_SCENE_SIZE);
				pauseStage.setScene(pauseScene);
				pauseStage.setTitle(TITLE_PAUSE);
				pauseStage.setResizable(false);
				pauseStage.setAlwaysOnTop(true);
				pauseStage.centerOnScreen();
				pauseStage.show();
			});

			restartButton.setOnAction(e -> {
				StartGameScreen newStartGameScreen = new StartGameScreen();
			});

		}

	}
}
