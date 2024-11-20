package com.project.tourbooking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.tourbooking.R;
import com.project.tourbooking.dto.TourViewMain;

import java.util.List;

public class TourViewMainAdapter extends RecyclerView.Adapter<TourViewMainAdapter.TourViewHolder>{

    private Context context;
    private List<TourViewMain> tourList;

    public TourViewMainAdapter(Context context, List<TourViewMain> tourList) {
        this.context = context;
        this.tourList = tourList;
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tour_main, parent, false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        TourViewMain tour = tourList.get(position);
        holder.imgTour.setImageResource(tour.getImageResId());
        holder.tvTourName.setText(tour.getTourName());
        holder.tvCompanyName.setText(tour.getCompanyName());
        holder.tvPrice.setText(tour.getPrice());
    }

    @Override
    public int getItemCount() {
        return tourList.size();
    }

    public static class TourViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTour;
        TextView tvTourName, tvCompanyName, tvPrice;

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTour = itemView.findViewById(R.id.imgTour);
            tvTourName = itemView.findViewById(R.id.tvTourName);
            tvCompanyName = itemView.findViewById(R.id.tvCompanyName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
