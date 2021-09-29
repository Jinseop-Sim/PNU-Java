import java.util.Scanner;
public class CountAndSum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.next();
		
		int count = 0;
		int sum = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'O') {
				count += 1;
				sum += count;
			}
			else count = 0;
		}
		System.out.println(sum);
	}
}
