package isetb.tp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConnexionActivity extends AppCompatActivity {

EditText txtlog,txtpass;
Button btn1_cnx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        EditText txtlog = findViewById(R.id.txt_login);
        EditText txtpass = findViewById(R.id.txt_pwd);
        Button btn1_cnx = findViewById(R.id.btn_cnx);
        btn1_cnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtlog.equals("") || txtpass.equals("")) {
                    Toast.makeText(ConnexionActivity.this, "Champs Vide", Toast.LENGTH_LONG).show();
                } else { /*if(!l.equals(login)||!p.equals(password)) {
                    Toast.makeText(ConnectionActivity.this, "Login ou password incorrect ", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i=new Intent(ConnectionActivity.this,MainActivity.class);
                    i.putExtra("log",l);
                    startActivity(i);}*/
                    SharedPreferences pref = getSharedPreferences("Myinfo", MODE_PRIVATE);
                    String slogin = pref.getString("Login", "erreur");
                    String spw = pref.getString("pw", "erreur");

                    if (!txtlog.equals(slogin) || !txtpass.equals(spw)) {
                        Toast.makeText(ConnexionActivity.this, "Login ou password incorrect ", Toast.LENGTH_LONG).show();
                    } else {
                        Intent i = new Intent(ConnexionActivity.this, MainActivity.class);
                        i.putExtra("log", (Parcelable) txtlog);
                        startActivity(i);
                    }
                }
            }
        });
    }}