package com.example.raquelmitietanaka.tcc;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public ImageButton moreButton;
    public ImageButton deleteButton;

    public LineHolder(View itemView){
        super(itemView);
        title = itemView.findViewById(R.id.title);
        moreButton = itemView.findViewById(R.id.add);
        deleteButton = itemView.findViewById(R.id.delete);
    }

}
