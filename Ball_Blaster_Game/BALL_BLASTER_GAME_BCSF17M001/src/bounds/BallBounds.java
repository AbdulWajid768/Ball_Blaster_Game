package bounds;

import entities.Balls.OneBall;

public class BallBounds {

    private final int xLowerBound;
    private final int xUpperBound;
    private final int yLowerBound;
    private final int yUpperBound;

    public BallBounds(int xLowerBound, int xUpperBound, int yLowerBound, int yUpperBound) {
        this.xLowerBound = xLowerBound;
        this.xUpperBound = xUpperBound;
        this.yLowerBound = yLowerBound;
        this.yUpperBound = yUpperBound;
    }

    public boolean canMoveLeft(double xPos) {
        return xPos > xLowerBound;
    }

    public boolean canMoveRight(double xPos, int size) {
        return xPos + size < xUpperBound;
    }

    public boolean canMoveUp(double yPos) {
        return yPos > yLowerBound;
    }

    public boolean canMoveDown(double yPos, int size) {
        return yPos + size < yUpperBound;
    }

    public void checkBounds(OneBall ball, int size) {
        if (!canMoveLeft(ball.xPos) || !canMoveRight(ball.xPos, size)) {
            ball.xSpeed = -ball.xSpeed;
        }
        if (!canMoveUp(ball.yPos) || !canMoveDown(ball.yPos, size)) {
            ball.ySpeed = -ball.ySpeed;

        }
    }
}
