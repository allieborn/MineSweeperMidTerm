import java.util.Scanner;

/**
 * A validator class that validates various inputs
 *
 * @author Antonella Solomon
 * @author Sarah Guarino
 * @version 1.1
 */
class Validator {

    /**
     * Validates an integer
     * @param sc Scanner object
     * @param prompt question you want to ask the user
     * @return valid entry from the user
     */
    private static int getInt(Scanner sc, String prompt) {
        int i = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    /**
     * Validates an integer between the min and max
     * @param sc Scanner object
     * @param prompt question to ask the user
     * @param min lowest number accepted
     * @param max highest number accepted
     * @return returns valid integer between min and max
     */
    public static int getInt(Scanner sc, String prompt,
                             int min, int max) {
        int i = 0;
        boolean isValid = false;

        while (!isValid)
        {
            i = getInt(sc, prompt);
            if (i < min) {
                System.out.println(
                        "Error! Number must be " + min + " or greater.");
            } else if (i > max) {
                System.out.println(
                        "Error! Number must be " + max + " or less. Try again.");
            } else {
                isValid = true;
            }
        }
        return i;
    }

    /**
     * Validates an integer higher than the minimum amount
     * @param sc Scanner object
     * @param prompt question to ask user
     * @param min minimum number (exclusive) that can be accepted
     * @return returns valid integer above min number
     */
    static int getInt(Scanner sc, String prompt,
                      int min) {
        int i = 0;
        boolean isValid = false;

        while(!isValid) {
            i = getInt(sc, prompt);
            if (i < min) {
                System.out.println("Error! Number must be higher than " + min + ". Try again.");
            } else {
                isValid = true;
            }
        }
        return i;
    }

    static double getDouble(Scanner sc, String prompt)
    {
        double d = 0;
        boolean isValid = false;
        while (!isValid)
        {
            System.out.print(prompt);
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    public static double getDouble(Scanner sc, String prompt,
                                   double min, double max)
    {
        double d = 0;
        boolean isValid = false;
        while (!isValid)
        {
            d = getDouble(sc, prompt);
            if (d < min) {
                System.out.println(
                        "Error! Number must be " + min + " or greater.");
            } else if (d > max) {
                System.out.println(
                        "Error! Number must be " + max + " or less.");
            } else {
                isValid = true;
            }
        }
        return d;
    }

    /**
     * Validates the user reply is one of two characters ex: y or n
     * @param sc Scanner object
     * @param prompt question to prompt the user
     * @param char1 first character to compare to
     * @param char2 second character to compare to
     * @return returns validate character
     */
    static String getFirstChar(Scanner sc, String prompt, String char1, String char2) {
        String character = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            // if the first character of the user's next input is equal to char1
            character = Character.toString(sc.nextLine().charAt(0)).toLowerCase();
            if (character.equals(char1) || character.equals(char2)) {
                isValid = true;
            } else {
                System.out.println("Error! Invalid response. Try again.");
            }
        }
        return character;
    }

    /**
     * Validates a character that is one of three choices
     * @param sc Scanner object
     * @param prompt question to ask the user
     * @param char1 first character to compare to
     * @param char2 second character to compare to
     * @param char3 third character to compare to
     * @return valid character response
     */
    static String getFirstChar(Scanner sc, String prompt, String char1, String char2, String char3) {
        String character = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            // if the first character of the user's next input is equal to char1
            character = Character.toString(sc.nextLine().charAt(0)).toLowerCase();
            if (character.equals(char1) || character.equals(char2) || character.equals(char3)) {
                isValid = true;
            } else {
                System.out.println("Error! Invalid response. Try again.");
            }
        }
        return character;
    }

    /**
     * Validates a single word as being a string
     *
     * @param sc Scanner object
     * @param prompt text to prompt for input
     * @return the word the user types in
     */
    public static String getString(Scanner sc, String prompt) {
        System.out.print(prompt);
        String s = sc.next();  // read user entry
        sc.nextLine();  // discard any other data entered on the line
        return s;
    }
}