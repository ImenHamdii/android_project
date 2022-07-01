package isetb.tp6.gestionbiblio.DataBase;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import isetb.tp6.gestionbiblio.Livre;
import isetb.tp6.gestionbiblio.R;

public class ListeLivre extends AppCompatActivity {
    private ListView listView;
    private BiblioAdapter adapter;
    private DatabaseHalper db;
    private ArrayList<Livre> listlivre;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livree);
        listView = findViewById(R.id.list_view);
        db = new DatabaseHalper(this);

        int cpt = db.getLivreCount();
        if (cpt>0) {
            listlivre = db.getAllLivre();
            BiblioAdapter adapter = new BiblioAdapter(this,listlivre);
            listView.setAdapter(adapter);
            db.close();

            Toast.makeText(ListeLivre.this, "*****", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(ListeLivre.this, "there is no livre in this table", Toast.LENGTH_LONG).show();

        }
            b = findViewById(R.id.btnadd);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LayoutInflater inflater = LayoutInflater.from(ListeLivre.this);
                    View viewadd = inflater.inflate(R.layout.addlivre, null);

                    EditText n = viewadd.findViewById(R.id.edit_name);
                    EditText at = viewadd.findViewById(R.id.edit_auteur);

                    AlertDialog.Builder a = new AlertDialog.Builder(ListeLivre.this);
                    a.setTitle("Add new livre");
                    a.setView(viewadd);
                    a.create();
                    a.setPositiveButton("Add livre", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String name = n.getText().toString();
                            String auteur = at.getText().toString();
                            if (TextUtils.isEmpty(name)||TextUtils.isEmpty(auteur)) {
                                Toast.makeText(ListeLivre.this, "check input values", Toast.LENGTH_LONG).show();

                            } else {
                                  Livre l=new Livre(name,auteur);
                                db.addlivre(l);
                                Toast.makeText(ListeLivre.this, "ajouter avec seccess", Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(getIntent());

                            }
                        }
                    });
                    a.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(ListeLivre.this, "Task cancelled", Toast.LENGTH_LONG).show();
                        }
                    });
                    a.show();
                }
            });

        }
    }

