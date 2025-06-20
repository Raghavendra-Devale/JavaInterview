/*
 * 3. Store names of 5 students in a 1D array and display them.
 */
package Arrays;

import java.util.Scanner;

public class StoreStudentsName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] names = new String[5];
        System.out.println("Enter 5 students ");
        for (int i = 0; i < names.length; i++) {
            names[i] = sc.nextLine();
        }
        System.out.println("Printing names ");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
        sc.close();
    }
}
