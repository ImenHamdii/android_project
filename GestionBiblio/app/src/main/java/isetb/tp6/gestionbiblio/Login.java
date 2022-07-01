package isetb.tp6.gestionbiblio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import isetb.tp6.gestionbiblio.DataBase.DatabaseHalper;
import isetb.tp6.gestionbiblio.DataBase.ListeLivre;

public class Login extends AppCompatActivity {
    EditText username,password;
    Button btnconnect;
    DatabaseHalper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         username=findViewById(R.id.edit_name);
         password=findViewById(R.id.edit_pwd);
         btnconnect=findViewById(R.id.btnconnect);

        db=new DatabaseHalper(this);
        btnconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                if(user.equals("")||pass.equals("")){
                    Toast.makeText(Login.this,"entrer les donnes",Toast.LENGTH_SHORT).show();
                }else{
                    boolean checkuserpass=db.checkpassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(Login.this,"welcome",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(Login.this,ListeLivre.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this,"invalid user",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}