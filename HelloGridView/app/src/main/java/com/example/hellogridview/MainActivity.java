package com.example.hellogridview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView= findViewById(R.id.gv);
        GalerieAdapter a=new GalerieAdapter(this);
        gridView.setAdapter(a);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"position de l'image"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.dial:
                Toast.makeText(this,"dial is clicked",Toast.LENGTH_LONG).show();
                return true;
            case R.id.about:
                Toast.makeText(this,"about is clicked",Toast.LENGTH_LONG).show();
                return true;
            case R.id.message:
                Toast.makeText(this,"messages is clicked",Toast.LENGTH_LONG).show();
                return true;
            case R.id.exit:
                finish();
                return true;
        }
        return true;
    }
}