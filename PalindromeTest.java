import java.util.Scanner;

public class PalindromeTest   {
	
    public static void main(String[] args){
      
    	Scanner reader = new Scanner(System.in);	// user input
    	System.out.println("Enter string to check if palindrome : ");
    	String str = reader.nextLine(); 
    	reader.close();
    	
    	str = str.toUpperCase();					// changing input string to upper-case
    	str = str.replaceAll("\\P{Alnum}", "");		// ignoring non-alphanumeric characters
    	checkIfPalindrome(str);
    	
    }
    
    public static void checkIfPalindrome(String str)
    {
        ArrayStack stack = new ArrayStack();
        ArrayQueue queue = new ArrayQueue();
        String string = new String();
        
        for (int i=0; i<str.length(); i++) {
            string = "" + str.charAt(i);
           
            queue.enqueue(string);
            stack.push(string);
        }
       
        boolean palindrome = true;
        
        while (!queue.isEmpty()) {
            if (queue.dequeue().equals(stack.pop())) {
                continue;
            } 
            else {
                palindrome = false;
                break;
            }
        }
        
        if (!palindrome) {
            System.out.println("The string " + str + " is not a palindrome");
        } 
        else {
            System.out.println("The string " + str + " is a palindrome");
        }

    }     
}
