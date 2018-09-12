package com.example.raquelmitietanaka.tcc;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Comparacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparacao);
    }

    public void setFoto(Bitmap data) {
        ImageView foto = (ImageView) findViewById(R.id.fotoCod);
        foto.setImageBitmap(data);
    }
}
