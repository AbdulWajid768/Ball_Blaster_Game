package entities;

import gamestates.PlayState;
import java.awt.Graphics2D;
import bounds.CannonBounds;
import handler.DBHandler;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import javax.imageio.ImageIO;

public class Cannon {

    private PlayState game;
    private CannonBounds bounds;
    public double xPos = 100;
    public int xSpeed = 15;
    public int ySpeed = 10;
    public int height = 60;
    public int width = 60;
    public double yPos;
    public int imgNo = 1;
    private BufferedImage img1;
    private BufferedImage img2;

    public Cannon(PlayState game) {
        this.game = game;
        bounds = new CannonBounds(0, game.width - width);
        yPos = game.border - height;
        try {
            ResultSet temp = DBHandler.stmt.executeQuery("select * from playerstats");
            temp.next();
            img1 = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//" + temp.getString("currentcannon") + ".1.png"));
            img2 = ImageIO.read(new File(new File(".").getAbsoluteFile() + "//src//res//" + temp.getString("currentcannon") + ".2.png"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void render(Graphics2D graphics2D) {
        if (graphics2D != null) {
            if (imgNo == 1) {
                graphics2D.drawImage(img1, (int) xPos, (int) yPos, height, width, null);
            } else {
                graphics2D.drawImage(img2, (int) xPos, (int) yPos, height, width, null);
            }

        }
    }

    public void left() {
        if (bounds.canMoveLeft(xPos)) {
            xPos = xPos - xSpeed;
        }
        if (imgNo == 1) {
            imgNo = 2;
        } else {
            imgNo = 1;
        }
    }

    public void right() {
        if (bounds.canMoveRight(xPos)) {
            xPos = xPos + xSpeed;
        }
        if (imgNo == 1) {
            imgNo = 2;
        } else {
            imgNo = 1;
        }
    }
}
