package com.example.pptahta;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PopularAdaptor extends RecyclerView.Adapter<PopularAdaptor.ViewHolder> {
    ArrayList<PhoneDomain> popularPhone;


    public PopularAdaptor(ArrayList<PhoneDomain> categoryPhone) {
        this.popularPhone = categoryPhone;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdaptor.ViewHolder holder, int position) {
        holder.title.setText(popularPhone.get(position).getTitle());
        holder.fee.setText(String.valueOf(popularPhone.get(position).getFee()));

        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(popularPhone.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return popularPhone.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, fee;
        ImageView pic;
        TextView addBtn;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title=itemView.findViewById(R.id.title);
            fee=itemView.findViewById(R.id.fee);
            pic=itemView.findViewById(R.id.pic);
            addBtn=itemView.findViewById(R.id.addBtn);

        }

    }
}
