package bounds;

public class CannonBounds {

    private final int xLowerBound;
    private final int xUpperBound;

    public CannonBounds(int xLowerBound, int xUpperBound) {
        this.xLowerBound = xLowerBound;
        this.xUpperBound = xUpperBound;
    }

    public boolean canMoveLeft(double xPos) {
        return xPos > xLowerBound;
    }
    
     public boolean canMoveRight(double xPos) {
        return xPos < xUpperBound;
    }
}
