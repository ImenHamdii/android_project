package isetb.tp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnregistrementActivity extends AppCompatActivity {
EditText nom,login,mail,password,confPass;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enregistrement);
        nom=findViewById(R.id.edit_nomPre);
        login=findViewById(R.id.edit_login);
        mail=findViewById(R.id.edit_mail);
        password=findViewById(R.id.edit_psswrd);
        confPass=findViewById(R.id.edit_confP);
        button=findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("myInfo",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                String nom_prenom=nom.getText().toString();
                editor.putString("prenom",nom_prenom);

                String logine=login.getText().toString();
                editor.putString("log",logine);

                String email=mail.getText().toString();
                editor.putString("adres_mail",email);

                String passe=password.getText().toString();
                editor.putString("motpasse",passe);

                String cpsswrd=confPass.getText().toString();
                if(passe.equals(cpsswrd)){
                    editor.commit();
                    Intent intent=new Intent(EnregistrementActivity.this,ConnexionActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(EnregistrementActivity.this,"Le mot de passe et la confirmation de mot de passe ne sont pas egaux",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}