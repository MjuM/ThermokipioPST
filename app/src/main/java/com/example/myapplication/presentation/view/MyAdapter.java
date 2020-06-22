package com.example.myapplication.presentation.view;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;


import com.example.myapplication.R;
import com.example.myapplication.presentation.model.Plant;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private  List<Plant> values;
    private OnItemClickListener listener;
    public interface OnItemClickListener{
        void onItemClick(Plant item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;
        public ImageView imageView;
        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            imageView = (ImageView) v.findViewById(R.id.icon);
        }
    }

    public void add(int position, Plant item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Plant> myDataset, OnItemClickListener listener) {
        this.values = myDataset;
        this.listener = listener;
    }
    public MyAdapter(List<Plant> myDataset){
        this.values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Plant currentIngr = values.get(position);

        if(currentIngr.getId() < 6 ) {

            holder.txtHeader.setText(currentIngr.getName());



            String image;
            int ModImage;
            int i;


            if (currentIngr.getId() == 1) {
                holder.imageView.setImageResource(R.mipmap.ic_kentia);
            }
            if (currentIngr.getId() == 2) {
                holder.imageView.setImageResource(R.mipmap.ic_lierre);
            }
            if (currentIngr.getId() == 3) {
                holder.imageView.setImageResource(R.mipmap.ic_cactus);
            }
            if (currentIngr.getId() == 4) {
                holder.imageView.setImageResource(R.mipmap.ic_pilea);
            }
            if (currentIngr.getId() == 5) {
                holder.imageView.setImageResource(R.mipmap.ic_zamio);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override public void onClick(View v){
                    listener.onItemClick(currentIngr);
                }
            });

        }



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }











}