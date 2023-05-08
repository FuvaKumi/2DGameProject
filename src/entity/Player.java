package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import game.GamePanel;
import game.KeyHandler;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - gp.tileSize / 2;
        screenY = gp.screenHeight/2 - gp.tileSize / 2;

        setDefaultValues();
        getPlayerImage();

        direction = "front";
    }

    public void setDefaultValues() {
        worldX = 7 * gp.tileSize;
        worldY = 6 * gp.tileSize;
        speed = 2;
    }

    public void getPlayerImage(){
        try {
            System.out.println("Loading Player sprites...");

            //Szemből
            /*Idle */
            idleFront0 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerIdleFront0.png "));
            idleFront1 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerIdleFront1.png "));
            /*Mozgás */
            runFront0 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerRunFront0.png "));
            runFront1 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerRunFront1.png "));

            //Negyed balról
            /*Idle */
            idleQuarterLeft0 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerIdleQuarterLeft0.png "));
            idleQuarterLeft1 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerIdleQuarterLeft1.png "));
            /*Mozgás */
            runQuarterLeft0 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerRunQuarterLeft0.png "));
            runQuarterLeft1 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerRunQuarterLeft1.png "));

            //Balról
            /*Idle */
            idleLeft0 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerIdleLeft0.png "));
            idleLeft1 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerIdleLeft1.png "));
            /*Mozgás */
            runLeft0 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerRunLeft0.png "));
            runLeft1 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerRunLeft1.png "));

            //Háromnegyed balról
            /*Idle */
            idleThreeQuartersLeft0 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerIdleThreeQuartersLeft0.png "));
            idleThreeQuartersLeft1 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerIdleThreeQuartersLeft1.png "));
            /*Mozgás */
            runThreeQuartersLeft0 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerRunThreeQuartersLeft0.png "));
            runThreeQuartersLeft1 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerRunThreeQuartersLeft1.png "));

            //Hátulról
            /*Idle */
            idleBack0 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerIdleBack0.png "));
            idleBack1 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerIdleBack1.png "));
            /*Mozgás */
            runBack0 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerRunBack0.png "));
            runBack1 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerRunBack1.png "));

            //Háromnegyed jobbról
            /*Idle */
            idleThreeQuartersRight0 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerIdleThreeQuartersRight0.png "));
            idleThreeQuartersRight1 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerIdleThreeQuartersRight1.png "));
            /*Mozgás */
            runThreeQuartersRight0 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerRunThreeQuartersRight0.png "));
            runThreeQuartersRight1 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerRunThreeQuartersRight1.png "));

            //Jobbról
            /*Idle */
            idleRight0 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerIdleRight0.png "));
            idleRight1 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerIdleRight1.png "));
            /*Mozgás */
            runRight0 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerRunRight0.png "));
            runRight1 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerRunRight1.png "));

            //Negyed jobbról
            /*Idle */
            idleQuarterRight0 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerIdleQuarterRight0.png "));
            idleQuarterRight1 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerIdleQuarterRight1.png "));
            /*Mozgás */
            runQuarterRight0 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerRunQuarterRight0.png "));
            runQuarterRight1 = ImageIO.read(getClass().getResourceAsStream("/playerSprites/playerRunQuarterRight1.png "));
            

            System.out.println("Player sprites loaded!\n");
        } catch (Exception e) {
            System.out.println("Error loading Player sprites:");
            e.printStackTrace();
        }
    }

    public void update() {
        //Player irányítás
        switch(keyH.direction()) {
            case "up":
                if (keyH.keyDown) {
                    worldY -= speed;
                    break;
                }
            case "down":
                if (keyH.keyDown) {
                    worldY += speed;
                    break;
                }
            case "left":
                if (keyH.keyDown) {
                    worldX -= speed;
                    break;
                }
            case "right":
                if (keyH.keyDown) {
                    worldX += speed;
                    break;
                }
            case "upLeft":
                if (keyH.keyDown) {
                    worldY -= speed*0.75;
                    worldX -= speed*0.75;
                    break;
                }
            case "upRight":
                if (keyH.keyDown) {
                    worldY -= speed*0.75;
                    worldX += speed*0.75;
                    break;
                }
            case "downLeft":
                if (keyH.keyDown) {
                    worldY += speed*0.75;
                    worldX -= speed*0.75;
                    break;
                }
            case "downRight":
                if (keyH.keyDown) {
                    worldY += speed*0.75;
                    worldX += speed*0.75;
                    break;
                }
        }

        //Animáció kalkulálás
        spriteCounter++;
        if (spriteCounter > 10) {
            if (spriteNum == 0) {
                spriteNum = 1;
            }
            else if (spriteNum == 1) {
                spriteNum = 0;
            }
            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2){
        
        BufferedImage image = null;

        //Idle animációk
        if (!keyH.keyDown) {
            switch(keyH.direction()) {
                case "up":
                    if (spriteNum == 0) {
                        image = idleBack0;
                    }
                    if (spriteNum == 1) {
                        image = idleBack1;
                    }
                    break;
                case "down":
                    if (spriteNum == 0) {
                        image = idleFront0;
                    }
                    if (spriteNum == 1) {
                        image = idleFront1;
                    }
                    break;
                case "left":
                    if (spriteNum == 0) {
                        image = idleLeft0;
                    }
                    if (spriteNum == 1) {
                        image = idleLeft1;
                    }
                    break;
                case "right":
                    if (spriteNum == 0) {
                        image = idleRight0;
                    }
                    if (spriteNum == 1) {
                        image = idleRight1;
                    }
                    break;
                case "upLeft":
                    if (spriteNum == 0) {
                        image = idleThreeQuartersLeft0;
                    }
                    if (spriteNum == 1) {
                        image = idleThreeQuartersLeft1;
                    }
                    break;
                case "upRight":
                    if (spriteNum == 0) {
                        image = idleThreeQuartersRight0;
                    }
                    if (spriteNum == 1) {
                        image = idleThreeQuartersRight1;
                    }
                    break;
                case "downLeft":
                    if (spriteNum == 0) {
                        image = idleQuarterLeft0;
                    }
                    if (spriteNum == 1) {
                        image = idleQuarterLeft1;
                    }
                    break;
                case "downRight":
                    if (spriteNum == 0) {
                        image = idleQuarterRight0;
                    }
                    if (spriteNum == 1) {
                        image = idleQuarterRight1;
                    }
                    break;
                case "null":
                    if (spriteNum == 0) {
                        image = idleFront0;
                    }
                    if (spriteNum == 1) {
                        image = idleFront1;
                    }
                    break;
            }
        }
        //Mozgás animációk
        else {
            switch(keyH.direction()) {
                case "up":
                    if (spriteNum == 0) {
                        image = runBack0;
                    }
                    if (spriteNum == 1) {
                        image = runBack1;
                    }
                    break;
                case "down":
                    if (spriteNum == 0) {
                        image = runFront0;
                    }
                    if (spriteNum == 1) {
                        image = runFront1;
                    }
                    break;
                case "left":
                    if (spriteNum == 0) {
                        image = runLeft0;
                    }
                    if (spriteNum == 1) {
                        image = runLeft1;
                    }
                    break;
                case "right":
                    if (spriteNum == 0) {
                        image = runRight0;
                    }
                    if (spriteNum == 1) {
                        image = runRight1;
                    }
                    break;
                case "upLeft":
                    if (spriteNum == 0) {
                        image = runThreeQuartersLeft0;
                    }
                    if (spriteNum == 1) {
                        image = runThreeQuartersLeft1;
                    }
                    break;
                case "upRight":
                    if (spriteNum == 0) {
                        image = runThreeQuartersRight0;
                    }
                    if (spriteNum == 1) {
                        image = runThreeQuartersRight1;
                    }
                    break;
                case "downLeft":
                    if (spriteNum == 0) {
                        image = runQuarterLeft0;
                    }
                    if (spriteNum == 1) {
                        image = runQuarterLeft1;
                    }
                    break;
                case "downRight":
                    if (spriteNum == 0) {
                        image = runQuarterRight0;
                    }
                    if (spriteNum == 1) {
                        image = runQuarterRight1;
                    }
                    break;
                case "null":
                    if (spriteNum == 0) {
                        image = runFront0;
                    }
                    if (spriteNum == 1) {
                        image = runFront1;
                    }
                    break;
            }
        }

        //Kirajzolás
        g2.drawImage(image, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);
    }
}
