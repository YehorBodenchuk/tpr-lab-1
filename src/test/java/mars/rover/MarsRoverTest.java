package mars.rover;

import mars.rover.enums.CardinalDirection;
import mars.rover.enums.Direction;
import mars.rover.impls.RoverImpl;
import mars.rover.intarfaces.Rover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MarsRoverTest {

    private Rover rover;

    @BeforeEach
    public void setUp() {
        rover = new RoverImpl(1, 2, CardinalDirection.NORTH);
    }

    @Test
    public void testMoveForward() {
        rover.moveForward();

        assertEquals("1 3 N", rover.getPosition());
    }

    @Test
    public void testTurnLeft() {
        rover.turn(Direction.LEFT);

        assertEquals("1 2 W", rover.getPosition());
    }

    @Test
    public void testTurnRight() {
        rover.turn(Direction.RIGHT);

        assertEquals("1 2 E", rover.getPosition());
    }

    @Test
    public void testGetPosition() {
        assertEquals("1 2 N", rover.getPosition());
    }

    @Test
    public void testStart() {
        String instructions = "LMLMLMLMM";

        String position = rover.start(instructions);
        assertEquals("1 3 N", position);
    }
}