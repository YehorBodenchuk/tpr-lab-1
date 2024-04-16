package mars.rover.enums;

import mars.rover.utils.Position;

public enum CardinalDirection {
    NORTH {
        @Override
        public void move(Position position) {
            position.setPositionY(position.getPositionY() + 1);
        }

        @Override
        public CardinalDirection turn(Direction direction) {
            if (direction.equals(Direction.LEFT)) {
                return CardinalDirection.WEST;
            }

            return CardinalDirection.EAST;
        }
    },
    SOUTH {
        @Override
        public void move(Position position) {
            position.setPositionY(position.getPositionY() - 1);
        }

        @Override
        public CardinalDirection turn(Direction direction) {
            if (direction.equals(Direction.LEFT)) {
                return CardinalDirection.EAST;
            }

            return CardinalDirection.WEST;
        }
    },
    EAST {
        @Override
        public void move(Position position) {
            position.setPositionX(position.getPositionX() + 1);
        }

        @Override
        public CardinalDirection turn(Direction direction) {
            if (direction.equals(Direction.LEFT)) {
                return CardinalDirection.NORTH;
            }

            return CardinalDirection.SOUTH;
        }
    },
    WEST {
        @Override
        public void move(Position position) {
            position.setPositionX(position.getPositionX() - 1);
        }

        @Override
        public CardinalDirection turn(Direction direction) {
            if (direction.equals(Direction.LEFT)) {
                return CardinalDirection.SOUTH;
            }

            return CardinalDirection.NORTH;
        }
    };

    abstract public void move(Position position);
    abstract public CardinalDirection turn(Direction direction);

    public static CardinalDirection getByLiteral(char letter) {
        for (CardinalDirection direction : CardinalDirection.values()) {
            if (direction.toString().charAt(0) == letter) {
                return direction;
            }
        }
        return null;
    }

    public static boolean isLiteralIncorrect(char literal) {
        return literal != 'N' && literal != 'E' && literal != 'W' && literal != 'S';
    }
}
