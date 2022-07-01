package isetb.tp6.gestionbiblio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import isetb.tp6.gestionbiblio.DataBase.BiblioAdapter;
import isetb.tp6.gestionbiblio.DataBase.DatabaseHalper;
import isetb.tp6.gestionbiblio.DataBase.ListeLivre;

public class MainActivity extends AppCompatActivity {
    private DatabaseHalper db;
    EditText txtn,txtp,repwd;
    Button btnenreg,btncompte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHalper(this);
        txtn=findViewById(R.id.nom);
        txtp=findViewById(R.id.pwd);
        repwd=findViewById(R.id.repwd);

        btnenreg=findViewById(R.id.btnenreg);
        btnenreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=txtn.getText().toString();
                String pass=txtp.getText().toString();
                String repass=repwd.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals("")){
                    Toast.makeText(MainActivity.this,"entrer tous les donnes",Toast.LENGTH_LONG).show();
                }else{
                    if(pass.equals(repass)){
                        boolean checkuser=db.checkuserName(user);
                        if(checkuser==false){
                            boolean insert=db.addUser(user,pass);
                            if(insert==true){
                                Toast.makeText(MainActivity.this,"Registrer success!!",Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(MainActivity.this,Login.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(MainActivity.this,"regestred failed!!!",Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this,"user already existe",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this,"confirmer password",Toast.LENGTH_LONG).show();
                    }
                }


            }
        });
        btncompte=findViewById(R.id.btncpt);
        btncompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);

    }

    });
    }
}