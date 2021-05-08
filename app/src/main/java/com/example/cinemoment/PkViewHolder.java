package com.example.cinemoment;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PkViewHolder extends RecyclerView.ViewHolder {

    TextView textView;
    View v;

    public PkViewHolder(@NonNull View itemView) {
        super(itemView);

        textView=itemView.findViewById(R.id.textViewSinglePk);
        v = itemView;
    }
}
