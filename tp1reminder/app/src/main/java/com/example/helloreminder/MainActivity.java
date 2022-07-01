package com.example.helloreminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView t;
int cpt,col,dcol;
SharedPreferences mPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=findViewById(R.id.t);
        mPref=getSharedPreferences("prefs",MODE_PRIVATE);
        cpt=mPref.getInt("cpt",0);

        dcol= ContextCompat.getColor(this,R.color.cardview_shadow_start_color);
        col=mPref.getInt("col",dcol);

        t.setText(String.valueOf(cpt));
        t.setBackgroundColor(col);
    }

    public void changecolor(View view) {
        int color=((ColorDrawable)view.getBackground()).getColor();
        t.setBackgroundColor(color);
        SharedPreferences.Editor editor=mPref.edit();
        editor.putInt("col",color);
        editor.apply();

    }

    public void increment(View view) {
        cpt++;
        t.setText(String.valueOf(cpt));
        SharedPreferences.Editor editor=mPref.edit();
        editor.putInt("cpt",cpt);
        editor.apply();
    }

    public void Reset(View view) {
        cpt=0;
        t.setText("0");
        t.setBackgroundColor(dcol);
        SharedPreferences.Editor editor=mPref.edit();
        editor.clear();
        editor.apply();
    }
}