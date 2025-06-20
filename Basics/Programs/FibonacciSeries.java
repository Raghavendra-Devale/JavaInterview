package Basics.Programs;
import java.util.Scanner;

public class FibonacciSeries {

    // Method to generate Fibonacci series up to 'num' terms
    static int[] fibonacci(int num) {
        // Initialize an array to store Fibonacci numbers
        int[] fib = new int[num];

        // First Fibonacci number is always 0
        fib[0] = 0;

        // Generate the rest of the series if num > 1
        if (num > 1) {
            fib[1] = 1; // Second Fibonacci number is 1

            // Loop starts from index 2 and fills the rest of the array
            for (int i = 2; i < num; i++) {
                fib[i] = fib[i - 1] + fib[i - 2]; // Fibonacci formula
            }
        }

        // Return the generated Fibonacci series as an array
        return fib;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of Fibonacci terms ");
        int num = sc.nextInt();

        int [] res = fibonacci(num);
        for(int i = 0; i < res.length; i++){
            System.out.print(" "+res[i]);
        }
        

        
        sc.close();
    }
}
