package iset.beja.hellosmartphone.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import iset.beja.hellosmartphone.R;

public class SmartphoneViewHolder extends RecyclerView.ViewHolder {
ImageView img;
TextView t1,t2;

    public SmartphoneViewHolder(@NonNull View itemView) {
        super(itemView);
        img=itemView.findViewById(R.id.image);
        t1=itemView.findViewById(R.id.text_marque);
        t2=itemView.findViewById(R.id.text_prix);

    }
}
