package numbers;

import java.util.Scanner;

public class Main {

    static String inputLine = "";

    public static void main(String[] args) {

        //welcome message, print once
        System.out.printf("Welcome to Amazing Numbers! \n \n");
        System.out.printf("Supported requests: \n");
        System.out.printf("- enter a natural number to know its properties; \n");
        System.out.printf("- enter two natural numbers to obtain the properties of the list: \n");
        System.out.printf("  * the first parameter represents a starting number; \n");
        System.out.printf("  * the second parameter shows how many consecutive numbers are to be printed; \n");
        System.out.printf("- two natural numbers and a properties to search for; \n \n");
        System.out.printf("- a property preceded by minus must not be present in numbers; \n \n");
        System.out.printf("- separate the parameters with one space; \n \n");
        System.out.printf("- enter 0 to exit. \n \n");

        //run checkNumbers while it returns TRUE (it returns FALSE when program should be stopped)
        while (input()) {

        }
    }

    private static boolean input() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\nEnter a request: > ");
        inputLine = scanner.nextLine().toUpperCase();

        String[] inputArray;
        long num0 = 0;
        long num1 = 0;
        String property0 = null;
        String property1 = null;

        ///////////////////////////////////////////////////////////
        //check if there are more than one number
        if (inputLine.contains(" ")) {
            inputArray = inputLine.split(" "); // fill inputArray

            //////
            //DIGITS? check inputArray STRING INDEXES 0 and 1
            if (!inputArray[0].matches("\\d+")) {
                System.out.printf("\nThe first parameter should be a natural number or zero. \n\n");
                return true; //continue
            }

            if (inputArray[0].contains("-\\d+") ) {
                System.out.printf("\nThe first parameter should be a natural number or zero. \n\n");
                return true; //continue
            }

            if (!inputArray[1].matches("\\d+")) {
                System.out.printf("\nThe second parameter should be a natural number. \n\n");
                return true; //continue
            }

            if (inputArray[1].contains("-\\d+")) {
                System.out.printf("\nThe second parameter should be a natural number. \n\n");
                return true; //continue
            }
            // end of inputArray STRING INDEXES 0 and 1
            //////

            //////
            // parse digits to LONG vars
            num0 = Long.parseLong(inputArray[0]); // 1st number
            num1 = Long.parseLong(inputArray[1]); // 2nd number

            //////
            //check if num0 is natural
            if (num0 < 0) {
                System.out.printf("\nThe first parameter should be a natural number or zero. \n\n");
                return true; //continue
            }

            //////
            //check if num1 is natural
            if (num1 <= 0) {
                System.out.printf("\nThe second parameter should be a natural number. \n\n");
                return true; //continue
            }

            //////
            // if more than 2 digits were entered
            if (inputArray.length >= 3) {
                // make FILTER array (skip 1st and 2nd numbers)
                String[] filter = new String[inputArray.length - 2];
                // fill FILTER array (only filter words, no 1 and 2 numbers)
                for (int i = 2; i < inputArray.length; i++ ) {
                    filter[i-2] = inputArray[i];
                }

                checkNumbers(num0, num1, filter);
                return true;

            }

            //show brief info of series of numbers
            checkNumbers(num0, num1);

        ///////////////////////////////////////////////////////////
        // IF only one number - do this ->
        } else {
            /////////////////////////
            //check if input is digit
            // if not - error message
            if (!inputLine.matches("\\d+")) {
                System.out.printf("\nThe first parameter should be a natural number or zero. \n\n");
                return true; //continue
            }
            ////

            //if input is number - proceed
            num0 = Long.parseLong(inputLine);
            ////

            //check if num0 is 0 - then exit
            if (num0 == 0) {
                System.out.printf("\nGoodbye!");
                return false; // quit
            }
            ////

            //check if num0 is natural
            if (num0 < 0) {
                System.out.printf("\nThe first parameter should be a natural number or zero. \n\n");
                return true; //continue

            }

            //if all is OK - print full number info
            checkNumbers(num0);

            //continue program operation
        }
        return true; //continue
        ///////////////////////////////////////////////////////////

    }


    ///////////////////////////////////////////////////////////
    // single number, full info
    private static boolean checkNumbers(long num0) {
        showFullProperties(num0);
        return true;
    }

    // single number, brief info
    private static boolean checkNumbers(long num0, long num1) {
        for (int i = 0; i < num1; i++) {
            System.out.println(showBriefProperties(num0+i));
        }

        return true;
    }

    // single number, brief info, filtered
    private static boolean checkNumbers(long num0, long num1, String... filter) {
        if (checkProperty(filter)) {
            return true;
        }
        checkNumbersWithFilter(num0, num1, filter);
        return true;
    }
