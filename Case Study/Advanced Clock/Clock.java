import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class javafxtext extends Application{
	public void start(Stage primaryStage){
		ClockPane clock = new ClockPane();
		Label lblCurrentTime = new Label(clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond());
		lblCurrentTime.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		EventHandler<ActionEvent> eventHandler = e -> {
			clock.setCurrentTime();
			String newString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
			lblCurrentTime.setText(newString);
		};
		Text name = new Text("School ID : 201724500" + "\n" + "Name : Jinseop Sim");
		BorderPane pane = new BorderPane();
		pane.setCenter(clock);
		pane.setBottom(lblCurrentTime);
		pane.setTop(name);
		BorderPane.setAlignment(name, Pos.CENTER);
		BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
		BorderPane.setAlignment(clock, Pos.CENTER);
		
		Timeline anime = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
		anime.setCycleCount(Timeline.INDEFINITE);
		anime.play();
		
		Scene scene = new Scene(pane, 250, 275);
		primaryStage.setTitle("Clock");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
