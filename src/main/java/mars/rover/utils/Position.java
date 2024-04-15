package mars.rover.utils;

public class Position {
    private int positionX;
    private int positionY;

    public Position(int x, int y) {
        positionX = x;
        positionY = y;
    }

    public void setPositionX(int x) { positionX = x; }
    public void setPositionY(int y) { positionY = y; }
    public int getPositionX() { return positionX; }
    public int getPositionY() { return positionY; }
}
