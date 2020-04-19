package com.example.paginationrecycler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    List<ImageDetailsList> list;

    public Adapter(Context context, List<ImageDetailsList> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_lisyitem,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ImageDetailsList imageDetails = list.get(position);
        holder.imageView.setImageDrawable( context.getDrawable(imageDetails.getImage()));

        holder.imageName.setText(imageDetails.getImageName());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView imageName;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageName = (TextView) itemView.findViewById(R.id.imageName);


        }
    }

    public void AddList(List<ImageDetailsList> imagelist)
    {
        for(ImageDetailsList li : imagelist )
        {
            list.add(li);
        }
        notifyDataSetChanged();
    }


}
