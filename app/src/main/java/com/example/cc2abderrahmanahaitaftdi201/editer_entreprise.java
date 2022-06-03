package com.example.cc2abderrahmanahaitaftdi201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class editer_entreprise extends AppCompatActivity {

    EditText nom,secteur,nbEmp;
    Button btnupdate,btndelete;
    Spinner sp;
    MyDatabase db;
    ArrayList<Societe> s;
    ArrayAdapter<String> ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editer_entreprise);

        db=new MyDatabase(this);
        sp=findViewById(R.id.sp1);
        nom=findViewById(R.id.txtNom);
        secteur=findViewById(R.id.txtSecteur);
        nbEmp=findViewById(R.id.txtNBEmploye);
        btnupdate=findViewById(R.id.btnUpdate);
        btndelete=findViewById(R.id.btnDelete);
        s=MyDatabase.getAllSociete(db.getReadableDatabase());
        ArrayList<String> lst=new ArrayList<>();
        for (Societe item:s) {
            lst.add(String.valueOf(item.getId()));
        }
        ad=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,lst);
        sp.setAdapter(ad);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Societe s = s.get(i);
                nom.setText(s.getNom());
                secteur.setText(s.getSecteur());
                nbEmp.setText(String.valueOf(s.getNombreEmploye()));
            }

    }
}