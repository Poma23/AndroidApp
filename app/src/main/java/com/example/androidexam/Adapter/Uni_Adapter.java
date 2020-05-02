package com.example.androidexam.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidexam.Model.UniListModel;
import com.example.androidexam.R;

import java.util.ArrayList;
import java.util.List;

// so the recyclre view know that, Uniholder is what we want to use
public class Uni_Adapter extends RecyclerView.Adapter< Uni_Adapter.UniHolder > {
    // if we dont put the list to arraylist it will be null;
    private List< UniListModel > uniList = new ArrayList<>();

    @NonNull
    @Override
    // return the uniHolder
    public UniHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_singleview, parent, false);
        return new UniHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UniHolder holder, int position) {

        UniListModel currentUni = uniList.get(position);

        holder.textViewTitle.setText(currentUni.getTitle());
        holder.textviewDescription.setText(currentUni.getDescription());
    }

    @Override
    public int getItemCount() {
// how many items do you want to show
        return uniList.size();
    }

    public void setUni(List< UniListModel > list) {
        this.uniList = list;
        notifyDataSetChanged();
    }

    //create a viewholder class to hold the recycler view
    class UniHolder extends RecyclerView.ViewHolder {
        // crete variables for our view
        private TextView textViewTitle;
        private TextView textviewDescription;


        public UniHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.rv_title);
            textviewDescription = itemView.findViewById(R.id.rv_Description);


        }
    }
}
