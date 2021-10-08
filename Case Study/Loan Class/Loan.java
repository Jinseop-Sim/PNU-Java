public class Loan {
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate; // Java의 Library 클래스 객체를 field에 선언했다.
	
	//Constructor
	public Loan() {
		this(2.5, 1, 1000); // 이 생성자의 특이한 점은, this()를 이용해서 자신의 생성자를 호출했다는 점이 매우 특이하다.
	}                     // 기본 값을 (2.5, 1, 1000)으로 두겠다는 의미. 물론 this.annualInterestRate = 2.5 이런 식으로 초기화도 가능하다.
	
	public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
		loanDate = new java.util.Date(); // Date class에 대한 methods를 사용하려면 private한 loanDate를 그대로 쓸 수는 없다. 따라서 객체를 생성해주어야 한다.
	}                                  // 이 code에서 현재 시간을 받아온다.
	//Setter
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	//Getter
	public double getMonthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
		return monthlyPayment;
	}
	public double getTotalPayment() {
		double totalPayment = getMonthlyPayment() * numberOfYears * 12; 
		return totalPayment;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public int getNumberOfYears() {
		return numberOfYears;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public java.util.Date getLoanDate(){
		return loanDate; // 위에서 생성한 현재 시간이 저장된 loanDate를 반환한다.
	}
}