///////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////
    // filter numbers
    private static boolean checkNumbersWithFilter(long num0, long num1, String... filter) {
        boolean brief = true; // will show brief info
        String numAsString = String.valueOf(num0); // assign number as string
        int foundNumbers = 0; // set counter to 0

        while (foundNumbers < num1) {
            boolean toPrint = true;
            String output = showBriefProperties(num0);

            for (String s : filter) {
                String removeFilter = "";
                // if FILTER contains - (-SAD) - clear it
                if (s.contains("-")) {
                    removeFilter = s.substring(1).toLowerCase();
                }

                if (!output.contains(s.toLowerCase()) && output.contains(removeFilter)) {
                    toPrint = false;
                    break;
                }
            }

            if (toPrint) {
                System.out.println(output);
                foundNumbers++;
                num0++;

/*                if (num0 == 1234567899) {
                    num0 = 2101010101;
                }*/

            } else {
                    num0++;
                }

            }



        return true;
    }
///////////////////////////////////////////////////////////
// check if FILTERS are legal
    private static boolean checkProperty(String... filter) {
        String output = "";
        String availableProperties = "\nAvailable properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD] \n\n";
        String outputOneStart = "\nThe property [";
        String outputOneEnd = "] is wrong. \n";
        String outputTwoStart = "\nThe properties [";
        String outputTwoEnd = "] are wrong. \n";
        int quantityOfErrors = 0;

        for(String s : filter) {
            if (!s.toUpperCase().matches("EVEN")
                    && !s.toUpperCase().matches("ODD")
                    && !s.toUpperCase().matches("BUZZ")
                    && !s.toUpperCase().matches("DUCK")
                    && !s.toUpperCase().matches("PALINDROMIC")
                    && !s.toUpperCase().matches("GAPFUL")
                    && !s.toUpperCase().matches("SPY")
                    && !s.toUpperCase().matches("SQUARE")
                    && !s.toUpperCase().matches("SUNNY")
                    && !s.toUpperCase().matches("JUMPING")
                    && !s.toUpperCase().matches("HAPPY")
                    && !s.toUpperCase().matches("SAD")
                    && !s.toUpperCase().matches("-EVEN")
                    && !s.toUpperCase().matches("-ODD")
                    && !s.toUpperCase().matches("-BUZZ")
                    && !s.toUpperCase().matches("-DUCK")
                    && !s.toUpperCase().matches("-PALINDROMIC")
                    && !s.toUpperCase().matches("-GAPFUL")
                    && !s.toUpperCase().matches("-SPY")
                    && !s.toUpperCase().matches("-SQUARE")
                    && !s.toUpperCase().matches("-SUNNY")
                    && !s.toUpperCase().matches("-JUMPING")
                    && !s.toUpperCase().matches("-HAPPY")
                    && !s.toUpperCase().matches("-SAD")
            ) {
                output = output + s + " ";
                quantityOfErrors++;
            }
        }

        if (quantityOfErrors == 1) {
            output = outputOneStart + output.trim() + outputOneEnd;
            System.out.printf(output);
            System.out.printf(availableProperties);
            return true;

        } if (quantityOfErrors >= 2) {
            output = outputTwoStart + output.trim() + outputTwoEnd;
            System.out.printf(output);
            System.out.printf(availableProperties);
            return true;

        } else {
            //check if input line has Mutually Exclusive properties (odd-even, sunny-square, duck-spy)
            if (checkIfinputLineMutuallyExclusive(inputLine)) {
                return true; // if YES - error and start over
            }

            return false;

        }

    }



