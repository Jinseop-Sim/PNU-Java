import java.util.Scanner;
public class SwitchTest {
	
	public static void main(String[] args) {
		int[] deck = new int[52];
		String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
		String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		
		for(int i = 0; i < deck.length; i++) {
			deck[i] = i;
		}
		
		for(int i = 0; i < deck.length; i++) {
			int index = (int)(Math.random() * deck.length);
			int temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}
		
		for(int i = 0; i < 4; i++) {
			String suit = suits[deck[i] / 13];
			String rank = ranks[deck[i] % 13];
			System.out.println("Card number " + deck[i] + " : " + rank + " of " + suit);
		}
	}
} 
/* 1부터 52까지의 수를 Deck 배열에 집어넣은 후, suits 배열과 ranks 배열에 각 카드의 명칭들을 저장한다.
   그 후 (int)Math.random() * deck.length 메서드를 이용하여 1부터 52 사이의 랜덤한 수를 index에 저장을 하고
   deck[index]의 값을 차례로 deck[i]와 바꾼다. 즉 카드를 셔플하는 동작이다.
   그 후 suit와 rank라는 String 변수에다가 첫 카드 4장의 정보를 저장을 한다.
   rank가 deck[i] % 13인 이유는 숫자가 총 13개로 이루어지기 때문이다.
   suit가 deck[i] / 13인 이유는 52/13 = 4 이고, 문양이 총 4개밖에 없기 때문이다.
   */
