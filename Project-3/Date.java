/*Angelo Salac, Arianne Arcebal 
 *Project 3, part 1
 *  
 * Ray Ahmadnia
 * Due: 9/15/2016
 * 
 * Purpose: A program to convert the date format from mm/dd/yyyy to Month day, year.
 */

import java.util.Scanner;

public class Date {
	public static void main(String [] args) {
		String date, month;
		char repeat, c;
		Scanner read = new Scanner(System.in);
		
		
		do {
			int slashCounter = 0;
			System.out.print("Enter the current date(mm/dd/yyyy): ");
			date = read.next();
			
			System.out.print("Today is ");
			for (int i = 0; i < date.length(); i++){
				c = date.charAt(i);

				//check for slashes
				if (c == '/'){
					slashCounter++;
					continue;
				}

				//MONTH
				//if double digit month
				if (i == 0 && Character.isDigit(date.charAt(i + 1))){
					month = lastThreeMonths(date.charAt(i + 1));
					System.out.print(month + " ");
				}
				//else single digit month
				else if (i == 0){
					month = month(c);
					System.out.print(month + " ");
				}

				//DATE
				//special 11th, 12th, 13th case
				if (slashCounter == 1 && c == '1' && Character.isDigit(date.charAt(i + 1))){
					System.out.printf("%c%cth, ", c, date.charAt(i + 1));
					i++;
				}
				//double digit
				else if (slashCounter == 1 && Character.isDigit(date.charAt(i + 1))){
					System.out.printf("%c%c%s, ", c, date.charAt(i + 1), ordinalIndicator(date.charAt(i + 1)));
					i++;
				}
				//single digit
				else if (slashCounter == 1)
					System.out.print(date.charAt(i) + ordinalIndicator(c) + ", ");


				//YEAR
				if (slashCounter == 2)
					System.out.print(date.charAt(i));
			}
			
			System.out.println();
			//ask user to continue
			System.out.print("Continue(y/n)? ");
			repeat = read.next().charAt(0);
		} while (repeat == 'y'); //repeat if user yes 'y'
		
		read.close();
	}
	
	public static String month(char c) {
		switch(c){
			//if single digit number, return month 1 - 9 jan - sept
			case '1': return "January";
			case '2': return "February";
			case '3': return "March";
			case '4': return "April";
			case '5': return "May";
			case '6': return "June";
			case '7': return "July";
			case '8': return "August";
			case '9': return "September";
			default: return "nothing";
		}
	}
	
	public static String lastThreeMonths(char s) {
		switch(s){
			//double digit number from oct - dec
			case '0': return "October";
			case '1': return "November";
			case '2': return "December";
			default: return null;
		}
	}
	
	public static String ordinalIndicator(char o){
		switch(o){
			//add ending st, md, rd, th
			case '1': return "st";
			case '2': return "nd";
			case '3': return "rd";
			default: return "th";
		}
	}
}

/*output:
Enter the current date(mm/dd/yyyy): 9/8/2016
Today is September 8th, 2016
Continue(y/n)? y
Enter the current date(mm/dd/yyyy): 7/2/2016
Today is July 2nd, 2016
Continue(y/n)? y
Enter the current date(mm/dd/yyyy): 4/11/1994
Today is April 11th, 1994
Continue(y/n)? n
*/
