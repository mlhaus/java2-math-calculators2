package edu.kirkwood.controller.trae;

import edu.kirkwood.model.trae.AutoLoan;

import static edu.kirkwood.view.Messages.autoLoanGoodbye;
import static edu.kirkwood.view.Messages.autoLoanGreet;
import static edu.kirkwood.view.UIUtility.displayError;
import static edu.kirkwood.view.UIUtility.pressEnterToContinue;
import static edu.kirkwood.view.UserInput.*;

public class AutoLoanCalculator {
    public static void start(){
        autoLoanGreet();

        outer: while(true) {
            // get user input if the user want to enter or not
            String value = getString("Would you like to enter an auto loan? ('y' to continue or 'q' to quit)");

            // valid the input
            if(value.equalsIgnoreCase("q") || value.equalsIgnoreCase("quit")) {
                break;
            }

            if(value.equalsIgnoreCase("y") || value.equalsIgnoreCase("yes")) {
                AutoLoan loan = new AutoLoan();
                // Get auto loan information

                double carPrice = getDouble("Enter the car price (-1 to quit)", true, -1);
                if(carPrice == -1){
                    break outer;
                }
                loan.setCarPrice(carPrice);


                while(true) {

                    double downPayment = getDouble("Enter the down payment (-1 to quit)", true, -1);
                    if (downPayment == -1) {
                        break outer;
                    }
                    try {
                        loan.setDownPayment(downPayment);
                        break;
                    } catch (IllegalArgumentException e) {
                        displayError(e.getMessage());
                    }
                }

                double interestRate = getDouble("Enter the interest rate (-1 to quit)", true, -1);
                if(interestRate == -1) {
                    break outer;
                }
                loan.setInterestRate(interestRate);
                int loanTerm = getInt("Enter the loan term (-1 to quit)", true, -1);
                if(loanTerm == -1) {
                    break outer;
                }
                loan.setLoanTerm(loanTerm);

                // print the toString from the loan
                System.out.println(loan);
                pressEnterToContinue();

                // print the amortizationTable
                loan.generateAmortizationTable();

                // prompt for extra payments

                while(true) {
                    String extraPaymentPrompt = getString("Are you making any extra payments? (enter 'y' for yes or 'q' to quit)");

                    if(extraPaymentPrompt.equalsIgnoreCase("q") || extraPaymentPrompt.equalsIgnoreCase("quit")) {
                        break outer;
                    }

                    if(extraPaymentPrompt.equalsIgnoreCase("y") || extraPaymentPrompt.equalsIgnoreCase("yes")) {
                        double extraPayment = getDouble("Enter the extra monthly payment (or -1 to quit)", true, -1);

                        if (extraPayment == -1) {
                            break outer;
                        }
                        int months = loan.calculateEarlyPayoff(extraPayment);
                        System.out.print("Your early payoff would be " + months / 12 + " years and " + months % 12 + " months.\n");
                        continue outer;
                    } else {
                        System.out.println("**** Invalid input - Please enter y or q ****");
                    }
                }
            } else {
                System.out.println("**** Invalid input - Please enter y or q *****");
            }

        }

        // say goodbye to the user
        autoLoanGoodbye();
        pressEnterToContinue();
    }
}


