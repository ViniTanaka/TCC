package com.example.raquelmitietanaka.tcc;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.DividerItemDecoration;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;


        import java.util.ArrayList;

public abstract class LinearLayoutActivity extends AppCompatActivity{

    RecyclerView mRecyclerView;
    private LineAdapter mAdapter;

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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
