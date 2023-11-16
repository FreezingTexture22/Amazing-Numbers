/*package numbers.stages;

import java.util.Scanner;

public class Stage3 {
    public static void main(String[] args) {

        //welcome message
        System.out.printf("Welcome to Amazing Numbers! \n \n");
        System.out.printf("Supported requests: \n");
        System.out.printf("- enter a natural number to know its properties; \n");
        System.out.printf("- enter 0 to exit. \n \n");

        //run checkNumbers while it returns TRUE (it returns FALSE when program should be stopped)
        while (checkNumbers()) {

        }
    }

    private static boolean checkNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter a request: > ");
        Long num = scanner.nextLong();
        String numAsString = String.valueOf(num);

        //check if num is 0 - then exit
        if (num == 0) {
            System.out.printf("\nGoodbye!");
            return false; // quit
        }

        //check if num is natural
        if (num < 0) {
            System.out.printf("\nThe first parameter should be a natural number or zero. \n\n");
            return true; //continue

        }

        //check if num is even or odd
        boolean even = false;
        if (num%2==0) {
            even = true;
        }

        //check if num is buzz
        boolean buzz = false;
        if (num%7 == 0 || (num - 7) % 10 == 0) {
            buzz = true;
        }

        //check if num is duck
        boolean duck = false;
        if (numAsString.contains("0")) {
            duck = true;
        }

        //check if num is palindromic
        boolean palindromic = false;
        String tmp = "";
        for (int i = numAsString.length()-1; i >= 0; i--) {
            char ch = numAsString.charAt(i);
            tmp = tmp + ch;

        }
        if (numAsString.equals(tmp)) {
            palindromic = true;
        }

        //show properties of num
        showProperties(num, even, buzz, duck, palindromic);
        return true;
    }

    private static void showProperties(long num, boolean even, boolean buzz, boolean duck, boolean palindromic) {;
        System.out.printf("\nProperties of %d \n", num);
        System.out.printf("        even: %b \n", even);
        System.out.printf("         odd: %b \n", !even);
        System.out.printf("        buzz: %b \n", buzz);
        System.out.printf("        duck: %b \n", duck);
        System.out.printf(" palindromic: %b \n \n", palindromic);

    }



}

*/