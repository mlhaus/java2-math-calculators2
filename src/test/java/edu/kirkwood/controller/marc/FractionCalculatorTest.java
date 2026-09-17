package edu.kirkwood.controller.marc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionCalculatorTest {

    @Test
    @DisplayName("Test splitCalculation with addition operator")
    void splitCalculationWithAddition() {
        // Arrange
        String input = "1/2 + 3/4";
        String[] expected = {"1/2", "+", "3/4"};
        // Act
        String[] actual = FractionCalculator.splitCalculation(input);
        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Test splitCalculation with subtraction operator and mixed numbers")
    void splitCalculationWithSubtractionAndMixedNumbers() {
        // Arrange
        String input = "3 1/4 - 1/2";
        String[] expected = {"3 1/4", "-", "1/2"};
        // Act
        String[] actual = FractionCalculator.splitCalculation(input);
        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Test splitCalculation with multiplication and negative numbers")
    void splitCalculationWithMultiplicationAndNegatives() {
        // Arrange
        String input = "-5 * -2 1/3";
        String[] expected = {"-5", "*", "-2 1/3"};
        // Act
        String[] actual = FractionCalculator.splitCalculation(input);
        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Test splitCalculation with division operator")
    void splitCalculationWithDivision() {
        // Arrange
        String input = "10/3 / 5";
        String[] expected = {"10/3", "/", "5"};
        // Act
        String[] actual = FractionCalculator.splitCalculation(input);
        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Test splitCalculation with extra spaces in input")
    void splitCalculationWithExtraSpaces() {
        // Arrange
        String input = "  1/2   +   3/4  ";
        String[] expected = {"1/2", "+", "3/4"};

        // Act
        String[] actual = FractionCalculator.splitCalculation(input);

        // Assert
        assertArrayEquals(expected, actual);
    }


    @Test
    @DisplayName("Test splitCalculation with no spaces around operator should throw exception")
    void splitCalculationWithNoSpacesAroundOperator() {
        // Arrange
        String input = "1/2+3/4";
        // Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> FractionCalculator.splitCalculation(input));

        // Arrange
        String expectedMessage = FractionCalculator.INVALID_FRACTION_MESSAGE;
        // Act
        String actualMessage = exception.getMessage();
        // Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Test splitCalculation with unknown operator should throw exception")
    void splitCalculationWithUnknownOperator() {
        // Arrange
        String input = "1/2 ^ 3/4";

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            FractionCalculator.splitCalculation(input);
        });

        // Arrange
        String expectedMessage = FractionCalculator.INVALID_FRACTION_MESSAGE;
        // Act
        String actualMessage = exception.getMessage();
        // Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Test splitCalculation with missing first fraction should throw exception")
    void splitCalculationWithMissingFirstFraction() {
        // Arrange
        String input = " + 3/4";
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FractionCalculator.splitCalculation(input);
        });
        String expectedMessage = FractionCalculator.INVALID_FIRST_FRACTION_MESSAGE;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Test splitCalculation with missing second fraction should throw exception")
    void splitCalculationWithMissingSecondFraction() {
        // Arrange
        String input = "1/2 + ";
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FractionCalculator.splitCalculation(input);
        });
        // Arrange
        String expectedMessage = FractionCalculator.INVALID_SECOND_FRACTION_MESSAGE;
        // Act
        String actualMessage = exception.getMessage();
        // Assert
        assertEquals(expectedMessage, actualMessage);
    }



}