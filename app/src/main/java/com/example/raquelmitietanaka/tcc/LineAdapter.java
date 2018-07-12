package com.example.raquelmitietanaka.tcc;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {

    ArrayList<Compras> listaProd = new ArrayList<Compras>();
    Compras compras = new Compras("0",0,0);
    Context context;

    public LineAdapter(ArrayList<Compras> produto,Context context){
        listaProd = produto;
        this.context = context;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context)
                .inflate(R.layout.viewholder, parent, false);
        LineHolder holder = new LineHolder(view);
        return holder;
        //return new LineHolder(LayoutInflater.from(parent.getContext())
         //       .inflate(R.layout.viewholder, parent, false));

    }

    public void onBindViewHolder(LineHolder viewHolder, final int position){
        LineHolder holder = (LineHolder) viewHolder;
        Compras compra = listaProd.get(position);

        holder.nome_produto.setText(compra.getName());
        holder.valor_produto.setText(Double.toString(compra.getValor()));
        holder.qtd_produto.setText(Integer.toString(compra.getQtd()));

        holder.moreButton.setOnClickListener(view -> updateItem(position));

        holder.deleteButton.setOnClickListener(view -> removerItem(position));
    }

    @Override
    public int getItemCount(){
        return listaProd.size();
    }

    public void updateList(Compras compras){
        insertItem(compras);
    }

    public void insertItem(Compras compras){
        listaProd.add(compras);
        notifyItemInserted(getItemCount());
    }

    private void updateItem(int position){
        Compras compras = listaProd.get(position);
        int qtd = compras.getQtd();
        compras.setQtd(qtd+1);
        notifyItemChanged(position);
    }

    private void removerItem(int position){
        listaProd.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listaProd.size());
    }

}
