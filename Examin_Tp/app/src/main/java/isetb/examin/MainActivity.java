package isetb.examin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText nt1,nt2,cf1,cf2;
Button btn;
TextView res;
float nt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nt1=findViewById(R.id.n1);
        nt2=findViewById(R.id.n2);
        cf1=findViewById(R.id.c1);
        cf2=findViewById(R.id.c2);
        res=findViewById(R.id.res);
        btn=findViewById(R.id.btn_calc);
        nt=(nt1*cf1+nt2*cf2)/(cf1*cf2);
        if (nt>10){
            Intent i=new Intent(i,MainActivity.this,ReussiteActivity);
            res.setText(i+nt).toString();
        }else{
            Intent intent=new Intent(MainActivity.this,EchecActivity);
            res.setText(intent+nt);
        }


    }
}