///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

    private static void checkAll(long num0, String numAsString) {

    }

    private static void showFullProperties(long num0) {;

        String numAsString = String.valueOf(num0);

        boolean buzz = checkIfBuzz(num0);
        boolean duck = checkIfDuck(numAsString);
        boolean palindromic = checkIfPalindromic(numAsString);
        boolean gapful = checkIfGapful(num0);
        boolean spy = checkIfSpy(num0);
        boolean square = checkIfSquare(num0);
        boolean sunny = checkIfSunny(num0);
        boolean jumping = checkIfJumping(numAsString);
        boolean even = checkIfEven(num0);
        boolean odd = !even;
        boolean happy = checkIfHappy(num0);
        boolean sad = !happy;


        System.out.printf("\nProperties of %d \n", num0);
        System.out.printf("        buzz: %b \n", buzz);
        System.out.printf("        duck: %b \n", duck);
        System.out.printf(" palindromic: %b \n", palindromic);
        System.out.printf("      gapful: %b \n", gapful);
        System.out.printf("         spy: %b \n", spy);
        System.out.printf("      square: %b \n", square);
        System.out.printf("       sunny: %b \n", sunny);
        System.out.printf("     jumping: %b \n", jumping);
        System.out.printf("        even: %b \n", even);
        System.out.printf("         odd: %b \n", odd);
        System.out.printf("       happy: %b \n", happy);
        System.out.printf("         sad: %b \n\n", sad);

    }


    private static String showBriefProperties(long num0) {;
        String numAsString = String.valueOf(num0);

        boolean buzz = checkIfBuzz(num0);
        boolean duck = checkIfDuck(numAsString);
        boolean palindromic = checkIfPalindromic(numAsString);
        boolean gapful = checkIfGapful(num0);
        boolean spy = checkIfSpy(num0);
        boolean square = checkIfSquare(num0);
        boolean sunny = checkIfSunny(num0);
        boolean jumping = checkIfJumping(numAsString);
        boolean even = checkIfEven(num0);
        boolean odd = !even;
        boolean happy = checkIfHappy(num0);
        boolean sad = !happy;

        String spyString = spy? "spy " : "";
        String evenString = even? "even " : "";
        String oddString = odd? "odd " : "";
        String buzzString = buzz? "buzz " : "";
        String duckString =  duck? "duck " : "";
        String palindromicString = palindromic ? "palindromic " : "";
        String gapfulString = gapful? "gapful " : "";
        String squareString = square? "square " : "";
        String sunnyString = sunny? "sunny " : "";
        String jumpingString = jumping? "jumping " : "";
        String happyString = happy? "happy " : "";
        String sadString = sad? "sad " : "";

        String finalOutput = "           "+ num0 +" is "
                + palindromicString
                + buzzString
                + gapfulString
                + spyString
                + duckString
                + squareString
                + sunnyString
                + jumpingString
                + evenString
                + oddString
                + happyString
                + sadString
                ;

        return finalOutput;

    }



