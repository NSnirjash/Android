package com.nsnirjash.androidappjee59.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nsnirjash.androidappjee59.R;

import java.util.List;

public class PurbachalModelAdapter extends RecyclerView.Adapter<PurbachalModelAdapter, RecyclerView.ViewHolder> {


    private List<PurbachalModelAdapter>purbachalModelList;
    private Context context;


    public static class viewHolder extends RecyclerView.ViewHolder{

        TextView textDate;
        TextView textNews;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            textDate = itemView.findViewById(R.id.noticeDate);
            textNews = itemView.findViewById(R.id.noticeNews);
        }
    }
}
