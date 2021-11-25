import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane{
	private int hour;
	private int minute;
	private int second;
	
	private double w = 250, h = 250;
	
	public ClockPane() {
		setCurrentTime();
	}
	
	public ClockPane(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	public int getHour() {
		return hour;
	}
	public int getSecond() {
		return second;
	}
	public int getMinute() {
		return minute;
	}
	public void setCurrentTime() { // 아래에 표시할 현재 시간을 받아와 줄 함수이다.
		Calendar calendar = new GregorianCalendar(); 
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		
		paintClock(); // 여기부터 시계를 그리는 함수이다.
	}
	protected void paintClock() {
		double clockRadius = Math.min(w, h) * 0.8 * 0.5;
		double centerX = w/2;
		double centerY = h/2;
		
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12"); // 시계에 12, 3, 9 ,6 만 표시하기 위한 Text Class.
		Text t2 = new Text(centerX  - clockRadius + 3, centerY + 5, "9");
		Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
		Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
		
		double sLength = clockRadius * 0.8; // 초침의 길이
		double secondX = centerX + sLength * Math.sin(second * (2*Math.PI/60)); // 원을 기준으로 시간에 따른 초침의 위치.
		double secondY = centerY - sLength * Math.cos(second * (2*Math.PI/60));
		Line sLine = new Line(centerX, centerY, secondX, secondY); // Line Class에서 선을 받아온다.
		sLine.setStroke(Color.RED); // Line의 테두리의 색.
		
		double mLength = clockRadius * 0.65; // 분침의 길이
		double minuteX = centerX + mLength * Math.sin(minute*(2*Math.PI/60));
		double minuteY = centerY - mLength * Math.cos(minute*(2*Math.PI/60));
		Line mLine = new Line(centerX, centerY, minuteX, minuteY);
		mLine.setStroke(Color.BLUE);
		
		double hLength = clockRadius * 0.5; // 시침의 길이
		double hourX = centerX + hLength * Math.sin((hour%12+minute/60.0)*(2*Math.PI/12));
		double hourY = centerY - mLength * Math.cos((hour%12+minute/60.0)*(2*Math.PI/12));
		Line hLine = new Line(centerX, centerY, hourX, hourY);
		hLine.setStroke(Color.GREEN);
		
		getChildren().clear(); // 이미 있던 요소가 있다면 싹 다 지운 뒤
		getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine); // Pane 안에 ()안의 요소들을 모두 추가하는 method.
	}
}
