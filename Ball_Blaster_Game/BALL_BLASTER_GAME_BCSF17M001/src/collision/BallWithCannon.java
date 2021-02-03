package collision;

import gamestates.PlayState;
import entities.Balls;
import entities.Cannon;

public class BallWithCannon {

    private PlayState game;

    public BallWithCannon(PlayState game) {
        this.game = game;
    }

    public void isBallCollidesWithPlayer() {
        for (int i = 0; i < game.balls.balls.size(); i++) {
            if (collides(game.balls.balls.get(i), game.player) == true) {
                game.running = false;
            }
        }
    }

    private boolean collides(Balls.OneBall ball, Cannon player) {

        if (ball.xPos < player.xPos + player.width -15
                && ball.xPos + ball.size - ball.size/5 > player.xPos
                && ball.yPos < player.yPos + player.height -15
                && ball.yPos + ball.size - ball.size/5 > player.yPos) {
            return true;
        }
        return false;
    }

}
