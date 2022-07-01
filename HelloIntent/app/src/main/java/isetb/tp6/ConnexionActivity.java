package isetb.tp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConnexionActivity extends AppCompatActivity {
   // String login="insaf";
    //String password="isetbeja";
    EditText e1,e2;
    Button btn,btnInscri,btn_para;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        e1=findViewById(R.id.txt1);
        e2=findViewById(R.id.txt2);
        btn=findViewById(R.id.cnx);
        btnInscri=findViewById(R.id.btn_inscri);
        btn_para=findViewById(R.id.btn_param);



       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String l = e1.getText().toString();
               String p = e2.getText().toString();
               if (l.equals("") || p.equals("")) {
                   Toast.makeText(ConnexionActivity.this, "champs vides", Toast.LENGTH_SHORT).show();
               } else { /*if(!l.equals(login) || !p.equals(password)){
                   Toast.makeText(ConnexionActivity.this,"Login ou Password incorrect",Toast.LENGTH_LONG).show();}
               else {
                   Intent i=new Intent(ConnexionActivity.this,MainActivity.class);
                   i.putExtra("log",login);
                   startActivity(i);
               }*/
               }
               SharedPreferences pref = getSharedPreferences("myInfo", MODE_PRIVATE);
               String slogin = pref.getString("log", "error");
               String spw = pref.getString("motpasse", "error");
               if (!l.equals(slogin) || !p.equals(spw)) {
                   Toast.makeText(ConnexionActivity.this,"login ou password incorrect",Toast.LENGTH_LONG).show();
               }
               else{
                   Intent i =new Intent (ConnexionActivity.this,MainActivity.class);
                   startActivity(i);
               }
           }
       });
       btnInscri.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(ConnexionActivity.this,EnregistrementActivity.class);
               startActivity(i);
           }
       });
       btn_para.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(ConnexionActivity.this,PreferencesActivity.class);
               startActivity(intent);
           }
       });
    }
}