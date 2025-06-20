/*
 * 4. Find the maximum and minimum value in a 1D array.
 */

package Arrays;

public class FindMaxAndMin {
   public static void main(String[] args) {
    int arr[] = {2,4,8,6,1,4};
    int min = arr[0];
    int max = arr[0];
    for (int i = 0; i < arr.length; i++) {
        if (arr[i]<min) {
            min=arr[i];
        }
        if(arr[i]>max){
            max=arr[i];
        }
    }
    System.out.println(min+" min number and max num : "+max);
   } 
}
