/*
package numbers.stages;

import java.util.Scanner;

public class Stage1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int num = scanner.nextInt();

        if (num <= 0) {
            System.out.println("This number is not natural!");
            return;
        }

        if (num%2==0) {
            System.out.println("This number is Even.");
        } else {
            System.out.println("This number is Odd.");
        }

        if (num%7 == 0 && (num - 7) % 10 == 0) {
            System.out.println("It is a Buzz number.");
            System.out.println("Explanation:");
            System.out.printf("%d is divisible by 7 and ends with 7.", num);
        } else if (num%7 == 0) {
            System.out.println("It is a Buzz number.");
            System.out.println("Explanation:");
            System.out.printf("%d is divisible by 7.", num);
        } else if ((num - 7) % 10 == 0) {
            System.out.println("It is a Buzz number.");
            System.out.println("Explanation:");
            System.out.printf("%d ends with 7.", num);
        } else {
            System.out.println("It is not a Buzz number.");
            System.out.println("Explanation:");
            System.out.printf("%d is neither divisible by 7 nor does it end with 7.", num);
        }

    }
}
*/