/*
 * 2. Read 10 numbers into an array and print only the even numbers.
 */

package Arrays;

import java.util.Scanner;

public class ReadAndPrintEven {
    public static void main(String[] args) {
        int arr[] = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 10 no's");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Printing even ");
        for (int i = 0; i < arr.length; i++ ) {
            if (arr[i]%2 == 0) {
                System.out.println(arr[i]);
            }
        }
        sc.close();
    }
}
