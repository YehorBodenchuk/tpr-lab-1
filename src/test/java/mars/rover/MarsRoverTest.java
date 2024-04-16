package mars.rover;

import mars.rover.enums.CardinalDirection;
import mars.rover.impls.RoverImpl;
import mars.rover.intarfaces.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

    @Test
    public void
    acceptance_test_1() {
        Rover rover = new RoverImpl(1, 2, CardinalDirection.getByLiteral('N'));

        String newPosition = rover.start("LMLMLMLMM");
        assertEquals("1 3 N", newPosition);
    }

    @Test
    public void
    acceptance_test_2() {
        Rover rover = new RoverImpl(3, 3, CardinalDirection.getByLiteral('E'));

        String newPosition = rover.start("MMRMMRMRRM");
        assertEquals("5 1 E", newPosition);
    }

}