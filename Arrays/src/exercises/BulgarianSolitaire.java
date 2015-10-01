package exercises;

import java.util.Arrays;

public class BulgarianSolitaire {

	public static void main(String[] args) {
		
		int cards = 45;
		int start_amount_of_piles = (int) (Math.random() * 10) + 1;
		int[] piles = new int[start_amount_of_piles];
		
		for (int i = 0; i < start_amount_of_piles; i++){
			int tempcards = (int) (Math.random() * cards) + 1;
			cards = cards - tempcards;
			System.out.println(cards);
			piles[i] = tempcards;
		}
		System.out.println(start_amount_of_piles);
		System.out.println(Arrays.toString(piles));
	}

}
