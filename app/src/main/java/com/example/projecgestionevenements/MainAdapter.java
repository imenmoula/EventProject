package com.example.projecgestionevenements;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends FirebaseRecyclerAdapter<Event, MainAdapter.MyViewHolder> {

    public MainAdapter(@NonNull FirebaseRecyclerOptions<Event> options) {
        super(options);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Event model) {
        holder.Title.setText(model.getName());
        holder.date.setText(model.getDate());
        holder.time.setText(model.getTime());
        holder.location.setText(model.getLocation());
        holder.capacity.setText(String.valueOf(model.getCapacity()));
        holder.desc.setText(model.getDescription());

        // You can set the image here if you store URLs of images in Firebase
        // Example: Picasso.get().load(model.getImage()).into(holder.img);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CircleImageView img;
        TextView Title, date, time, location, capacity, desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img1);
            Title = itemView.findViewById(R.id.Title);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            location = itemView.findViewById(R.id.Location);
            capacity = itemView.findViewById(R.id.capacity);
            desc = itemView.findViewById(R.id.Desc);
        }
    }
}
