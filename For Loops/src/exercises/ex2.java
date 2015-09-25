package exercises;

public class ex2 {
	
//ex2
//	To solve the following exercises, add some code to a main() method
//	1. Make a for loop that prints all uneven numbers in [1;100].
//	2. Make a for loop that prints all multiples of 3 from 300 down to 3.

	
	//1.
	
//	public static void main(String[] args) {
//		
//		for (int i = 1; i <= 100; i++){
//			if(i % 2 != 0){
//				System.out.println(i);
//			}
//		}
//		
//	}
	
	//2.
	
	public static void main(String[] args){
		for (int i = 300; i >= 3; i--){
			if (i % 3 == 0){
				System.out.println(i);
			}
		}
	}
	


}
