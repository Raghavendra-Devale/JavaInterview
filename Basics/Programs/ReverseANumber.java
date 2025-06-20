// Program to reverse a given number
package Basics.Programs;

import java.util.Scanner;

public class ReverseANumber {

    // Method to reverse the digits of the given number
    static void reverseNumber(int number) {
        int temp = number;
        int rev = 0;

        while (temp > 0) {
            int dig = temp % 10;       // Extract last digit
            rev = (rev * 10) + dig;    // Append digit to reversed number
            temp /= 10;                // Remove last digit
        }

        System.out.println("Reversed number: " + rev);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        reverseNumber(num);

        sc.close();  
    }
}
