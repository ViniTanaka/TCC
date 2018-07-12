package com.example.raquelmitietanaka.tcc;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView nome_produto;
    public TextView valor_produto;
    public TextView qtd_produto;
    public ImageButton moreButton;
    public ImageButton deleteButton;

    public LineHolder(View itemView){
        super(itemView);
        nome_produto = (TextView) itemView.findViewById(R.id.nome_produto);
        valor_produto = (TextView) itemView.findViewById(R.id.valor_produto);
        qtd_produto = (TextView) itemView.findViewById(R.id.qtd_produto);
        moreButton = (ImageButton) itemView.findViewById(R.id.update);
        deleteButton = (ImageButton) itemView.findViewById(R.id.delete);
    }

}
