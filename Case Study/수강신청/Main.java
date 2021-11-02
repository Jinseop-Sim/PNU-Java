import java.util.Scanner;
import java.util.ArrayList; // Import ArrayList Class to use ArrayList
import java.io.Console; // Import Console Class to use readPassword() method.

public class ObjectThinking { // It's main class of Course Management
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Console cnsl = System.console(); // Make Console object to use readPassword()
		int act_num = 0, pw_idx = 0; // act_num provide choice of act.
									 // and pw_idx store which student is log in now.
		String name, course_code;
		String id, pwd; // use id and pwd variable to control log in method.
		char[] pw; // readPassword() method must implement with char[]
		boolean flag = true, is_id = false, is_take = false;
		// flag control shutdown, when flag is false, system will shutdown.
		// is_id control existence of id. when is_id is false, there's no ID.
		// is_take control existence of course. when is_take is true, you already take that course.
		
		Staff csestaff = new Staff();
		CSEDepartment SquidCSE = new CSEDepartment();
		csestaff = SquidCSE.addStaffID("CSEStaff", "Squid"); // Staff ID and PW are fixed with them.
		Student st1 = csestaff.addStudent("Sim Jinseop", "aoao1234", "onetouch"); // I made students in compile time
		Student st2 = csestaff.addStudent("Lee Junhee", "bobo1234", "twotouch");  // Because if I didn't make them
		Student st3 = csestaff.addStudent("Jin Minji", "coco1234", "threetouch"); // in compile time, I should add them
		Student st4 = csestaff.addStudent("Kim Donguk", "dodo1234", "fourtouch"); // whenever I run this program.
		Student st5 = csestaff.addStudent("Lee Kyungtae", "eoeo1234", "fivetouch"); // It's very pointless labor.
		Student st6 = csestaff.addStudent("Jung Hyunchul", "fofo1234", "sixtouch");
		Student st7 = csestaff.addStudent("Kim Minseo", "gogo1234", "seventouch");
		Course c1 = csestaff.setCourse("Platform Based Programming", "PB6408"); // Set course is made in compile time too.
		Course c2 = csestaff.setCourse("Data Structure", "DS6409");             // Reason is same with above.
		Course c3 = csestaff.setCourse("Discrete Mathematics", "DM6515");
		
		st1.takeCourse(c1); // Take some course in compile time.
		st2.takeCourse(c1); // Because each course must have at least 2 students.
		st3.takeCourse(c2);
		st4.takeCourse(c2);
		st5.takeCourse(c3);
		st6.takeCourse(c3);
		st7.takeCourse(c1);
		
