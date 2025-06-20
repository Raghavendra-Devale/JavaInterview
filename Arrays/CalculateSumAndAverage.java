/*
 * 5. Calculate the sum and average of elements in a 1D array.
 */
package Arrays;

public class CalculateSumAndAverage {
    public static void main(String[] args) {
        int avg = 0;
        int sum = 0; 
        int arr[] = {2,4,8,6,1,4};
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        avg = sum/arr.length;
        System.out.println("Sum "+sum+" Average is "+avg);
        
    }
    
}
