package com.smedialink.abakarmagomedov.neyro;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class MainActivity extends AppCompatActivity {

    private DrawableView drawable;
    private Button doneButton;
    private int[] allpixels;
    private Neuro[] mNeuros = new Neuro[33];
    private int positionOfFirstBlackPixel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawable = (DrawableView) findViewById(R.id.paintView);
        init();
        doneButton = (Button) findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allpixels = getAllPixels();
                positionOfFirstBlackPixel = findFirstExist(allpixels);
                
            }
        });
    }

    private int[] getAllPixels() {
        Bitmap bitmap = drawable.obtainBitmap();
        return new int[bitmap.getHeight() * bitmap.getWidth()];
    }

    private void init() {
        DrawableViewConfig config = new DrawableViewConfig();
        config.setStrokeColor(Color.BLACK);
        //config.setShowCanvasBounds(true); // If the view is bigger than canvas, with this the user will see the bounds (Recommended)
        config.setStrokeWidth(20.0f);
        config.setMinZoom(1.0f);
        config.setMaxZoom(3.0f);
        config.setCanvasHeight(1080);
        config.setCanvasWidth(1920);
        drawable.setConfig(config);
    }

    private int findFirstExist(int[] bitmap) {

        for (int i = 0; i < bitmap.length; i++) {
            if (bitmap[i] == Color.BLACK) {
                return i;
            }
        }
        return -1;
    }


    private boolean findSimilarMask(int[] bitmap, Neuro neuro, int positionOfFirstBlackPixel) {
        for (int i = 0; i < neuro.getMemory().size(); i++) {
            if (neuro.getMemory().get(i) == Color.BLACK && i - positionOfFirstBlackPixel != 0) {
                return true;
            }
        }
        return false;
    }

    private void makeStrafeIfNeed(int[] bitmap, int step) {
        if (step == 0) return;

        for (int i = 0; i < bitmap.length; i++) {
            if (bitmap[i] == Color.BLACK) {
                bitmap[i - step] = Color.BLACK;
                bitmap[i] = 0;
            }
        }
    }
}
