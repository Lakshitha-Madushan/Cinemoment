package com.example.mydetails;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


    public class AptViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        View v;

        public AptViewHolder(@NonNull View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.textView_single_aptview);
            v = itemView;
        }
    }
