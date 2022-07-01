package com.example.hellolisteview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PlayerListeAdapter extends ArrayAdapter {
    private final Activity context ;
    private final Integer[] portrait ;
    private final String[] nom;
    private final String[] equipe;

    public PlayerListeAdapter(Activity context1, Integer[] portrait, String[] nom, String[] equipe) {
        super(context1,R.layout.element,nom);
        this.context = context1;
        this.portrait = portrait;
        this.nom = nom;
        this.equipe = equipe;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View elementView= inflater.inflate(R.layout.element,null,true);
        TextView nomtextView=elementView.findViewById(R.id.nom);
        TextView equipetextView=elementView.findViewById(R.id.equipe);
        ImageView imageView=elementView.findViewById(R.id.image);

        nomtextView.setText(nom[position]);
        equipetextView.setText(equipe[position]);
        imageView.setImageResource(portrait[position]);
        return elementView;
    }
}
