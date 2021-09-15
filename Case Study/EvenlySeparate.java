import java.util.Scanner;

public class EvenlySeparate {

	public static void main(String[] args) {
		while(true) {
			Scanner input = new Scanner(System.in);
			String str = input.next();
		
			int start = 0;
			int end = str.length() - 1;
			int count = 0;
		
			while(start < end) {
				if (str.charAt(start) != str.charAt(end)) {
					break;
				}
				count++;
				start++;
				end--;
			}
		
			if (count%2 == 0) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
/* abba나 aabaa 처럼 짝수 개의 대칭을 이루는 String을 받으면 YES
   abcycba 처럼 홀수 개의 대칭을 이루는 String을 받으면 NO를 출력하는 코드이다 
   Palindrome(회문)을 응용한 코드로, 앞과 뒤의 문자가 다를 경우 break를 하며 count를 같이 센다.
   Count가 짝수인지 홀수인지 판별하면 짝수 개의 대칭인지 아닌지를 알 수 있다.*/
