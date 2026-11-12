package edu.kirkwood.controller.wren;

import edu.kirkwood.view.Messages;
import edu.kirkwood.view.UIUtility;
import edu.kirkwood.view.UserInput;
import edu.kirkwood.view.Helpers;
import edu.kirkwood.model.wren.Coordinate;

public class CoordinateCalculator {

    public static void start(){
        boolean done = false;
        Messages.coordinateGreet();

        while (!done) {

            double coordOneX = UserInput.getDouble(
                    "Please enter the X value of the first coordinate: ", true);
            double coordOneY = UserInput.getDouble(
                    "Please enter the Y value of the first coordinate: ", true);
            double coordTwoX = UserInput.getDouble(
                    "Please enter the X value of the second coordinate: ", true);
            double coordTwoY = UserInput.getDouble(
                    "Please enter the Y value of the second coordinate: ", true);

            Coordinate coordOne = new Coordinate(coordOneX, coordOneY);
            Coordinate coordTwo = new Coordinate(coordTwoX, coordTwoY);

            double distance = coordOne.calculateDistanceBetween(coordTwo);
            double slope = coordOne.calculateSlope(coordTwo);

            UIUtility.displayMessage("The distance between these points is: " + distance);
            UIUtility.displayMessage("The slope of the line between these two points is: " + slope);

            String userChoice = UserInput.getString("Would you like to return to main menu? (Y/N): ", true);
            if (userChoice.toUpperCase().equals("Y")){
                done = true;
            }

        }

        Messages.coordinateGoodbye();

    }
}
