public class PrimitiveTypeTest {
	public static void main(String args[]) {
		char[] chars = createArray();
		int[] counts = countLetters(chars);
		
		displayCount(counts);
	}
	
	public static char[] createArray() {
		char[] chars = new char[100];
		for (int i = 0; i<chars.length; i++) chars[i] = RandomCharacter.getRandomLowerCaseLetter();
		
		return chars;
	}
	
	public static void displayCount(int[] counts) {
		for(int i=0; i<counts.length; i++) {
			if((i+1)%10 == 0) System.out.println(counts[i] + " " + (char)(i+'a'));
			else System.out.print(counts[i] + " " + (char)(i + 'a') + " ");
		}
	}
	
	public static int[] countLetters(char[] chars) {
		int[] counts = new int[26];
		
		for(int i = 0; i < chars.length; i++) counts[chars[i] - 'a']++;
		return counts;
	}
}