///////////////////////////////////////////////////////////
    // checkIt methods
    //

    private static boolean checkIfinputLineMutuallyExclusive(String inputLine) {
        String s1 = "";
        String s2 = "";
        boolean exclusive = false;
        String inputLineUpperCase = inputLine.toUpperCase();

        if (inputLineUpperCase.contains(" ODD") && inputLineUpperCase.contains("-ODD")) {
            s1 = "ODD";
            s2 = "-ODD";
            exclusive = true;
        } else if (inputLineUpperCase.contains(" EVEN") && inputLineUpperCase.contains("-EVEN")) {
            s1 = "EVEN";
            s2 = "-EVEN";
            exclusive = true;
        } if (inputLineUpperCase.contains(" ODD") && inputLineUpperCase.contains(" EVEN")) {
            s1 = "ODD";
            s2 = "EVEN";
            exclusive = true;
        } if (inputLineUpperCase.contains("-ODD") && inputLineUpperCase.contains("-EVEN")) {
            s1 = "-ODD";
            s2 = "-EVEN";
            exclusive = true;
        } else if (inputLineUpperCase.contains(" SUNNY") && inputLineUpperCase.contains("-SUNNY")) {
            s1 = "SUNNY";
            s2 = "-SUNNY";
            exclusive = true;
        } else if (inputLineUpperCase.contains(" SQUARE") && inputLineUpperCase.contains("-SQUARE")) {
            s1 = "SQUARE";
            s2 = "-SQUARE";
            exclusive = true;
        } else if (inputLineUpperCase.contains(" SUNNY") && inputLineUpperCase.contains(" SQUARE")) {
            s1 = "SUNNY";
            s2 = "SQUARE";
            exclusive = true;
        } else if (inputLineUpperCase.contains("-SUNNY") && inputLineUpperCase.contains("-SQUARE")) {
            s1 = "-SUNNY";
            s2 = "-SQUARE";
            exclusive = true;
        } else if (inputLineUpperCase.contains(" DUCK") && inputLineUpperCase.contains(" SPY")) {
            s1 = "DUCK";
            s2 = "SPY";
            exclusive = true;
        } else if (inputLineUpperCase.contains("-DUCK") && inputLineUpperCase.contains("-SPY")) {
            s1 = "-DUCK";
            s2 = "-SPY";
            exclusive = true;
        } else if (inputLineUpperCase.contains(" DUCK") && inputLineUpperCase.contains("-DUCK")) {
            s1 = "DUCK";
            s2 = "-DUCK";
            exclusive = true;
        } else if (inputLineUpperCase.contains(" SPY") && inputLineUpperCase.contains("-SPY")) {
            s1 = "SPY";
            s2 = "-SPY";
            exclusive = true;
        } else if (inputLineUpperCase.contains(" HAPPY") && inputLineUpperCase.contains(" SAD")) {
            s1 = "HAPPY";
            s2 = "SAD";
            exclusive = true;
        } else if (inputLineUpperCase.contains("-HAPPY") && inputLineUpperCase.contains("-SAD")) {
            s1 = "-HAPPY";
            s2 = "-SAD";
            exclusive = true;
        } else if (inputLineUpperCase.contains(" HAPPY") && inputLineUpperCase.contains("-HAPPY")) {
            s1 = "HAPPY";
            s2 = "-HAPPY";
            exclusive = true;
        } else if (inputLineUpperCase.contains(" SAD") && inputLineUpperCase.contains("-SAD")) {
            s1 = "SAD";
            s2 = "-SAD";
            exclusive = true;
        } else if (inputLineUpperCase.contains(" BUZZ") && inputLineUpperCase.contains("-BUZZ")) {
            s1 = "BUZZ";
            s2 = "-BUZZ";
            exclusive = true;
        } else if (inputLineUpperCase.contains(" PALINDROMIC") && inputLineUpperCase.contains("-PALINDROMIC")) {
            s1 = "PALINDROMIC";
            s2 = "-PALINDROMIC";
            exclusive = true;
        } else if (inputLineUpperCase.contains(" GAPFUL") && inputLineUpperCase.contains("-GAPFUL")) {
            s1 = "GAPFUL";
            s2 = "-GAPFUL";
            exclusive = true;
        } else if (inputLineUpperCase.contains(" SUNNY") && inputLineUpperCase.contains("-SUNNY")) {
            s1 = "SUNNY";
            s2 = "-SUNNY";
            exclusive = true;
        } else if (inputLineUpperCase.contains(" JUMPING") && inputLineUpperCase.contains("-JUMPING")) {
            s1 = "JUMPING";
            s2 = "-JUMPING";
            exclusive = true;
        }

        if (exclusive) {
            System.out.printf("\nThe request contains mutually exclusive properties: [%s, %s]", s1, s2);
            System.out.printf("\nThere are no numbers with these properties.\n\n");
            return true; //continue
        }

        return false;
    }


    private static boolean checkIfSpy(Long num0) {
        boolean spy = false;

        //put every number from input string to String array
        String[] numAsString2 = String.valueOf(num0).split("");

        //create int array
        int[] intArray = new int[numAsString2.length];

        //fill int array with numbers from String array
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.valueOf(numAsString2[i]);
        }

        //find summ af all elements of array
        int summOfElements = 0;
        for (int i : intArray) {
            summOfElements = summOfElements + i;
        }

        //find product af all elements of array
        int prodOfElements = 1;
        for (int i : intArray) {
            prodOfElements = prodOfElements * i;
        }

        //if summ == prod -> spy is TRUE
        spy = summOfElements == prodOfElements;
        return spy;

    }

    private static boolean checkIfGapful(long num0) {
        boolean gapful = false;

        // if number XYZ can be divided by XZ (first number + lastnumber) without reminder - it is Gapful
        if(String.valueOf(num0).length() >= 3 ) {
            char c1 = String.valueOf(num0).charAt(0); // first num
            char c2 = String.valueOf(num0).charAt(String.valueOf(num0).length() -1); // last num
            String c1c2 = "" + c1 + c2;
            Long g = Long.parseLong(c1c2); // make new num = first + last (1 + 2 = 12)
            gapful = num0 % g == 0; // set true or false

        }
        return gapful;
    }

    private static boolean checkIfEven(long num0) {
        return num0 % 2 == 0;
    }

    private static boolean checkIfOdd(long num0) {
        return num0 % 2 != 0;
    }

    private static boolean checkIfBuzz(long num0) {
        return num0 % 7 == 0 || (num0 - 7) % 10 == 0;
    }

    private static boolean checkIfDuck(String numAsString) {
        return numAsString.contains("0");
    }

    private static boolean checkIfPalindromic(String numAsString) {
        String tmp = "";
        for (int i = numAsString.length()-1; i >= 0; i--) {
            char ch = numAsString.charAt(i);
            tmp = tmp + ch;
        }

        return numAsString.equals(tmp);

    }

    private static boolean checkIfSquare(long num0) {
        double squareNum = Math.sqrt(num0);
        return squareNum == (int) squareNum;
    }

    private static boolean checkIfSunny(long num0) {
        return checkIfSquare(num0+1);
        }

    private static boolean checkIfJumping(String numAsString) {
        int counter = 0; //counter
        long[] array = new long[numAsString.length()]; // make array of every single number in numAsString

        //fill the array
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(String.valueOf(numAsString.charAt(i)));
        }

        //check if numAsString is jumping
        if (array.length == 1) { return true; }

        for (int i = 0; i < numAsString.length()-1; i++) {
            if (array[i] + 1 != array[i+1] && array[i] - 1 != array[i+1]) {
                return false;
            }
        }
        return true;
    }


    public static boolean checkIfHappy(long num0) {
        // if l is one of these numbers - its HAPPY
        if (num0 == 1 || num0 == 7) {
            return true;
        }

        //get number and make it String
        String[] numAsString = String.valueOf(num0).split("");

        // make new int array
        int[] intArray = new int[numAsString.length];

        // put every digit from String array to int array
        for (int i = 0; i < numAsString.length; i++) {
            intArray[i] = Integer.parseInt(numAsString[i]);
        }

        // now make calculations
        //
        // while l is more than 9, do this
        while(num0 > 9) {
            num0 = 0;
            for(int i = 0; i < intArray.length; i++) {
                num0 = num0 + (intArray[i] * intArray[i]);
            }
            // recursion...
            return checkIfHappy(num0);
        }
        // if <10 and not true ->
        return false;
    }

}