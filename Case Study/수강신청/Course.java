import java.util.ArrayList;

public class Course{
	private String title;
	private String courseCode;
	private ArrayList<Student> studentList = new ArrayList<>();
	
	public Course(String title, String courseCode) {
		this.title = title;
		this.courseCode = courseCode;
	}
	public int getNumberOfStudents() {
		return studentList.size();
	}
	public String getCoursename() {
		return title;
	}
	public String getCoursecode() {
		return courseCode;
	}
	public void addStudent(Student s) {
		studentList.add(s);
	}
	public void showStudent() {
		if (studentList.size() == 0) System.out.print("No Student T T...\n");
		else {
			System.out.print("Students : ");
			for(int i = 0; i<studentList.size(); i++) {
				System.out.print(studentList.get(i).getName() + "(" + 
												studentList.get(i).getNum()+ ")" + " ");
			}
		}
		System.out.println();
  }
}
