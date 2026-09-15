package edu.kirkwood.view;

import static edu.kirkwood.view.UIUtility.printMenu;
import static edu.kirkwood.view.UserInput.getInt;

public class MainMenu {
    /**
     * Displays the main menu and processes selections until the user quits.
     */
    public static void show() {
        String[] menuItems = {"Marc's Fraction Calculator", "YOUR NAME AND CALCULATOR NAME HERE", "Quit"};
        while(true) {
            printMenu("Main Menu", menuItems);
            int choice = getInt("Choose an option", true, 1, menuItems.length);
            switch(choice) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    return;
            }
        }
    }
}
