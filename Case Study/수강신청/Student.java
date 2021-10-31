import java.util.ArrayList;

public class Student {
	private String stuID;
	private String stuPW;
	private int stuNum = 0;
	private static int stu_Num = 201724501;
	private String name;
	private ArrayList<Course> courseList = new ArrayList<>();
	
	public Student(String name, String stuID, String stuPW){
		this.stuID = stuID;
		this.stuPW = stuPW;
		this.name = name;
		this.stuNum = stu_Num;
		stu_Num++;
	}
	public String getName() {
		return name;
	}
	public String getID() {
		return stuID;
	}
	public String getPW() {
		return stuPW;
	}
	public int getNum() {
		return stuNum;
	}
	public ArrayList<Course> getCouList(){
		return courseList;
	}
	
	public void showInfo() {
		System.out.println("Student Number : " + stuNum);
		System.out.println("You Take");
		System.out.print("| ");
		for (int i = 0; i<courseList.size(); i++) {
			if (courseList.get(i) != null) System.out.print(courseList.get(i).getCoursename() + " | ");
		}
		System.out.println("\n");
	}
	public void takeCourse(Course c) {
		courseList.add(c);
		c.addStudent(this);
	}
	public void dropCourse(Course c) {
		for(int i=0; i<courseList.size(); i++) {
			if(courseList.get(i).equals(c)) courseList.remove(i);
		}
	}
}
