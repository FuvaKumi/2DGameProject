package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public double worldX, worldY;
    public double speed;

    //Idle sprite-ok
    public BufferedImage idleFront0, idleFront1, idleQuarterLeft0, idleQuarterLeft1, idleLeft0, idleLeft1, idleThreeQuartersLeft0, idleThreeQuartersLeft1, idleBack0, idleBack1, idleThreeQuartersRight0, idleThreeQuartersRight1, idleRight0, idleRight1, idleQuarterRight0, idleQuarterRight1;

    //Mozgás sprite-ok
    public BufferedImage runFront0, runFront1, runQuarterLeft0, runQuarterLeft1, runLeft0, runLeft1, runThreeQuartersLeft0, runThreeQuartersLeft1, runBack0, runBack1, runThreeQuartersRight0, runThreeQuartersRight1, runRight0, runRight1, runQuarterRight0, runQuarterRight1;

    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 0;
}
