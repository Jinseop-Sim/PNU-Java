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
	public void setCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		
		paintClock();
	}
	protected void paintClock() {
		double clockRadius = Math.min(w, h) * 0.8 * 0.5;
		double centerX = w/2;
		double centerY = h/2;
		double x_for_line = centerX + clockRadius * Math.sin(1*(2*Math.PI/60));
		
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		Text t12 = new Text(centerX-3, centerY - clockRadius + 22, "12");	
		Text t9 = new Text(centerX  - clockRadius + 15, centerY + 3, "9");
		Text t3 = new Text(centerX + clockRadius - 20, centerY + 3, "3");
		Text t6 = new Text(centerX-3, centerY + clockRadius - 15, "6");
		
		double sLength = clockRadius * 0.8;
		double secondX = centerX + sLength * Math.sin(second * (2*Math.PI/60));
		double secondY = centerY - sLength * Math.cos(second * (2*Math.PI/60));
		Line sLine = new Line(centerX, centerY, secondX, secondY);
		sLine.setStroke(Color.RED);
		
		double mLength = clockRadius * 0.65;
		double minuteX = centerX + mLength * Math.sin(minute*(2*Math.PI/60));
		double minuteY = centerY - mLength * Math.cos(minute*(2*Math.PI/60));
		Line mLine = new Line(centerX, centerY, minuteX, minuteY);
		mLine.setStroke(Color.BLUE);
		
		double hLength = clockRadius * 0.5;
		double hourX = centerX + hLength * Math.sin((hour%12+minute/60.0)*(2*Math.PI/12));
		double hourY = centerY - mLength * Math.cos((hour%12+minute/60.0)*(2*Math.PI/12));
		Line hLine = new Line(centerX, centerY, hourX, hourY);
		hLine.setStroke(Color.GREEN);
		
		getChildren().clear();
		getChildren().addAll(circle, t3, t6, t9, t12, sLine, mLine, hLine);
		
		for (double i = 0; i < 60; i++) {
			double line_length;
			if (i % 5 == 0) line_length = 0.9;
			else line_length = 0.95;
			double xOuter = centerX + clockRadius * Math.sin(i * (2 * Math.PI / 60));
			double yOuter = centerY - clockRadius * Math.cos(i * (2 * Math.PI / 60));
			double xInner = centerX + line_length * clockRadius * Math.sin(i * (2 * Math.PI / 60));
			double yInner = centerY - line_length * clockRadius * Math.cos(i * (2 * Math.PI / 60));
			getChildren().add(new Line(xOuter, yOuter, xInner, yInner));
		}
		
		for (int i = 0; i < 12; i++) {
			if(i == 0 || i == 3 || i == 6 || i == 9) continue;
			double x = centerX + 0.8 * clockRadius * Math.sin(i * (2 * Math.PI / 12));
			double y = centerY - 0.8 * clockRadius * Math.cos(i * (2 * Math.PI / 12));
			Text text = new Text(x - 4, y + 4, ""+i);
			getChildren().add(text);
		}
	}
}
