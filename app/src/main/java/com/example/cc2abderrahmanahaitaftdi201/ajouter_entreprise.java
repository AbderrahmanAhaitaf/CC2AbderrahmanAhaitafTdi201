package com.example.cc2abderrahmanahaitaftdi201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ajouter_entreprise extends AppCompatActivity {

    EditText nom,secteur,nb;
    Button btn_save,btn_cancel;
    MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_entreprise);
        db=new MyDatabase(this);
        btn_save=findViewById(R.id.btnAddNew);
        btn_cancel=findViewById(R.id.btnCancelNew);
        nom=findViewById(R.id.txtNom);
        secteur=findViewById(R.id.txtSecteur);
        nb=findViewById(R.id.txtNBEmploye);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() ){
            @Override
            public void onClick(View view) {
                Societe s = new Societe(nom.getText().toString(), secteur.getText().toString(), Integer.valueOf(nombreEmploye.getText().toString()));
                if (MyDatabase.AddSociete(db.getWritableDatabase(), s) == -1)
                    Toast.makeText(ajouter_entreprise.this, "Can't add this Societe!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ajouter_entreprise.this, "Added has been successfuly", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
