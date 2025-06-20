package Basics.Programs;

import java.util.Scanner;

public class StringPalindrome {

    // Method to check if a string is a palindrome
    public boolean checkPali(String s) {
       
        String rev = "";

        // Reverse the string
        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i); 
        }
        // Check if the original string equals the reversed string return boolean value
        return rev.equals(s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to check if it's a palindrome: ");
        String input = sc.nextLine();

        StringPalindrome sp = new StringPalindrome();

        // Output the result
        if (sp.checkPali(input)) {
            System.out.println("Yes it's a palindrome.");
        } else {
            System.out.println("No not a palindrome.");
        }

        sc.close(); 
    }
}
