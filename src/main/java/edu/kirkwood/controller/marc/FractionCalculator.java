package edu.kirkwood.controller.marc;

import static edu.kirkwood.view.Messages.fractionGoodbye;
import static edu.kirkwood.view.Messages.fractionGreet;
import static edu.kirkwood.view.UIUtility.pressEnterToContinue;
import static edu.kirkwood.view.UserInput.getString;

public class FractionCalculator {
    public static final String INVALID_FRACTION_MESSAGE = "Invalid format. Ensure operator (+, -, *, /) has a space on both sides.";
    public static final String INVALID_SECOND_FRACTION_MESSAGE = "Missing the second fraction";
    public static final String INVALID_FIRST_FRACTION_MESSAGE = "Missing the first fraction";

    public static void start() {
        fractionGreet();
        while(true) {
            String value = getString("Enter your equation (or 'q' to quit)");
            if (value.equalsIgnoreCase("q") || value.equalsIgnoreCase("quit")) {
                break;
            }
            // Todo: Validate the input
            // Todo: Perform mathematical operation
            // Todo: Display output
        }
        fractionGoodbye();
        pressEnterToContinue();
    }


    /**
     * Splits the user input string into three parts: first fraction, operator, and second fraction.
     *
     * @param input the raw input string from the user.
     * @return a String array of size 3.
     * @throws IllegalArgumentException if the input format or operator is invalid.
     */
    public static String[] splitCalculation(String input) throws IllegalArgumentException {
        // Validate the mathematical operator
        String operator = "";
        int operatorIndex = -1;
        if(input.contains(" + ")) {
            operator = "+";
            operatorIndex = input.indexOf(" + "); // Find the String index of the space before the operator
        } else if(input.contains(" - ")) {
            operator = "-";
            operatorIndex = input.indexOf(" - "); // Find the String index of the space before the operator
        } else if(input.contains(" * ")) {
            operator = "*";
            operatorIndex = input.indexOf(" * "); // Find the String index of the space before the operator
        } else if(input.contains(" / ")) {
            operator = "/";
            operatorIndex = input.indexOf(" / "); // Find the String index of the space before the operator
        }
        // What should I do if the operator is still "" and the operatorIndex is -1?????
        if(operator.equals("") && operatorIndex == -1) {
            throw new IllegalArgumentException(INVALID_FRACTION_MESSAGE);
        }
        // We have a valid mathematical operator
        // Get the first fraction
        String fractionStr1 = input.substring(0, operatorIndex).trim();
        // Does the first fraction string exist? What if it was an empty string?
        if(fractionStr1.isEmpty()) {
            throw new IllegalArgumentException(INVALID_FIRST_FRACTION_MESSAGE);
        }
        // Get the second fraction, start where the mathematical operator stopped
        String fractionStr2 = input.substring(operatorIndex + 3).trim();
        // Does the second fraction string exist? What if it was an empty string?
        if(fractionStr2.isEmpty()) {
            throw new IllegalArgumentException(INVALID_SECOND_FRACTION_MESSAGE);
        }
        // Celebrate, we have all three parts!
        return new String[]{fractionStr1, operator, fractionStr2};
    }
}
