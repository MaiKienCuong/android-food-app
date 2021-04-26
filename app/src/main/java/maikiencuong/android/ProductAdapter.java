package maikiencuong.android;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<Product> products;
    private LayoutInflater inflater;
    private Context context;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.products = products;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Product product = products.get(position);

        holder.tvname.setText(product.getName());
        holder.tvDescription.setText(product.getDescription());
        holder.tvPrice.setText("$ " + product.getPrice());
        holder.imageView.setImageResource(product.getImage());
        holder.imageView2.setImageResource(R.drawable.add);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick)
                    Toast.makeText(context, "Long Click", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(context, CartActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("product", products.get(position));
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
