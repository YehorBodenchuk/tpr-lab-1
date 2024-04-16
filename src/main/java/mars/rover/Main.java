package mars.rover;

import mars.rover.enums.CardinalDirection;
import mars.rover.impls.RoverImpl;
import mars.rover.intarfaces.Rover;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer xPosition = null;
        Integer yPosition = null;

        while (Objects.isNull(xPosition)) {
            try {
                System.out.println("Please enter the rover x position:");
                xPosition = scanner.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("There was an exception in parsing your input. Please try again.");
                scanner.next();
            }
        }

        while (Objects.isNull(yPosition)) {
            try {
                System.out.println("Please enter the rover y position:");
                yPosition = scanner.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("There was an exception in parsing your input. Please try again.");
                scanner.next();
            }
        }

        System.out.println("Please enter rover cardinal direction:");
        String input = scanner.next();
        char direction = input.charAt(0);

        while (CardinalDirection.isLiteralIncorrect(direction)) {
            System.out.println("Invalid cardinal direction. Please try again.");
            input = scanner.next();
            direction = input.charAt(0);
        }

        System.out.println("Please enter rover instructions");
        String instructions = scanner.next();

        Rover rover = new RoverImpl(xPosition, yPosition, CardinalDirection.getByLiteral(direction));
        String roverPosition = rover.start(instructions);

        System.out.println(roverPosition);
    }
}
