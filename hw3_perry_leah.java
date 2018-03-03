/*PROGRAM: Assignment 3 
 * AUTHOR: Leah Perry
 * Due Date: September 17, 2015
 * SUMMARY: Calculates costs for an Internet Service provider
 */

import java.util.Scanner; //allows use of Scanner

public class hw3_perry_leah {
	public static void main(String[]args) {
		Scanner keyboard = new Scanner(System.in); 
		
		char packageLetter;
		double hours;
		double aCost = 9.95; //temp cost for less than 10 hours
		double bCost = 13.95; //temp cost for less than 20 hours
		final double cCost = 19.95;//final bc hours doesn't affect the cost
		
		System.out.println("Please enter your package letter (A, B, or C): "); //letter prompt
		packageLetter = keyboard.next().charAt(0); //scans in package letter
		
		while (packageLetter != 'A' && packageLetter != 'a'&& packageLetter !='B' &&
				packageLetter != 'b' && packageLetter !='C' && packageLetter !='c') {
			System.out.println("I'm sorry, that isn't a correct package letter " +
				"please enter A, B, or C: "); //letter prompt repeat
			packageLetter = keyboard.next().charAt(0); //scans in package letter AGAIN
		}//end while not a letter
		
		
		System.out.println("Please enter the number of hours used: "); //print hours prompt
		hours = keyboard.nextDouble(); //scans in hours
		
		while (hours < 0) {
			System.out.println("There's no such thing as negative hours. try again: "); //rehours
			hours = keyboard.nextDouble();//scans in hours again
		}//end while not an hour
		

		if (hours > 10) {//if hours is above 10, aCost changes
		aCost = 2.00 * (hours - 10) + 9.95;//calculates cost for package a
		
			if (hours > 20){//inside bc hours can't be > 20 unless they're > 10
				bCost = 1 * (hours - 20) + 13.95;//calculates cost for package b
			}//if hours is above 20, bCost changes
		}//end calculation ifs

		
		if (packageLetter == 'A' || packageLetter == 'a'){
			System.out.printf("Your monthly cost is $%.2f", aCost);
			if (aCost > bCost){
				System.out.printf("\nIf you buy package B, you could save $%.2f",(aCost - bCost));
			}//end B savings if
			if (aCost > cCost){
				System.out.printf("\nIf you buy package C, you could save $%.2f",(aCost - cCost)); 
			}//end C savings if
		}//end A package if
		
		else if (packageLetter == 'B' || packageLetter == 'b'){
			System.out.printf("Your monthly cost is $%.2f", bCost);
			if (bCost > cCost){
				System.out.printf("\nIf you buy package C, you could save $%.2f",(bCost - cCost)); 
			}//end C savings if
		}//end B package if
		
		else {
			System.out.printf("Your monthly cost is $%.2f", cCost);
		}//end C package if
		
		
		keyboard.close(); //closes keyboard Scanner object to prevent memory leaks
	}	
}