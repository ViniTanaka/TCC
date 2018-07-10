package com.example.raquelmitietanaka.tcc;

        import android.Manifest;
        import android.content.Context;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.graphics.Matrix;
        import android.media.Image;
        import android.os.Build;
        import android.os.Bundle;
        import android.provider.MediaStore;
        import android.support.annotation.RequiresApi;
        import android.support.v4.app.ActivityCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.DividerItemDecoration;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.View;
        import android.widget.ImageButton;


        import java.io.EOFException;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.io.InputStream;
        import java.util.ArrayList;

public class LinearLayoutActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    private LineAdapter mAdapter;
    private Bitmap bitmap;
    ImageButton add;

    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissions();
        add = (ImageButton) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamera();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void requestPermissions(){
        String[] perms = {Manifest.permission.CAMERA};
        requestPermissions(perms, PackageManager.PERMISSION_GRANTED);
    }

    public void abrirCamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,123);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        InputStream stream = null;
        if( requestCode == 123 && resultCode == RESULT_OK){
            try{
                if(bitmap != null){
                    bitmap.recycle();
                }
                stream = getContentResolver().openInputStream(data.getData());
                bitmap = BitmapFactory.decodeStream(stream);
                add.setImageBitmap(resizeImage(this,bitmap, 700, 600));
            }catch ( FileNotFoundException e){
                e.printStackTrace();
            }finally {
                if(stream != null){
                    try{
                        stream.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }//SEGUNDO try
                }//IF do FINALLY
            }//FINALLY
        }//PRIMEIRO IF
    }//ActivityResult

    private static Bitmap resizeImage(Context context, Bitmap bmpOriginal, float newWidth, float newHeight){
        Bitmap novoBmp = null;

        int w = bmpOriginal.getWidth();
        int h = bmpOriginal.getHeight();

        float densityFactor = context.getResources().getDisplayMetrics().density;
        float novoW = newWidth * densityFactor;
        float novoH = newHeight * densityFactor;

        //Calcula escala com base na imagem original ( porcentagem )
        float escalaW = novoW / w;
        float escalaH = novoH / h;


        Matrix matrix = new Matrix();
        matrix.postScale(escalaW, escalaH);

        novoBmp = Bitmap.createBitmap(bmpOriginal, 0, 0, w, h, matrix, true);
        return novoBmp;
    }//ResizeImage

   private void setupRecycler(){


        //Configurando layout para ser uma lista
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        //adiciona o adapter à lista, cria uma lista vazia que sera preenchida
        mAdapter = new LineAdapter(new ArrayList<>(0));
        mRecyclerView.setAdapter(mAdapter);

        //divisor entre as linhas
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

}
