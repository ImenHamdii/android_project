package isetb.tp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConnectionActivity extends AppCompatActivity {
    EditText e1,e2;
    Button btn_connexion,btn_inscription,btn_parametre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);
        e1=findViewById(R.id.edit_login);
        e2=findViewById(R.id.edit_pw);
        btn_connexion=findViewById(R.id.btn);

        btn_connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String l=e1.getText().toString();
                String p=e2.getText().toString();

                if(l.equals("")||p.equals("")) {
                    Toast.makeText(ConnectionActivity.this, "Champs Vide", Toast.LENGTH_LONG).show();
                }
                else{ /*if(!l.equals(login)||!p.equals(password)) {
                    Toast.makeText(ConnectionActivity.this, "Login ou password incorrect ", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i=new Intent(ConnectionActivity.this,MainActivity.class);
                    i.putExtra("log",l);
                    startActivity(i);}*/
                    SharedPreferences pref=getSharedPreferences("Myinfo",MODE_PRIVATE);
                    String slogin=pref.getString("Login","erreur");
                    String spw=pref.getString("pw","erreur");

                    if (!l.equals(slogin)||!p.equals(spw)){
                        Toast.makeText(ConnectionActivity.this, "Login ou password incorrect ", Toast.LENGTH_LONG).show();
                    }else {
                        Intent i=new Intent(ConnectionActivity.this,MainActivity.class);
                        i.putExtra("log",l);
                        startActivity(i);
                    }
            }
            }
        });

        btn_inscription=findViewById(R.id.btn_inscription);
        btn_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ConnectionActivity.this,EnregistrementActivity.class);
                startActivity(intent);
            }
        });

        btn_parametre=findViewById(R.id.btn_parametre);
        btn_parametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ConnectionActivity.this,PreferencesActivity.class);
                startActivity(intent);
            }
        });

    }
}