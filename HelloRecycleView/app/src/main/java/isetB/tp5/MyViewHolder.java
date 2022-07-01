package isetB.tp5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image);
        textView = itemView.findViewById(R.id.text);

    }
    public void bind(Country country){
        textView.setText(country.getName());
        imageView.setImageResource(country.getImage());
    }

}




