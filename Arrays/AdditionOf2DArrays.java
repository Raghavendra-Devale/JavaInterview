package Arrays;

import java.util.Scanner;

public class AdditionOf2DArrays {
    public static void main(String[] args) {
        int arr [][] = new int[2][2];
        int arr2 [][] = new int[2][2];
        int sum[][] = new int[2][2];
        Scanner sc = new Scanner(System.in);

        System.out.println("First matrix ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
                
            }
        }
        System.out.println("Second matrix ");
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                
                arr2[i][j] = sc.nextInt();
            }
        }
        // Sum
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sum[i][j] = arr2[i][j] + arr[i][j];
            }
        }
        System.out.println("Final sum ");
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum.length; j++) {
                System.out.print(sum[i][j]+" ");
            }System.out.println();
        }
        sc.close();
    }
}
