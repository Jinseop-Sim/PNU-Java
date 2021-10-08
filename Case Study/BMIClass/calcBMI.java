public class BMI {
	private String name;
	private int age;
	private double weight = 0;
	private double height = 0;
	
	public BMI(String name, int age, double weight, double height) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}
	public double getBMI() {
		double bmi = weight / ((height / 100.0) * (height / 100.0));
		return  Math.round(bmi * 100) / 100.0;
	}
	public String getStatus() {
		double bmi = getBMI();
		if (bmi < 18.5) return "Underweight!";
		else if (bmi < 25) return "Normal.";
		else if (bmi < 30) return "Overweight!!!!";
		else return "... Obese";
	}
	public String getName() {
		return name;
	}
}
