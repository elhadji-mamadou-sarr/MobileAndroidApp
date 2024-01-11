package com.isepdiamniadio.gestion_isep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.isepdiamniadio.gestion_isep.Dao.FormationDao;
import com.isepdiamniadio.gestion_isep.Dao.PromotionDao;
import com.isepdiamniadio.gestion_isep.Entites.AppDataBase;
import com.isepdiamniadio.gestion_isep.Entites.Formation;
import com.isepdiamniadio.gestion_isep.Entites.Promotion;

import java.util.ArrayList;
import java.util.List;

public class AjoutClasse extends AbstractActivityMenu {

    Spinner numPromo_classe, numForm_classe, responsable;
    EditText numClasse;
    Button annuler, enregistrer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_classe);

        numClasse = findViewById(R.id.id_numClasse_Editext);
        numPromo_classe = findViewById(R.id.id_promotion_Spinner);
        numForm_classe = findViewById(R.id.id_numFormation_Spinner);
        responsable = findViewById(R.id.id_responsable_Spinner);
        annuler = findViewById(R.id.id_annuler_classe);
        enregistrer = findViewById(R.id.id_enregistrer_classe);

        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        PromotionDao promotionDao = AppDataBase.getDataBase(getApplicationContext()).promotionDao();

        new Thread(() ->{
           /* List<Promotion> promotionList = promotionDao.findAll();
            List<String> promotionNames = new ArrayList<>();
            for (Promotion pro: promotionList) {
                promotionNames.add(String.valueOf(pro.numero));
            }
            runOnUiThread(()-> {
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, promotionNames);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                numPromo_classe.setAdapter(adapter);
            });*/
        }).start();


/*
        FormationDao formationDao = AppDataBase.getDataBase(getApplicationContext()).formationDao();
                new Thread(() ->{
                    List<Formation> formationList = formationDao.findAll();
                    List<String> formationNames = new ArrayList<>();
                    for (Formation fort: formationList) {
                        formationNames.add(fort.code);
                    }
                    runOnUiThread(() ->{
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, formationNames);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        numForm_classe.setAdapter(adapter);
                    });
                }).start();*/

        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }



}