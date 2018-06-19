package com.example.raquelmitietanaka.tcc;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LineAdapter extends RecyclerView.Adapter<LineHolder>{
    private final List<Compras> mCompras;
    public LineAdapter(ArrayList produto){
        mCompras = produto;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new LineHolder(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.viewholder, parent, false ));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, final int position){
        holder.title.setText(String.format(Locale.getDefault(), "%s, %d - %s",
                mCompras.get(position).getName(),
                mCompras.get(position).getValor(),
                mCompras.get(position).getQtd()

        ));

        holder.moreButton.setOnClickListener(view -> updateItem(position));
        holder.deleteButton.setOnClickListener(view -> removerItem(position));
    }

    @Override
    public int getItemCount(){
        return mCompras != null ? mCompras.size() : 0;
    }

    public void updateList(Compras compras){
        insertItem(compras);
    }

    public void insertItem(Compras compras){
        mCompras.add(compras);
        notifyItemInserted(getItemCount());
    }

    private void updateItem(int position){
        Compras compras = mCompras.get(position);
        compras.incrementQtd();
        notifyItemChanged(position);
    }

    private void removerItem(int position){
        mCompras.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mCompras.size());
    }

}
