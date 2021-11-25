import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class Clock extends Application{
	public void start(Stage primaryStage){
		ClockPane clock = new ClockPane(); // Pane에 시계 모양을 그리기 위한 ClockPane Class는 따로 선언한다.
		String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond(); // 이는 현재 시간을 받아 시계 아래에 표시해줄 String.
		Label lblCurrentTime = new Label(timeString); // 현재 시간을 담는 Label 키워드이다.
		
		BorderPane pane = new BorderPane(); // 위, 아래, 오른쪽, 중앙에 Control을 배치하는 레이아웃이다.
		pane.setCenter(clock); // 중앙의 Control을 Clock으로
		pane.setBottom(lblCurrentTime); // 아래의 Control을 현재 시간으로.
		BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER); // 줄을 맞추도록 setAlignment로 정렬시킨다.
		
		Scene scene = new Scene(pane, 250, 250); // Scene에는 250, 250 크기의 Pane이 들어간다.
		primaryStage.setTitle("Clock");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
