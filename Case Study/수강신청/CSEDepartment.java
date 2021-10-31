import java.util.ArrayList;

public class CSEDepartment{
	private ArrayList<Student> stuList = new ArrayList<>();
	private ArrayList<Course> couList = new ArrayList<>();
	
	public Staff addStaffID(String staffID, String staffPW) {
		Staff st = new Staff(staffID, staffPW);
		return st;
	}
	
	public void addStudent(Student s) {
		stuList.add(s);
	}
	public void addCourse(Course c) {
		couList.add(c);
	}
	public ArrayList<Student> getStuInfo(){
		return stuList;
	}
	public ArrayList<Course> getCourse(){
		return couList;
	}
	
	public void showStudent() {
		for(int i = 0; i<stuList.size(); i++) {
			System.out.println("Name : " + stuList.get(i).getName() + " | " + "School Number : " + stuList.get(i).getNum());
		}
		System.out.println();
	}
	public void showCourse() {
		for(int i = 0; i<couList.size(); i++) {
			System.out.println("Name : " + couList.get(i).getCoursename() + " | " + "Course Code : " + couList.get(i).getCoursecode());
			couList.get(i).showStudent();
		}
		System.out.println();
	}
}