		System.out.println("Welcome to the CSE Department!!"); // Log in display.
		System.out.print("Login : (CSEStaff or Student ID) ");
		id = input.nextLine();
		while(true) {
			if(flag == false) break; // If flag is false, shutdown program.
			while(!is_id) {
				for(int i = 0; i < csestaff.getStuInfo().size(); i++) {
					if(id.equals(csestaff.getStuInfo().get(i).getID())) {
						// This reference (csestaff => Student List => Specific Student => his ID.)
						is_id = true; // If is_id is true, There is ID.
						pw_idx = i; // and pw_idx store who is owner of this ID.
						break;  // If there is same with input, BREAK!
					}
				}
				if(id.equals(csestaff.getStaffID())) break; // If id is "CSEStaff" Jump to line 61
				if (is_id == false) {
					System.out.println("There's no ID"); // If is_id is false, there isn't ID same with input
					System.out.print("Login : (CSEStaff or Student ID) ");
					id = input.next();
				}
			}
			if(id.equals(csestaff.getStaffID())) { // If Id is same with "CSEStaff", log in with Staff.
				System.out.print("Password : ");
				pw = cnsl.readPassword(); // Use readPassword() method to hide typing password.
				pwd = new String(pw);
				while(!(pwd.equals(csestaff.getStaffPW()))) { // If password is different with input, repeat.
					System.out.println("Wrong Password.");
					System.out.print("Password : ");
					pw = cnsl.readPassword(); // Use readPassword() method to hide typing password.
					pwd = new String(pw);
				}
				while(true) {
					if(flag == false) break; // breakpoint to shutdown program
					System.out.println("Welcome Admin Staff!"); // Prompt when log in with Staff.
					System.out.println("1. Show Courses");
					System.out.println("2. Show Students");
					System.out.println("3. Exit");
					act_num = input.nextInt();
					switch(act_num) {
					case 1:
						csestaff.showCourse(); // When input is 1, Show all of courses with taking student.
						break;
					case 2:
						csestaff.showStudent(); // When input is 2, Show all of students with information.
						break;
					case 3:
						System.out.println("Shutdown System."); // When input is 3, Shutdown.
						flag = false;
						break;
					}
				}
				if(flag == false) break; // breakpoint to shutdown program
			}
			else {
				System.out.print("Password : ");
				pw = cnsl.readPassword(); // Use readPassword() method to hide typing password.
				pwd = new String(pw);
				while(!pwd.equals(csestaff.getStuInfo().get(pw_idx).getPW())) {
					// This reference (csestaff => Student List => Specific Student => his PW.)
					System.out.println("Wrong Password.");
					System.out.print("Password : ");
					pw = cnsl.readPassword();
					pwd = new String(pw);
				}
				while(true) {
					if(flag == false) break; // breakpoint to shutdown program
					System.out.println("\n1. Show Information");
					System.out.println("2. Take course");
					System.out.println("3. Drop course");
					System.out.println("4. Exit");
					act_num = input.nextInt();
					switch(act_num) {
					case 1: // When input is 1, show his(her) information.
						System.out.print("Hello! " + csestaff.getStuInfo().get(pw_idx).getName() + "!\n");
						csestaff.getStuInfo().get(pw_idx).showInfo();
						// This reference (csestaff => Student List => Specific Student => show his information)
						break;
					case 2: // When input is 2, he(she) can take course which he(she) wants.
						System.out.print("What Course You Wanna Take? (Please type specific code.)");
						course_code = input.next();
						for(int i = 0; i<csestaff.getStuInfo().get(pw_idx).getCouList().size(); i++) {
							// This reference (csestaff => Student List => Specific Student => How many course he(she) taken.)
							if(csestaff.getStuInfo().get(pw_idx).getCouList().get(i).getCoursecode().equals(course_code)) {
								// This reference (csestaff => Student List => Specific Student => Course List => Compare Specific Course Code)
								System.out.println("You already took that.");
								is_take = true; // If is_take is true, he(she) alredy take it.
								break;
							}
						}
						if(is_take) {is_take = false; break;} // If he(she) already take it, back to choice prompt.
						for(int j = 0; j<csestaff.getCourse().size(); j++) {
							if(csestaff.getCourse().get(j).getCoursecode().equals(course_code)) {
								csestaff.getStuInfo().get(pw_idx).takeCourse(csestaff.getCourse().get(j));
								// This reference (csestaff => Student List => Specific Student => take course(specific course object))
							}
						}
						System.out.println("Successfully signed up.");
						break;
					case 3: // When input is 2, he(she) can drop course which he(she) wants. 
						System.out.print("What Course You Wanna Drop? (Please type specific code.)");
						course_code = input.next();
						for(int i = 0; i<csestaff.getStuInfo().get(pw_idx).getCouList().size(); i++) {
							if(csestaff.getStuInfo().get(pw_idx).getCouList().get(i).getCoursecode().equals(course_code)) {
								is_take = true; // If is_take is false, he(she) didn't take it so cannot drop.
								break;
							}
						}
						if(!(is_take)) {
							System.out.println("You didn't take it yet."); 
							break;
						}
						for(int i = 0; i<csestaff.getCourse().size(); i++) {
							if(csestaff.getCourse().get(i).getCoursecode().equals(course_code)) {
								csestaff.getStuInfo().get(pw_idx).dropCourse(csestaff.getCourse().get(i));
								// This reference (csestaff => Student List => Specific Student => drop course(specific course object))
							}
						}
						System.out.println("Successfully dropped.");
						is_take = false; // is_take is fundamentally "False" to check is lecture in list.
						break;
					case 4:
						System.out.println("Shutdown System.");
						flag = false;
						break;
					}
				}
		}
	 }
  }
}
