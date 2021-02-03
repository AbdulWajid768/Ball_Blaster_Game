package entities;

import bounds.BulletBounds;
import gamestates.PlayState;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class Firing {

    public List<Bullet> bullets = new ArrayList<>();
    private PlayState game;
    private BulletBounds bounds;
    public int width = 10;
    public int height = 20;
    private BufferedImage img;

    public Firing(PlayState game) {
        this.game = game;
        this.bounds = new BulletBounds(0, game.width - width, 0);
        try {
            img = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//bullet.png"));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public class Bullet {

        public double xPos;
        public double yPos;
        int xSpeed = 5;
        int ySpeed = 5;

        public Bullet(double xPos, double yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
        }

    }

    public void update() {
        for (int i = 0; i < bullets.size(); i++) {
            if (bounds.canMoveUp(bullets.get(i).yPos)) {
                bullets.get(i).yPos -= bullets.get(i).ySpeed;
            } else {
                bullets.remove(i);
            }
        }

    }

    public void render(Graphics2D graphics2D) {
        if (graphics2D != null) {
            for (int i = 0; i < bullets.size(); i++) {
//                graphics2D.setColor(Color.MAGENTA);
//                graphics2D.fillRect((int) bullets.get(i).xPos, (int) bullets.get(i).yPos, width, height);

                graphics2D.drawImage(img, (int) bullets.get(i).xPos, (int) bullets.get(i).yPos, width, height, null);

            }
        }
    }

    public void addBullet(double xPos, double yPos) {
        bullets.add(new Bullet(xPos + 25, yPos));
    }

}
