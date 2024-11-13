package com.example.laststand;

import android.animation.Animator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

/**
 * MainActivity is the entry point to our application.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //set content view to game, so that object in the Game class can be rendered to the screen
        setContentView(new Game(this));
    }
}
