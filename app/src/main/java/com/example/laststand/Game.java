package com.example.laststand;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

/**
 * Game helps to manage all objects in the game and is responsible for updating all States and render all objects to screen
 */
class Game extends SurfaceView implements SurfaceHolder.Callback {
    private GameLoop gameLoop;
    private Context context;

    public Game(Context context) {
        super(context);
        // Get Surface holder and add callback
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        this.context = context;
        gameLoop = new GameLoop(this, surfaceHolder); // Initialize gameLoop
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        // Code to execute when the surface is created
    gameLoop.startLoop();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        // Code to handle surface changes
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        // Code to handle surface destruction
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawUPS(canvas);
        drawFPS(canvas);
    }

    public void drawUPS(Canvas canvas) {
        if (gameLoop != null) {
            String averageUPS = Double.toString(gameLoop.getAverageUPS());
            Paint paint = new Paint();
            int color = ContextCompat.getColor(getContext(), R.color.gold);
            paint.setColor(color);
            paint.setTextSize(50);

            canvas.drawText("UPS: " + averageUPS, 100, 100, paint);
        }
    }

    public void drawFPS(Canvas canvas) {
        if (gameLoop != null) {
            String averageFPS = Double.toString(gameLoop.getAverageFPS()); // Assuming getAverageFPS() exists
            Paint paint = new Paint();
            int color = ContextCompat.getColor(getContext(), R.color.gold);
            paint.setColor(color);
            paint.setTextSize(50);

            canvas.drawText("FPS: " + averageFPS, 100, 200, paint);
        }
    }

    public void update() {
    }
}