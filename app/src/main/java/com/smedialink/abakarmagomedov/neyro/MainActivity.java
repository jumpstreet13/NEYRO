package com.smedialink.abakarmagomedov.neyro;

import android.graphics.Bitmap;
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
                int[] pixels = new int[drawable.obtainBitmap().getByteCount()];
                bitmap.getPixels(pixels,0,0,0,bitmap.getByteCount(), bitmap.getWidth(), bitmap.getHeight());
                for(int i = 0; i < pixels.length; i++){
                    Log.d("INFO", "Pixel " + i + "--- " + pixels[i] + " ---");
                }
            }
        });

    }


    public void init(){
        DrawableViewConfig config = new DrawableViewConfig();
        config.setStrokeColor(getResources().getColor(android.R.color.black));
        config.setShowCanvasBounds(true); // If the view is bigger than canvas, with this the user will see the bounds (Recommended)
        config.setStrokeWidth(20.0f);
        config.setMinZoom(1.0f);
        config.setMaxZoom(3.0f);
        config.setCanvasHeight(1080);
        config.setCanvasWidth(1920);
        drawable.setConfig(config);
    }
}
