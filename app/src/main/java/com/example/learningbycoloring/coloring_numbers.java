package com.example.learningbycoloring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import com.example.learningbycoloring.common.Common;
import com.example.learningbycoloring.widget.PaintView;
import com.thebluealliance.spectrum.SpectrumPalette;

public class coloring_numbers extends AppCompatActivity implements SpectrumPalette.OnColorSelectedListener {
    int[] imgN=GlobalParameters.imgN;
    int[] soundN=GlobalParameters.soundN;
    ImageButton imageButton;
    int i;
    SpectrumPalette spectrumPalette;
    PaintView paintView;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coloring_numbers);
        imageButton=findViewById(R.id.imageButton);
        spectrumPalette=findViewById(R.id.palette);
        spectrumPalette.setOnColorSelectedListener(this);
        paintView=findViewById(R.id.paint_view);
        Intent i1 = getIntent();
        i= i1.getIntExtra("indice",0);
        Common.PICTURE_SELECTED=imgN[i];

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp!=null)
                    mp.stop();
                mp= MediaPlayer.create(getApplicationContext(), soundN[i]);
                mp.start();
            }
        });
    }


    @Override
    public void onColorSelected(int color) {
        Common.COLOR_SELECTED=color;
    }
}