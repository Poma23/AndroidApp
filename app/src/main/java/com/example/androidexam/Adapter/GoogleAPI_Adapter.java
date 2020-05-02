package com.example.androidexam.Adapter;

// this is an adaptor for recycler view.A list of Volume records
// and will be initialised as an empty list

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidexam.Model.Volume;
import com.example.androidexam.R;

import java.util.ArrayList;
import java.util.List;

public class GoogleAPI_Adapter extends RecyclerView.Adapter< GoogleAPI_Adapter.BookSearchResultHolder > {

    private List< Volume > results = new ArrayList<>();


    public BookSearchResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item, parent, false);

        return new BookSearchResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookSearchResultHolder holder, int position) {
        Volume volume = results.get(position);

        holder.titleTextView.setText(volume.getVolumeInfo().getTitle());
        holder.descriptionTextView.setText(volume.getVolumeInfo().getDescription());

        if (volume.getVolumeInfo().getImageLinks() != null) {
            String imageUrl = volume.getVolumeInfo().getImageLinks().getSmallThumbnail()
                    .replace("http://", "https://");

            Glide.with(holder.itemView)
                    .load(imageUrl)
                    .into(holder.smallThumbnailImageView);
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setResults(List< Volume > results) {
        this.results = results;
        notifyDataSetChanged();
    }

    class BookSearchResultHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView descriptionTextView;
        private ImageView smallThumbnailImageView;

        public BookSearchResultHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.book_item_title);
            descriptionTextView = itemView.findViewById(R.id.book_item_description);
            smallThumbnailImageView = itemView.findViewById(R.id.book_item_smallThumbnail);
        }

    }

}
