package com.example.bubbledraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class BubbleView extends androidx.appcompat.widget.AppCompatImageView implements View.OnTouchListener{
    private Random rand = new Random();
    private ArrayList<Bubble> bubbleList;
    private int size = 50;
    private int delay = 33;
    private Paint myPaint = new Paint();
    private Handler h = new Handler();

    public BubbleView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
        bubbleList = new ArrayList<Bubble>();
        //testBubbles();
        setOnTouchListener(this);
    }

    private Runnable r = new Runnable() {
        @Override
        public void run() {
            for (Bubble b : bubbleList)
                b.update();
            invalidate();
        }
    };
    protected void onDraw(Canvas canvas) {
        for (Bubble b: bubbleList)
            b.draw(canvas);
        h.postDelayed(r,delay);
    }

    public void testBubbles() {
        for(int n=0; n<100; n++) {
            int x = rand.nextInt(600);
            int y = rand.nextInt(600);
            int s = rand.nextInt(size) + size;
            bubbleList.add(new Bubble(x,y,s));
        }
        invalidate();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int fingercount = motionEvent.getPointerCount();
        if (fingercount == 1){
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int s = rand.nextInt(size) + size*2;
            int MAX_SPEED = 25;
            bubbleList.add(new Bubble(x,y,s,25,25));

        }else{
        for (int n = 0; n<fingercount; n++){
            int x = (int) motionEvent.getX(n);
            int y = (int) motionEvent.getY(n);
            int s = rand.nextInt(size) + size;
            bubbleList.add(new Bubble(x,y,s));
        }}
        return true;
    }


    private class Bubble{
    private int x;
    private int y;
    private int size;
    private int color;
    private int xspeed, yspeed;
    private final int MAX_SPEED = 25;

    public Bubble(int newX, int newY, int newSize) {
        x=(newX / newSize) * newSize + newSize/2;
        y=(newY / newSize) * newSize + newSize/2;
        size=newSize;
        color = Color.argb( rand.nextInt(256),//r
                rand.nextInt(256),//g
                rand.nextInt(256),//b
                rand.nextInt(256));//alpha
        xspeed = rand.nextInt(MAX_SPEED * 2 + 1) - MAX_SPEED;
        yspeed = rand.nextInt(MAX_SPEED * 2 + 1) - MAX_SPEED;
        if (xspeed == 0 && yspeed == 0)
            xspeed=yspeed=1;//does multiple assignment work this way?
    }
        public Bubble(int newX, int newY, int newSize, int newXspeed, int newYspeed) {
            x=(newX / newSize) * newSize + newSize/2;
            y=(newY / newSize) * newSize + newSize/2;
            size=newSize;
            color = Color.argb( rand.nextInt(256),//r
                    rand.nextInt(256),//g
                    rand.nextInt(256),//b
                    rand.nextInt(256));//alpha
            xspeed = newXspeed;
            yspeed = newYspeed;
            if (xspeed == 0 && yspeed == 0)
                xspeed=yspeed=1;//does multiple assignment work this way?
        }

    public void draw(Canvas canvas) {
        myPaint.setColor(color);
        canvas.drawOval(x - size/2, y- size/2, x + size/2, y + size/2, myPaint);

    }

    public void update() {
        x += xspeed;
        y += yspeed;
        if (x - size/2 <= 0 || x + size/2 >= getWidth())
            xspeed = -xspeed;
        if (y - size/2 <= 0 || y +size/2 >= getHeight())
            yspeed = -yspeed;
    }
}

}
