import java.util.Scanner;
public class SwitchTest {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string : ");
		String str = input.nextLine();
		
		int low = 0;
		int high = str.length() - 1;
		boolean isPalindrome = true;
		
		while(low < high) {
			if(str.charAt(low) != str.charAt(high)) {
				isPalindrome = false;
				break;
			}
			low++;
			high--;
		}
		
		if(isPalindrome == true) System.out.println("IT'S PALINDROME!");
		else System.out.println("NOT PALINDROME");
	}
}
/* 간단한 loop 연습을 위한 Palindrome 코드이다.
   low와 high를 정해 앞 뒤를 동시에 검사하며 가운데에서 만난다.
   isPalindrome이라는 Flag를 이용하여 Check.*/
