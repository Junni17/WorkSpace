package exercises;

import java.util.Scanner;

public class P5_3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Line of input: ");
		String s1 = scanner.nextLine();
		String s2 = "Uppercase letters in the input: ";
		String s3 = "Every second letter of the input: ";
		String s4 = s1;
		String s5 = s4;
		int vowels = 0;
		String vowel_position = "There were vowels at the following positions (starting from 0): ";
		
		for (int i = 0; i < s4.length(); i++){
		
			char ch = s4.charAt(i);
			
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
				vowels += 1;
				vowel_position += Integer.toString(i) + " ";
				s5 = s5.replace(s5.charAt(i), '_');
				
			}	
		}
		
		System.out.println(vowel_position);
		System.out.println("The number of vowels in the input: " + vowels);
		System.out.println("Vowels replaced with an '_': " + s5);
		
		for (int i = 0; i < s1.length(); i = i+2){
			
			char ch = s1.charAt(i);
			
			s3 += ch;
			
		}
		
		System.out.println(s3);
		
		for (int i = 0; i < s1.length(); i++){
		
			char ch = s1.charAt(i);
			
			if (Character.isUpperCase(ch) == true){
				s2 += s1.charAt(i);
			}

		}
		
		System.out.println(s2);
		scanner.close();
		
		}
		
		

	}


