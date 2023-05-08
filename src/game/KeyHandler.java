package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
    }

    //8 irányú mozgás miatt a Player mozgás switch-el működik :(
    String lastDirection = "down";
    public Boolean keyDown = false;
    public String direction() {
        if (upPressed && !rightPressed && !leftPressed && !downPressed) {
            keyDown = true;
            lastDirection = "up";
            return "up";
        } else if (upPressed && rightPressed && !leftPressed && !downPressed) {
            keyDown = true;
            lastDirection = "upRight";
            return "upRight";
        } else if (upPressed && !rightPressed && leftPressed && !downPressed) {
            keyDown = true;
            lastDirection = "upLeft";
            return "upLeft";
        } else if (upPressed && rightPressed && leftPressed && !downPressed) {
            keyDown = true;
            lastDirection = "up";
            return "up";
        } else if (upPressed && !rightPressed && !leftPressed && downPressed) {
            keyDown = false;
            return "null";
        } else if (!upPressed && !rightPressed && !leftPressed && !downPressed) {
            keyDown = false;
            return lastDirection;
        } else if (!upPressed && !rightPressed && !leftPressed && downPressed) {
            keyDown = true;
            lastDirection = "down";
            return "down";
        } else if (!upPressed && rightPressed && !leftPressed && downPressed) {
            keyDown = true;
            lastDirection = "downRight";
            return "downRight";
        } else if (!upPressed && !rightPressed && leftPressed && downPressed) {
            keyDown = true;
            lastDirection = "downLeft";
            return "downLeft";
        } else if (!upPressed && rightPressed && leftPressed && downPressed) {
            keyDown = true;
            lastDirection = "down";
            return "down";
        } else if (upPressed && !rightPressed && !leftPressed && downPressed) {
            keyDown = false;
            return "null";
        } else if (!upPressed && rightPressed && !leftPressed && !downPressed) {
            keyDown = true;
            lastDirection = "right";
            return "right";
        } else if (!upPressed && !rightPressed && leftPressed && !downPressed) {
            keyDown = true;
            lastDirection = "left";
            return "left";
        } else {
            keyDown = false;
            return "null";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

}
