package com.example.ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends  AppCompatActivity{
    private EditText c1,c2;
    private TextView r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        r=findViewById(R.id.r);

    }

    public void somme (View v){
        int chif1 =Integer.valueOf(c1.getText().toString());
        int chif2 =Integer.valueOf(c2.getText().toString());
        int resultat =chif1+chif2;
        r.setText(String.valueOf(resultat));
    }
    public void difference (View v){
        int chif1 =Integer.valueOf(c1.getText().toString());
        int chif2 =Integer.valueOf(c2.getText().toString());
        int resultat =chif1-chif2;
        r.setText(String.valueOf(resultat));

    }
    public void produit (View v){
        int chif1 =Integer.valueOf(c1.getText().toString());
        int chif2 =Integer.valueOf(c2.getText().toString());
        int resultat =chif1*chif2;
        r.setText(String.valueOf(resultat));

    }
    public void division (View v){
        int chif1 =Integer.valueOf(c1.getText().toString());
        int chif2 =Integer.valueOf(c2.getText().toString());
        int resultat =chif1/chif2;
        r.setText(String.valueOf(resultat));

    }


}
