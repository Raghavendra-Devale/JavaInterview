/*
 * 1. Create a 1D array of 5 integers and print all elements.
 */

package Arrays;

public class OneDArrayExample {
    public static void main(String[] args) {
        int arr[] = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;            
        }


        for(int i = 0; i < arr.length; i++){
        System.out.print(arr[i]+" ");
    }
    
    }
    
}
