package com.example.calcul_pound_kg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText ch ,res;
    public Button b_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ch=findViewById(R.id.ch);
        res=findViewById(R.id.res);
    }
    public void onRadioButtononClicked (View v){
        boolean checked= ((RadioButton)v).isChecked();
        switch (v.getId()){
            case R.id.premierbutton:
                if (checked) {
                    int chif=Integer.valueOf(ch.getText().toString());
                    double resul =chif*0.454;
                    res.setText(String.valueOf(resul));
                    Toast.makeText(MainActivity.this,"resultat: " + resul,Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.deuxiembutton:
                if(checked){
                    int chif=Integer.valueOf(ch.getText().toString());
                    double resul=chif*2.22;
                    res.setText(String.valueOf(resul));
                    Toast.makeText(MainActivity.this,"resultat: " + resul,Toast.LENGTH_LONG).show();
                }
                break;
            default:
                
        }
    }
}