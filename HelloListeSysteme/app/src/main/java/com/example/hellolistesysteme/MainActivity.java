package com.example.hellolistesysteme;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView l;
    String nom[] = {"android", "apple", "windowsPhone"};
    String desc[] = {"Platforme de google", "Platforme de Apple", "Platforme de Microsoft"};
    Integer portrait[] = {R.drawable.android, R.drawable.apple, R.drawable.windows};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = findViewById(R.id.list);
        description description = new description(this, portrait, nom, desc);
        l.setAdapter(description);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder a = new AlertDialog.Builder(MainActivity.this);
                a.setTitle("Systeme d'exploitation préfére: ");
                a.setMessage("**" + nom[position] + "*:*" + desc[position]);
                a.setIcon(portrait[position]);
                a.setPositiveButton("ok", null);
                a.show();

            }
        });
    }
}