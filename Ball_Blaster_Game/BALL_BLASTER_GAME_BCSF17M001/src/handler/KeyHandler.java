package handler;

import gamestates.PlayState;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private PlayState game;
    private boolean left = false;
    private boolean right = false;
    private boolean fire = false;
    private boolean pause = false;

    public KeyHandler(PlayState game) {
        this.game = game;
        game.addKeyListener(this);
    }

    synchronized public void performAction() {
        if (left == true) {
            game.player.left();
        }
        if (right == true) {
            game.player.right();
        }
        if (pause == true) {
            if (game.pause) {
                game.resume();
            } else {
                game.pause();
            }
        }
        if (fire == true) {
            game.firing.addBullet(game.player.xPos, game.player.yPos);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //do nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            fire = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_P) {
            pause = true;
        }
        performAction();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            fire = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_P) {
            pause = false;
        }
        performAction();
    }
}
