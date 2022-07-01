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
EditText np,l,e,p,cp;
Button btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enregistrement);

        np=findViewById(R.id.editNP);
        l=findViewById(R.id.editLogin);
        e=findViewById(R.id.editEmail);
        p=findViewById(R.id.editpw);
        cp=findViewById(R.id.editCpw);
        btn_save=findViewById(R.id.enreg);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("Myinfo",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                String nomprenom=np.getText().toString();
                editor.putString("Nom",nomprenom);

                String log=l.getText().toString();
                editor.putString("Login",log);

                String email=e.getText().toString();
                editor.putString("email",email);

                String pw=p.getText().toString();
                editor.putString("pw",pw);

                String cpw=cp.getText().toString();
                if (pw.equals(cpw)){
                    editor.commit();
                    Intent intent=new Intent(EnregistrementActivity.this,ConnectionActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(EnregistrementActivity.this,"pw et cpw ne sont pas egaux",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}