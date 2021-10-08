import java.util.Scanner;
public class StaticTest {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please type your name : ");
		String name = input.nextLine();
		System.out.print("Please type your age : ");
		int age = input.nextInt();
		System.out.print("Please type your weight : ");
		double weight = input.nextDouble();
		System.out.print("Please type your height : ");
		double height = input.nextDouble();
		BMI bmi1 = new BMI(name, age, weight, height);
		System.out.println("The BMI for " + bmi1.getName() + " is " + bmi1.getBMI() + " : " + bmi1.getStatus());
	}

}
