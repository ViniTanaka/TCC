package com.example.raquelmitietanaka.tcc;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LineAdapter extends RecyclerView.Adapter<LineAdapter.LineHolder>{

    private final List<Compras> mCompras;
    Context cntx;

    public LineAdapter(Context cntx, ArrayList<Compras> produto){
        this.cntx = cntx;
        mCompras = produto;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType){
        //LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //View view = layoutInflater.inflate(R.layout.viewholder, parent, false);
        //LineHolder lineholder = new LineHolder(view);
        //return lineholder;
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder, parent, false);
        return new LineHolder(itemView);
    }

    public void onBindViewHolder(LineHolder holder, final int position){
        holder.title.setText(String.format(Locale.getDefault(), "%s, %d - %s",
                mCompras.get(position).getImgBitmap(),
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

    //Classe HOLDER
    protected class LineHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public Bitmap imgProduto;
        public ImageButton moreButton;
        public ImageButton deleteButton;

        public LineHolder(final View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
            moreButton = itemView.findViewById(R.id.add);
            deleteButton = itemView.findViewById(R.id.delete);
        }

        public void setImgProduto(Bitmap imgProduto) {
            this.imgProduto = imgProduto;
        }
    }

}
