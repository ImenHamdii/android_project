package iset.beja.hellosmartphone.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import iset.beja.hellosmartphone.R;
import iset.beja.hellosmartphone.adapter.SmartphoneAdapter;
import iset.beja.hellosmartphone.model.Smartphone;
import iset.beja.hellosmartphone.retro.ApiClient;
import iset.beja.hellosmartphone.retro.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
List<Smartphone> smartphoneList;
Button btn_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.r);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProgressDialog pd=new ProgressDialog(this);
        pd.setMessage("Loading......");
        pd.show();
        try{
            ApiInterface apiService=ApiClient.getClient().create(ApiInterface.class);
            Call<List<Smartphone>> call=apiService.getSmartphones();
            call.enqueue(new Callback<List<Smartphone>>() {
                @Override
                public void onResponse(Call<List<Smartphone>> call, Response<List<Smartphone>> response) {
                    smartphoneList=response.body();
                    SmartphoneAdapter adapter=new SmartphoneAdapter(MainActivity.this,smartphoneList);
                    recyclerView.setAdapter(adapter);
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
            Log.d("Error",e.getMessage());
            Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG).show();
        }
        btn_add=findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);

            }
        });
    }
}