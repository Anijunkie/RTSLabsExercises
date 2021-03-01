package RTSExercises;
import java.util.Scanner;

public class Exercise1 {
	
	//Failsafe implemented to address characters being input instead of integers
    public static boolean checkInteger(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception ex){
            return false;
        }
    }
    
    public static void main(String []args){
        //initializing array and scanner for user input here
        int[] arr = {1, 5, 2, 1, 10};
        Scanner scan = new Scanner(System.in);
        
        //prompt to ask for user input
        System.out.println("Please enter an integer. Entering E or e will exit the program: ");
        String input = scan.nextLine();
        
        //added feature to give flexibility and control to user
        while (true) {
            
            //boolean check for correct input
            boolean isInt = checkInteger(input);
            
            if (!isInt){
                //test for exit character if ending program
                if ((input.equals("e")) || (input.equals("E"))){
                    break;
                }
                
                //otherwise rescan for next input
                System.out.println("Not a valid integer. Press E to exit, else enter the next number");
                input = scan.nextLine();
            } else {
                
                //parsing integer from input in case it is an integer
                int value = Integer.parseInt(input);
                
                //initialize counts for less than, greater than, or equals
                int less = 0;
                int more = 0;
                int equal = 0;
                
                //internal for loop for comparison
                for(int i=0; i < arr.length; i++) {
                    if (arr[i] < value) {
                        more++;
                    } else if (arr[i] == value) {
                        equal++;
                    } else {
                        less++;
                    }
                }
                
                //output as specified. included an equals result as well in case of equal values
                System.out.println("Results are above: " + more + ", equal: " + equal + ", below: " + less);
                
                //prompt for next number or exit code
                System.out.println("Enter a new number. Entering E or e will quit: ");
                input = scan.nextLine();
            }
        }
        scan.close();
     }
}
