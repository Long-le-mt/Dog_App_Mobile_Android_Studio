package com.example.dogapp.viewmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogapp.R;
import com.example.dogapp.model.DogBreed;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.ViewHolder> {

    private List<DogBreed> dogBreedList;

    public DogsAdapter(List<DogBreed> dogBreedList) {
        this.dogBreedList = dogBreedList;
    }

    @NonNull
    @Override
    public DogsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dog_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogsAdapter.ViewHolder holder, int position) {
        DogBreed dogBreed = dogBreedList.get(position);
        if(dogBreed == null){
            return;
        }
        holder.twDogName.setText(dogBreed.getName());
        holder.twOrigin.setText(dogBreed.getOrigin());
        Picasso.get()
                .load(dogBreed.getUrl())
                .placeholder(R.drawable.img)
                .into(holder.imgOfDog);
    }

    @Override
    public int getItemCount() {
        if(dogBreedList == null)
            return 0;
        return dogBreedList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView twDogName, twOrigin;
        public ImageView imgOfDog;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            twDogName = itemView.findViewById(R.id.tw_name_dog);
            twOrigin = itemView.findViewById(R.id.tw_origin);
            imgOfDog = itemView.findViewById(R.id.img_dog);
        }

//        public ImageView getImage() {
//            return imgOfDog;
//        }
    }
}
