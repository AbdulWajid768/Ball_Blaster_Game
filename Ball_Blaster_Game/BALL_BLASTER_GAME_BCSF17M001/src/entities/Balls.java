package entities;

import bounds.BallBounds;
import gamestates.PlayState;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class Balls {

    public List<OneBall> balls = new ArrayList<>();
    private PlayState game;
    private BallBounds bounds;
    public int maxSize = 240;

    public Balls(PlayState game) {
        this.game = game;
        this.bounds = new BallBounds(0, game.width, 0, game.border);
    }

    public class OneBall {

        public double xPos;
        public double yPos;
        public int xSpeed = 3;
        public int ySpeed = 3;
        public int size;
        BufferedImage img;

        public OneBall(double xPos, double yPos, int size, int imgNo) {
            try {

                img = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//ball" + imgNo + ".png"));
            } catch (Exception e) {
                e.printStackTrace();

            }
            this.xPos = xPos;
            this.yPos = yPos;
            this.size = size;
        }
    }

    public void update() {
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).xPos = balls.get(i).xPos + balls.get(i).xSpeed;
            balls.get(i).yPos = balls.get(i).yPos + balls.get(i).ySpeed;
            bounds.checkBounds(balls.get(i), balls.get(i).size);
        }
    }

    public void render(Graphics2D graphics2D) {
        try {
            if (graphics2D != null) {
                for (int i = 0; i < balls.size(); i++) {
                    graphics2D.drawImage(balls.get(i).img, (int) balls.get(i).xPos, (int) balls.get(i).yPos, balls.get(i).size, balls.get(i).size, null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBall(double xPos, double yPos, int size, int imgNo) {
        balls.add(new OneBall(xPos, yPos, size, imgNo));
    }
}
