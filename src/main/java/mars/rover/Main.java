package mars.rover;

import mars.rover.enums.CardinalDirection;
import mars.rover.enums.Direction;
import mars.rover.impls.RoverImpl;
import mars.rover.intarfaces.Rover;

public class Main {

    public static String start(int x, int y, char direction, String instructions) {
        Rover rover = new RoverImpl(x, y, CardinalDirection.getByLiteral(direction));
        char[] characters = instructions.toCharArray();

        for (char literal : characters) {
            switch (literal) {
                case 'L':
                    rover.turn(Direction.LEFT);
                    break;
                case 'R':
                    rover.turn(Direction.RIGHT);
                    break;
                case 'M':
                    rover.moveForward();
                    break;
                default:
                    System.out.printf("This literal: {%s} is unsupported and will be ignored%n", literal);
                    break;
            }
        }

        String res = rover.getPosition();
        System.out.println(res);
        return res;
    }
}
