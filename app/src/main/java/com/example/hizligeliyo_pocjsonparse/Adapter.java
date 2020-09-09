package com.example.hizligeliyo_pocjsonparse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<Product> products;

    public Adapter(Context ctx,List<Product> products){
        this.inflater=LayoutInflater.from(ctx);
        this.products=products;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view =inflater.inflate(R.layout.list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.productName.setText(products.get(position).getTitle());
        holder.price.setText(products.get(position).getPrice());
        Picasso.get().load(products.get(position).getImage()).into(holder.productImage);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView productName,price;
        ImageView productImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.productName);
            price = itemView.findViewById(R.id.price);
            productImage = itemView.findViewById(R.id.productImage);

        }
    }
}
