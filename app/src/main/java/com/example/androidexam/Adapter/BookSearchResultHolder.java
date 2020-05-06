package com.example.androidexam.Adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidexam.R;

//this class is for the ViewHolder for each BookSearchResult which will set the contents of
// each TextView in the search result and use the Glide library to retrieve the book cover
// image from the URL and show it inside the ImageView.

public class BookSearchResultHolder extends RecyclerView.ViewHolder {

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