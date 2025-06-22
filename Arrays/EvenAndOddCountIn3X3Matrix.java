/*
 * Count the number of even and odd numbers in a 3×3×3 matrix.
 */
package Arrays;

public class EvenAndOddCountIn3X3Matrix {
    public static void main(String[] args) {

        // 3D array (3 layers, each with 3 rows and 3 columns)
        int arr[][][] = {
            { {2, 3, 4}, {5, 7, 8}, {12, 2, 33} },
            { {45, 34, 25}, {23, 33, 22}, {56, 79, 95} },
            { {1, 2, 3}, {4, 5, 5}, {7, 8, 9} }
        };

        // Variables to store even and odd number counts
        int evenCount = 0;
        int oddCount = 0;

        // Loop through each layer of the 3D array
        for (int i = 0; i < arr.length; i++) {
            // Loop through each row in the current layer
            for (int j = 0; j < arr[i].length; j++) {
                // Loop through each element (column) in the current row
                for (int k = 0; k < arr[i][j].length; k++) {

                    // Check if the current element is even
                    if (arr[i][j][k] % 2 == 0) {
                        evenCount++;  // Increment even counter
                    } else {
                        oddCount++;   // Increment odd counter
                    }
                }
            }
        }

        // Display the final count of even and odd numbers
        System.out.println("Even count: " + evenCount + " Odd count: " + oddCount);
    }
}
