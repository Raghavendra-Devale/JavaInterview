/*
 * 1. Write a Java program to create an array list, add some colors (strings) and print out the collection.
 * 2. Write a Java program to iterate through all elements in an array list.
 * 3.Write a Java program to insert an element into the array list at the first position.
 * 4.Write a Java program to retrieve an element (at a specified index) from a given array list.
 * 5.Write a Java program to update an array element by the given element.
 * 6.Write a Java program to remove the third element from an array list.
 * 7.Write a Java program to search for an element in an array list.
 * 8.Write a Java program to sort a given array list.
 * 9.Write a Java program to shuffle elements in an array list.
 * 10.Write a Java program to copy one array list into another.
 */


import java.util.ArrayList;
import java.util.Collections;

public class CreateAndPrintArrayList  {

    public static void main(String[] args) {
        ArrayList <String>colors = new ArrayList<>();
         ArrayList <Object> colors2 = new ArrayList<>();// this should be object copy string

        colors.add("Blue");//1
        colors.add("Green");
        colors.add("Red");

        for (int i = 0; i < colors.size(); i++) {//2
            System.out.println(colors.get(i));    

        }
        colors.add(0,"black");//3
        System.out.println(colors.get(3)+"3rd index");//4
        colors.add(2,"Yellow");//5

        System.out.println(colors);
        colors.set(0, "purple");
        System.out.println(colors);
        System.out.println(colors.remove(2)+" Removed third");//6
        System.out.println(colors.contains("Green")); //7
        System.out.println("Before sort "+colors);
        Collections.sort(colors);//8
        System.out.println("After sort "+ colors);
        Collections.shuffle(colors);//9
        System.out.println("After shuffle "+colors);
        
        colors2.add(colors);//10
        System.out.println("in colors2 "+colors2);

    }
}