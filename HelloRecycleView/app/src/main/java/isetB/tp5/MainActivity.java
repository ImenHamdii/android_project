package isetB.tp5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<Country> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        countryStack();
        MyAdapter myAdapter =new MyAdapter(list);
        recyclerView.setAdapter(myAdapter);
    }

    void countryStack(){
        list.add(new Country("Tunisie",R.drawable.tunisie));
        list.add(new Country("Italie",R.drawable.italie));
        list.add(new Country("Maroc",R.drawable.maroc));
        list.add(new Country("Egypte",R.drawable.egypte));
        list.add(new Country("Chine",R.drawable.chine));
        list.add(new Country("Espagne",R.drawable.espagne));
        list.add(new Country("France",R.drawable.france));
    }
}