/*
    Program to check prime number 
    A prime number is a natural number greater than 1 that has no positive divisors other than 
    1 and itself.
    Examples : 2, 3, 5, 7, 11, 13, 17, 19, 23, 29
 */ 

package Basics.Programs;

import java.util.Scanner;

public class CheckPrime {
    
    // method to check prime number or not 
    static void isPrime(int num){

        // if the number is less than 2 that is not prime
        if(num<2){
            System.out.println(num +" Not prime");
            
        }
        boolean isPrimeN = true;
        // start from 2 to sqrt of that number try to divide it we get a remainder 
        // as 0 to that number that number is not prime mark it as false 
        for(int i = 2; i < Math.sqrt(num); i++){
            if (num % i == 0) {
                isPrimeN = false;
            }
        }
        if (isPrimeN) {
            System.out.println("Prime number ");
        }else{
            System.out.println("Not prime");
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a number ");
        int num =  sc.nextInt();
        isPrime(num);
        sc.close();
    }
}
