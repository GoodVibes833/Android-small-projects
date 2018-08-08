package ca.hjtaki.twodimgraghic;


import android.graphics.Paint;

import java.util.Random;

public class RainDrop{
    private float dropX = 30;
    private float dropY = 30;
    private Paint paint;
    private static float radius = 25;
    private static float velocityY = 10;

    public RainDrop(float dropX, float dropY, float radius) {
        this.dropX = dropX;
        this.dropY = dropY;
        this.radius = radius;
        Random rand = new Random();
        int randomR = rand.nextInt(255);
        int randomG = rand.nextInt(255);
        int randomB = rand.nextInt(255);
        Paint randomcolor = new Paint();
        randomcolor.setARGB(255,randomR,randomG,randomB);
        this.paint = randomcolor;
    }

    public Paint getPaint() {
        return paint;
    }

    public float getDropX() {
        return dropX;
    }

    public void setDropX(float dropX) {
        this.dropX = dropX;
    }

    public float getDropY() {
        return dropY;
    }

    public void setDropY(float dropY) {
        this.dropY = dropY;
    }

    public static float getRadius() {
        return radius;
    }

    public static void setRadius(float radius) {
        RainDrop.radius = radius;
    }

    public static float getVelocityY() {
        return velocityY;
    }

    public static void setVelocityY(float velocityY) {
        RainDrop.velocityY = velocityY;
    }
}
