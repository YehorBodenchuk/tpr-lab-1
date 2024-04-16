package mars.rover.impls;

import mars.rover.enums.CardinalDirection;
import mars.rover.enums.Direction;
import mars.rover.utils.Position;
import mars.rover.intarfaces.Rover;

import java.util.Objects;

public class RoverImpl implements Rover {

    private final Position position;
    private CardinalDirection direction;

    public RoverImpl(int positionX, int positionY, CardinalDirection direction) {
        position = new Position(positionX, positionY);
        this.direction = direction;
    }

    @Override
    public void moveForward() {
        direction.move(position);
    }

    @Override
    public void turn(Direction direction) {
        this.direction = this.direction.turn(direction);
    }

    @Override
    public String getPosition() {
        if (Objects.isNull(direction)) {
            return "Rover position cannot be found!";
        }

        return String.format("%d %d %s", position.getPositionX(), position.getPositionY(), direction.toString().charAt(0));
    }

    @Override
    public String start(String instructions) {
        char[] characters = instructions.toCharArray();

        for (char literal : characters) {
            switch (literal) {
                case 'L':
                    turn(Direction.LEFT);
                    break;
                case 'R':
                    turn(Direction.RIGHT);
                    break;
                case 'M':
                    moveForward();
                    break;
                default:
                    System.out.printf("This literal: {%s} is unsupported and will be ignored%n", literal);
                    break;
            }
        }

        return getPosition();
    }
}
