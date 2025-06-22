/*
 * Read a 3×3 matrix from the user and find the sum of all elements.
 */
package Arrays;

import java.util.Scanner;

public class ThreeXThreeSum {
    public static void main(String[] args) {
        int arr[][] = new int[3][3];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = sc.nextInt();
            }    
        }

        //sum 
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
        sc.close();
    }
    
}
