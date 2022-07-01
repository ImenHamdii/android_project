package com.example.hellolisteview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView l;
    String[] nom={"cristiano Ronaldo","Antoine Griezmann","Kylian Mbappe","Mohammed Salah","Lionne Messi","Msekni Youssef","Neymar"," Paul pogba"};
    String[] equipe={"juventus","Barcelona","Paris Saint germain","Liverpool","Barcelone","Tunisie","Brazil","Manchester united"};
    Integer[] portrait={R.drawable.cristiano,R.drawable.griezmann,R.drawable.mbappe,R.drawable.meds,R.drawable.messi,R.drawable.msekni,R.drawable.neymar,R.drawable.pogba};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l=findViewById(R.id.liste);
        PlayerListeAdapter adapter=new PlayerListeAdapter(this,portrait,nom,equipe);
        l.setAdapter(adapter);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder a= new AlertDialog.Builder(MainActivity.this);
                a.setTitle("Joueur préféré");
                a.setMessage("*******"+nom[position]+"**"+equipe[position]);
                a.setIcon(portrait[position]);
                a.setPositiveButton("ok",null);
                a.show();
            }
        });
    }



}