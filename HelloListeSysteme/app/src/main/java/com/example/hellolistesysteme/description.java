package com.example.hellolistesysteme;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class description extends ArrayAdapter {
        private final Activity context ;
        private final Integer[] portrait ;
        private final String[] nom;
        private final String[] desc ;

        public description(Activity context1, Integer[] portrait, String[] nom, String[] desc) {
            super(context1,R.layout.element,nom);
            this.context = context1;
            this.portrait = portrait;
            this.nom = nom;
            this.desc = desc;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=context.getLayoutInflater();
            View elementView= inflater.inflate(R.layout.element,null,true);
            TextView nomtextView=elementView.findViewById(R.id.nom);
            TextView equipetextView=elementView.findViewById(R.id.desc);
            ImageView imageView=elementView.findViewById(R.id.img);

            nomtextView.setText(nom[position]);
            equipetextView.setText(desc[position]);
            imageView.setImageResource(portrait[position]);
            return elementView;
        }
    }
