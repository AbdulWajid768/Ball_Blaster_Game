package collision;

import gamestates.PlayState;
import entities.Balls.OneBall;
import entities.Firing.Bullet;
import java.util.Random;

public class BallWithBullet {

    private PlayState game;
    private Random rand;

    public BallWithBullet(PlayState game) {
        this.game = game;
    }

    public void isBallCollidesWithBullet() {
        int size;
        double xPos;
        double yPos;
        rand = new Random();
        int no = 1;
        for (int i = 0; i < game.firing.bullets.size(); i++) {
            for (int j = 0; j < game.balls.balls.size(); j++) {

                if (i < game.firing.bullets.size() && j < game.balls.balls.size()) {
                    if (collides(game.balls.balls.get(j), game.firing.bullets.get(i), game.firing.width, game.firing.height) == true) {
                        game.score = game.score + 10;
                        size = game.balls.balls.get(j).size;
                        xPos = game.firing.bullets.get(i).xPos;
                        yPos = game.firing.bullets.get(i).yPos;
                        if (game.firing.bullets.get(i).yPos + game.balls.balls.get(j).size > game.border) {
                            yPos = game.firing.bullets.get(i).yPos - game.balls.balls.get(j).size;
                        }
                        game.balls.balls.remove(j);
                        game.firing.bullets.remove(i);
                        if (size > game.balls.maxSize / 8) {
                            no = rand.nextInt(4) + 1;
                            game.balls.addBall(xPos, yPos, size / 2, no);

                            game.balls.balls.get(game.balls.balls.size() - 1).xSpeed = -game.balls.balls.get(game.balls.balls.size() - 1).xSpeed;

                            game.balls.addBall(xPos, yPos, size / 2, no);
                        }
                    }
                }
            }
        }
    }

    private boolean collides(OneBall ball, Bullet bullet, int bulletWidth, int bulletHeight) {

        if (ball.xPos < bullet.xPos + bulletWidth
                && ball.xPos + ball.size > bullet.xPos
                && ball.yPos < bullet.yPos + bulletHeight
                && ball.yPos + ball.size > bullet.yPos) {
            return true;
        }
        return false;
    }
}
