/*
package numbers.stages;

import java.util.Scanner;

public class Stage2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int num = scanner.nextInt();

        //check if num is natural
        if (num <= 0) {
            System.out.println("This number is not natural!");
            return; //if not - exit
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
        if (String.valueOf(num).contains("0")) {
            duck = true;
        }

        showProperties(num, even, buzz, duck);
    }

    private static void showProperties(int num, boolean even, boolean buzz, boolean duck) {
        System.out.printf("Properties of %d \n", num);
        System.out.printf("        even: %b \n", even);
        System.out.printf("         odd: %b \n", !even);
        System.out.printf("        buzz: %b \n", buzz);
        System.out.printf("        duck: %b \n", duck);

    }
}

*/