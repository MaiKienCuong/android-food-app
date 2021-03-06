package maikiencuong.android;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvName, tvDescription, tvPrice;
    public ImageView imageView, imageView2;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);

        tvDescription = itemView.findViewById(R.id.tvDescription);
        tvName = itemView.findViewById(R.id.tvName);
        tvPrice = itemView.findViewById(R.id.tvPrice);
        imageView = itemView.findViewById(R.id.imageView);
        imageView2 = itemView.findViewById(R.id.imageView2);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }

}
