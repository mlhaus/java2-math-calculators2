package edu.kirkwood.controller.marc;

import static edu.kirkwood.view.Messages.fractionGoodbye;
import static edu.kirkwood.view.Messages.fractionGreet;
import static edu.kirkwood.view.UIUtility.pressEnterToContinue;
import static edu.kirkwood.view.UserInput.getString;

public class FractionCalculator {
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
        return null;
    }
}
