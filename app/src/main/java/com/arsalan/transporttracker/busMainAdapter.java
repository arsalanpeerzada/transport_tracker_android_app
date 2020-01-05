package com.arsalan.transporttracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.zxing.integration.android.IntentIntegrator;

import java.util.List;

public class busMainAdapter extends RecyclerView.Adapter<busViewHolder> {

    private List<busListModel> modelList;
    Context context;
    int busPosition;
    busListModel model;
    View view;


    public busMainAdapter(List<busListModel> _modelList, Context context) {
        this.context = context;
        modelList = _modelList;
    }

    @NonNull
    @Override
    public busViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_mainactivity, parent, false);
        context = parent.getContext();
        return new busViewHolder(view);
    }

    @Override
    public void onBindViewHolder(busViewHolder holder, int position) {


        model = modelList.get(position);
        holder.bind(model);
        busPosition = position;

        CardView cardView = view.findViewById(R.id.cardView);
        ImageView imageView = view.findViewById(R.id.imageview);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MapsActivity.class);
                context.startActivity(intent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ScanActivity.class);
                context.startActivity(intent);
            }
        });


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                boolean expanded = model.isExpanded();
////                model.setExpanded(!expanded);
////                notifyItemChanged(busPosition);
//
//                Intent intent = new Intent(context, MapsActivity.class);
//                context.startActivity(intent);
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


}
