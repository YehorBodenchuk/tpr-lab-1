package mars.rover.intarfaces;

import mars.rover.enums.Direction;

public interface Rover {

    void moveForward();

    void turn(Direction direction);

    String getPosition();

    String start(String instructions);
}
