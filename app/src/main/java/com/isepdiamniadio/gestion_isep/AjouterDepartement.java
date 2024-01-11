package com.isepdiamniadio.gestion_isep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.isepdiamniadio.gestion_isep.Dao.DepartementDao;
import com.isepdiamniadio.gestion_isep.Dao.FormationDao;
import com.isepdiamniadio.gestion_isep.Entites.AppDataBase;
import com.isepdiamniadio.gestion_isep.Entites.Departement;
import com.isepdiamniadio.gestion_isep.Entites.Formation;

import java.util.List;

public class AjouterDepartement extends AbstractActivityMenu {

    Button annuler;
    Button enregistrer;
    EditText code_dep, nom_dep;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_departement);

        code_dep = findViewById(R.id.id_code_departement);
        nom_dep = findViewById(R.id.id_nom_departement);
        annuler = findViewById(R.id.id_annuler_departement);
        enregistrer = findViewById(R.id.id_enregistrer_departement);

        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ok = true;
                String codeD = ""+code_dep.getText();
                if (codeD.isEmpty()) {
                    Toast.makeText(AjouterDepartement.this, "code departement obligation",Toast.LENGTH_SHORT).show();
                    return;
                }
                String nomD = ""+nom_dep.getText();
                if (nomD.isEmpty()) {
                    Toast.makeText(AjouterDepartement.this, "nom departement obligation",Toast.LENGTH_SHORT).show();
                    return;
                }

                Departement departement = new Departement();
                departement.code = codeD;
                departement.nom = nomD;

                new Thread(){
                    @Override
                    public void run() {
                        DepartementDao departementDao = AppDataBase.getDataBase(getApplicationContext()).departementDao();
                        departementDao.ajoutDepartement(departement);
                        List<Departement> departementList = departementDao.findAll();
                        for (Departement frmt: departementList) {
                            Log.i("ISEP", ""+frmt);
                        }
                        enregistrer.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(AjouterDepartement.this, "Enrgistrer",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }.start();
            }
        });

    }
}