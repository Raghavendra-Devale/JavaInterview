/*
 * Find the transpose of a 2×3 matrix.
 * 
 */
package Arrays;

import java.util.Scanner;

public class TransposeOfMatrix {
    public static void main(String[] args) {
        //  Mistake: Earlier, I confused rows and columns.
        // This is a 2x3 matrix (2 rows, 3 columns).
        int arr[][] = new int[2][3];

        // Mistake: Transpose of a 2x3 matrix is a 3x2 matrix.
        int transpose[][] = new int[3][2];

        Scanner sc = new Scanner(System.in);

        //  Correct loop to read matrix input.
        for (int i = 0; i < arr.length; i++) {
            //  Mistake: Previously used arr.length in inner loop too,
            // but that only gives number of rows. Should use arr[0].length for columns.
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Correct transpose loop.
        for (int i = 0; i < arr.length; i++) { //  Mistake: Initially looped over transpose instead of arr
            for (int j = 0; j < arr[0].length; j++) {
                //  Mistake: Used transpose[i][j] = arr[j][i] before, which caused IndexOutOfBounds.
                //  Correct: Transpose means flip i and j -> transpose[j][i] = arr[i][j]
                transpose[j][i] = arr[i][j];
            }
        }
        
        System.out.println("Transpose ");
        // Correct loop to print the transposed matrix.
        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[0].length; j++) {
                System.out.print(transpose[i][j]+" ");
            }
            System.out.println();
        }

        sc.close();
    }
}
