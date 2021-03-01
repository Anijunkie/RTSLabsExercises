package RTSExercises;
import java.util.Scanner;

public class Exercise2 {
	//Failsafe implemented to address characters being input instead of integers
    public static boolean checkInteger(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception ex){
            return false;
        }
    }
    
	public static void main(String[] args) {
		
		//initialize scanner for input
		Scanner scan = new Scanner(System.in);
		
		/* If using the set string, MyString, uncomment the line below
		 * and comment out the following two lines
		 */
		//String inputString =  "MyString";
		
		
		/* prompt user for string and rotation input
		 * comment out the first two lines if using MyString
		 * as the set string
		 */
		System.out.println("Please enter the string to rotate: ");
		String inputString = scan.nextLine();
		System.out.println("Please enter the amount to rotate by: ");
		String rotateString = scan.nextLine();
		
		//check if input is a valid integer
		while (true){
			if (!checkInteger(rotateString)){
				System.out.println("Please enter a valid integer: ");
				rotateString = scan.nextLine();
			} else {
				break;
			}
		}
		
		//initialize and sets the amount the string will be rotated by
		//addresses sizes that are larger than the string size and negative rotations
		int rotation = 0;
		if (Integer.parseInt(rotateString) > inputString.length()){
			rotation = inputString.length() - (Integer.parseInt(rotateString)%inputString.length());
		} else if (Integer.parseInt(rotateString) < 0){
			if (Math.abs(Integer.parseInt(rotateString)) < inputString.length()){
				rotation = inputString.length() - ((inputString.length() + Integer.parseInt(rotateString))%inputString.length());
			} else {
				rotation = inputString.length() - (inputString.length() + (inputString.length() + Integer.parseInt(rotateString))%inputString.length());
			}
		} else {
			rotation = inputString.length() - Integer.parseInt(rotateString);
		}
		
		//output rotated string
		System.out.println("The inputted string rotated right by " + rotateString + " characters is: ");
		System.out.println(inputString.substring(rotation) + inputString.substring(0,rotation));
		
		scan.close();
	}
}
