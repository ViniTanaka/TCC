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
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.DividerItemDecoration;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.View;
        import android.widget.ImageButton;
        import android.widget.ImageView;


        import java.io.EOFException;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.io.InputStream;
        import java.util.ArrayList;

        import static com.example.raquelmitietanaka.tcc.R.id.holderImg;

public class LinearLayoutActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private LineAdapter mAdapter;
    ArrayList<Compras> listaProd = new ArrayList<Compras>();
    Compras compras = new Compras(null,null,0,0);
    private Bitmap bitmap;
    ImageButton add;
    private final int FOTO_PRODUTO = 123;

    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Pede permissão para usar Camera
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

    public void setaRecyclerView(){

        //Aqui é instanciado o Recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        listaProd.add(compras);
        LineAdapter lineAdapter = new LineAdapter(this, listaProd);
        mRecyclerView.setAdapter(lineAdapter);
    }

    public void abrirCamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,FOTO_PRODUTO);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        InputStream stream = null;
        if( requestCode == FOTO_PRODUTO && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");//guarda foto
            compras.setImgBitmap(imageBitmap);
            //MOCANDO VALORES
            compras.setName("Matheus");
            compras.setValor(5.50);
            compras.setQtd(5);
            //Atualiza a View com o novo produto após a foto
            setaRecyclerView();

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

    /*
   private void setupRecycler(){


        //Configurando layout para ser uma lista
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        //adiciona o adapter à lista, cria uma lista vazia que sera preenchida
        mAdapter = new LineAdapter(new ArrayList<Compras>(0));
        mRecyclerView.setAdapter(mAdapter);


        //divisor entre as linhas
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }*/

}
