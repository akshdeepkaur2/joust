package com.akshdeep.joust;


import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Animation {
    private Bitmap[] frames;
    private int currentFrame;
    private long startTime;
    private long delay;
    private boolean playedOnce;

    public void setFrames(Bitmap[] frames) {
        this.frames = frames;
        currentFrame = 0;
        startTime = System.nanoTime();
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public void update() {
        long elapsed = (System.nanoTime() - startTime) / 1000000;

        if (elapsed > delay) {
            currentFrame++;
            startTime = System.nanoTime();
        }

        if (currentFrame == frames.length) {
            currentFrame = 0;
            playedOnce = true;
        }
    }

    public Bitmap getImage() {
        return frames[currentFrame];
    }

    public boolean isPlayedOnce() {
        return playedOnce;
    }

    public static class TopBorder extends  GameObject{
        private Bitmap resource;

        public TopBorder(Bitmap res, int x, int y, int h) {
            super.height = h;
            super.width = 20;
            super.x = x;
            super.y = y;
            super.dx = GamePanel.MOVESPEED;
            this.resource = Bitmap.createBitmap(res, 0, 0, width, height);
        }

        public void update() {
            x += dx;
        }

        public void draw(Canvas canvas) {
            try {
                canvas.drawBitmap(resource, x, y, null);

            } catch (Exception e) {
            }
        }

    }
}

