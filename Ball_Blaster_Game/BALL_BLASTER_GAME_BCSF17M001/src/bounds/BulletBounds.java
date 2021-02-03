package bounds;

public class BulletBounds {
    
    private final int xLowerBound;
    private final int xUpperBound;
    private final int yLowerBound;

    public BulletBounds(int xLowerBound, int xUpperBound, int yLowerBound) {
        this.xLowerBound = xLowerBound;
        this.xUpperBound = xUpperBound;
        this.yLowerBound = yLowerBound;
    }
    
     public boolean canMoveLeft(double xPos) {
        return xPos > xLowerBound;
    }
    
    public boolean canMoveRight(double xPos) {
        return xPos < xUpperBound;
    }
    
    public boolean canMoveUp(double yPos) {
        return yPos > yLowerBound;
    }
}
