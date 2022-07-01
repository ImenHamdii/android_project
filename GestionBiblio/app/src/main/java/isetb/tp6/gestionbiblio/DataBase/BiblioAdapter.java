package isetb.tp6.gestionbiblio.DataBase;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

import isetb.tp6.gestionbiblio.BuildConfig;
import isetb.tp6.gestionbiblio.Livre;
import isetb.tp6.gestionbiblio.R;

public class BiblioAdapter extends ArrayAdapter<Livre> {
    Activity context;
    ArrayList<Livre> listlivre;
    DatabaseHalper db;
    TextView id;
    TextView name;
    TextView auteur;
    ImageView update;
    ImageView delete;
    public BiblioAdapter(Activity context, ArrayList<Livre> listlivre) {
        super(context, R.layout.activity_livre);
        this.context = context;
        this.listlivre = listlivre;
        db=new DatabaseHalper(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View v=inflater.inflate(R.layout.activity_livre,null,true);
        id=v.findViewById(R.id.txtid);
        name=v.findViewById(R.id.txtn);
        auteur=v.findViewById(R.id.txta);
        update=v.findViewById(R.id.imgup);
        ImageView delete=v.findViewById(R.id.imgdel);
        name.setText(listlivre.get(position).getName());
        auteur.setText(listlivre.get(position).getAuteur());
        Livre l=listlivre.get(position);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editLivre(l);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteLivre(l);
            }
        });

        return v;
    }

    private void deleteLivre(Livre l){
        db.removeLivre(l.getId());
        context.finish();
        context.startActivity(context.getIntent());
        Toast.makeText(context,"livre deleted",Toast.LENGTH_LONG).show();
    }

    private void editLivre(Livre l) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View viewadd=inflater.inflate(R.layout.addlivre,null);

        EditText n=viewadd.findViewById(R.id.edit_name);
        EditText aut=viewadd.findViewById(R.id.edit_auteur);

        if(l!=null){
            n.setText(l.getName());
            aut.setText(l.getAuteur());
        }
        AlertDialog.Builder a=new AlertDialog.Builder(context);
        a.setTitle("edit livre");
        a.setView(viewadd);
        a.create();
        a.setPositiveButton("edit livre", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name=n.getText().toString();
                String auteur=aut.getText().toString();
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(context,"check input values",Toast.LENGTH_LONG).show();

                }else{
                    Livre l2=new Livre(l.getId(),name,auteur);
                    db.updateLivre(l2);
                    context.finish();
                    context.startActivity(context.getIntent());
                }
            }
        });


        a.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context,"Task cancelled",Toast.LENGTH_LONG).show();
            }
        });
        a.show();
    }

}
