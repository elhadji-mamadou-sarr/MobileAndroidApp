package com.isepdiamniadio.gestion_isep;

import static com.isepdiamniadio.gestion_isep.Entites.AppDataBase.getDataBase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.isepdiamniadio.gestion_isep.Dao.DepartementDao;
import com.isepdiamniadio.gestion_isep.Dao.PromotionDao;
import com.isepdiamniadio.gestion_isep.Entites.AppDataBase;
import com.isepdiamniadio.gestion_isep.Entites.Apprenant;
import com.isepdiamniadio.gestion_isep.Entites.Departement;
import com.isepdiamniadio.gestion_isep.Entites.Promotion;

import java.util.ArrayList;
import java.util.List;

public class AjouterApprenant extends AbstractActivityMenu {

    Button annuler, enregistrer;
    Spinner promo ,dept;
    EditText matricule, nom, prenom, adresse, dateNaiss;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_apprenant);

        matricule = findViewById(R.id.id_matriculeApp_editext);
        nom = findViewById(R.id.id_nomApp_Edit);
        prenom = findViewById(R.id.id_prenomApp_Edit);
        adresse = findViewById(R.id.id_adresseApp_editext);
        dateNaiss = findViewById(R.id.id_dateNaiss_Edit);
        promo = findViewById(R.id.id_promotion_Spinner);
        dept = findViewById(R.id.id_departement_Edit);
        annuler = findViewById(R.id.id_annuler_apprenant);
        enregistrer = findViewById(R.id.id_enregistrer_apprenant);


        PromotionDao promotionDao = AppDataBase.getDataBase(getApplicationContext()).promotionDao();

        new Thread(() ->{
          List<Promotion> promotionList = promotionDao.findAll();
          List<String> promotionNames = new ArrayList<>();
            for (Promotion pro: promotionList) {
                promotionNames.add(String.valueOf(pro.numero));
            }
            runOnUiThread(()-> {
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, promotionNames);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                promo.setAdapter(adapter);
            });
        }).start();

        DepartementDao departementDao = AppDataBase.getDataBase(getApplicationContext()).departementDao();
        new Thread(() ->{
            List<Departement> departementList = departementDao.findAll();
            List<String> departementNames = new ArrayList<>();
            for (Departement pro: departementList) {
                departementNames.add(pro.nom);
            }
            runOnUiThread(()-> {
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, departementNames);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                dept.setAdapter(adapter);
            });
        }).start();

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
                String mat = ""+matricule.getText();
                if (mat.isEmpty()) {
                    Toast.makeText(AjouterApprenant.this, "Matricule obligation",Toast.LENGTH_SHORT).show();
                    return;
                }
                String nomApp = ""+nom.getText();
                if (nomApp.isEmpty()) {
                    Toast.makeText(AjouterApprenant.this, "Nom obligation",Toast.LENGTH_SHORT).show();
                    return;
                }
                String prenomApp = ""+prenom.getText();
                if (prenomApp.isEmpty()) {
                    Toast.makeText(AjouterApprenant.this, "Le prenom est obligation",Toast.LENGTH_SHORT).show();
                    return;
                }
                String adresseApp = ""+adresse.getText();
                if (adresseApp.isEmpty()) {
                    Toast.makeText(AjouterApprenant.this, "L'adresse est obligation",Toast.LENGTH_SHORT).show();
                    return;
                }
                String datN = ""+dateNaiss.getText();
                if (datN.isEmpty()) {
                    Toast.makeText(AjouterApprenant.this, "Date de naissance obligation",Toast.LENGTH_SHORT).show();
                    return;
                }
                String prom = ""+promo.getSelectedItem().toString();
                if (prom.isEmpty()) {
                    Toast.makeText(AjouterApprenant.this, "La promotion obligation",Toast.LENGTH_SHORT).show();
                    return;
                }

                String dep = ""+dept.getSelectedItemId();
                if (dep.isEmpty()) {
                    Toast.makeText(AjouterApprenant.this, "Departement obligation",Toast.LENGTH_SHORT).show();
                    return;
                }

                int matrl = Integer.parseInt(mat);
                int promotion = Integer.parseInt(prom);

                Apprenant app = new Apprenant();
                app.matricule=matrl;
                app.nom = nomApp;
                app.prenom = prenomApp;
                app.adresse = adresseApp;
                app.dateNaiss = datN;
                app.numPromo = promotion;
                app.codeDept = Integer.valueOf(dep);
                new Thread(){
                    @Override
                    public void run() {
                        AppDataBase db = getDataBase(getApplicationContext());
                        db.apprenantDao().addApp(app);
                        List<Apprenant> apprenantList = db.apprenantDao().getAll();
                        for (Apprenant app: apprenantList) {
                            Log.i("ISEPAPP",""+app);
                        }
                        enregistrer.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(AjouterApprenant.this, "Enrgistrer",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }.start();
            }
        });

    }
}