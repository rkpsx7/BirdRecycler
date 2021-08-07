package com.example.birdrecycler;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewHolder extends RecyclerView.ViewHolder {

    private ImageView bird_image;
    private clickListener clickListener;

    public viewHolder(@NonNull  View itemView, clickListener clickListener) {
        super(itemView);
        initViews(itemView);
        this.clickListener=clickListener;
    }

    private void initViews(View itemView) {
        bird_image=itemView.findViewById(R.id.img_bird);
    }

    public void setData(BirdModel birdModel){
        bird_image.setImageResource(birdModel.getImage());
        bird_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(birdModel, getAdapterPosition());
            }
        });
    }

}