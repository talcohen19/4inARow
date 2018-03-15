

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class mainPanel extends BorderPane implements FourInARowConst {
	ImageView arrow = new ImageView(new Image(ARROWIMAGE));
	private Board theBoard;
	private Player thePlayers[] = new Player[NUM_OF_PLAYERS];
	private StackPane gameCanvas;
	private ClickPanel clicksPanel = new ClickPanel();
	private StackPane arrowImage;
	
	public mainPanel(Player[] thePlayers) {

		for (int i = 0; i < NUM_OF_PLAYERS; i++) {
			this.thePlayers[i] = thePlayers[i];
		}

		this.theBoard = new Board(this.thePlayers);

		gameCanvas = new StackPane(this.theBoard);
		arrowImage = new StackPane(arrow);
		this.setCenter(gameCanvas);
		this.setBottom(clicksPanel);
		this.setTop(arrowImage);



		
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
