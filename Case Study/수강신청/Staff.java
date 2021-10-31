public class Staff extends CSEDepartment{
	private String staffName;
	private String staffID;
	private String staffPW;
	private int staffNum;
	
	public Staff() {};
	public Staff(String staffID, String staffPW) {
		this.staffID = staffID;
		this.staffPW = staffPW;
		staffName = "Frontman";
		staffNum = 67871565;
	}
	
	public Student addStudent(String name, String stuID, String PW) {
		Student s = new Student(name, stuID, PW);
		super.addStudent(s);
		return s;
	}
	
	public Course setCourse(String title, String code) {
		Course c = new Course(title, code);
		super.addCourse(c);
		return c;
	}
	
	public String getStaffID() {
		return staffID;
	}
	public String getStaffPW() {
		return staffPW;
	}
}
