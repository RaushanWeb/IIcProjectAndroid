package com.example.mlkit;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.ProgrammingViewHolder>
{
    ArrayList <String>classNames = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();
    Context context;
    Class<?>[] classes;
    public ProgrammingAdapter(Context context, ArrayList<String> classNames, ArrayList<Integer> imageName, Class<?>[] classes)
    {
        this.classNames = classNames;
        this.image = imageName;
        this.context = context;
        this.classes = classes;
    }
    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview_layout,parent,false);
        return new ProgrammingViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ProgrammingAdapter.ProgrammingViewHolder holder, int position)
    {
        holder.text.setText(classNames.get(position));
        holder.imageView.setImageResource(image.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(context,classes[position]);
		        intent.putExtra(BaseActivity.ACTION_BAR_TITLE, classNames.get(position));
		        context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return classNames.size();
    }
    public static class ProgrammingViewHolder extends RecyclerView.ViewHolder
    {
        TextView text;
        ImageView imageView;
        public ProgrammingViewHolder(@NonNull  View itemView)
        {
            super(itemView);
            text = (TextView)itemView.findViewById(R.id.textViewRecy);
            imageView = (ImageView)itemView.findViewById(R.id.ImageView);
        }
    }
}
