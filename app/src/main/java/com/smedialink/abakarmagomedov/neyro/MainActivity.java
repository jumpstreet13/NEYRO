package com.smedialink.abakarmagomedov.neyro;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class MainActivity extends AppCompatActivity {

    private DrawableView drawable;
    private Button doneButton;

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
                Bitmap bitmap = drawable.obtainBitmap();
                int [] allpixels = new int [bitmap.getHeight()*bitmap.getWidth()];
                for(int i = 0; i < allpixels.length; i++){
                        Log.d("Color", "Pixel " + i + " Is " + allpixels[i]);
                }
            }
        });
    }


    public void init(){
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
}
