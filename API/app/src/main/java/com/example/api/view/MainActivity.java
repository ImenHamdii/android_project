package com.example.api.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.api.R;
import com.example.api.adapter.SmartphoneAdaptater;
import com.example.api.model.Smartphone;
import com.example.api.retro.ApiClient;
import com.example.api.retro.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
List<Smartphone> smartphoneList;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.r);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProgressDialog pd=new ProgressDialog(this);
        pd.setMessage("Loading ......");
        pd.setCancelable(false);
        pd.show();
        try {
            ApiInterface apiService=ApiClient.getClient().create(ApiInterface.class);
            Call<List<Smartphone>> call=apiService.getSmartphone();
            call.enqueue(new Callback<List<Smartphone>>() {
                @Override
                public void onResponse(Call<List<Smartphone>> call, Response<List<Smartphone>> response) {
                    smartphoneList=response.body();
                    SmartphoneAdaptater smartphoneAdaptater=new SmartphoneAdaptater(MainActivity.this,smartphoneList);
                    recyclerView.setAdapter(smartphoneAdaptater);
                    pd.hide();

                }

                @Override
                public void onFailure(Call<List<Smartphone>> call, Throwable t) {
                    Log.d("Response",t.toString());
                    Toast.makeText(MainActivity.this,t.toString(),Toast.LENGTH_LONG).show();


                }
            });
        }
        catch (Exception e){
            Log.d("error",e.getMessage());
        }
        btn=findViewById(R.id.btn_adds);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, Activity.class);
                startActivity(intent);
            }
        });


    }
}