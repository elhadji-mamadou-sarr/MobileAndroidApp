package com.isepdiamniadio.gestion_isep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.isepdiamniadio.gestion_isep.Dao.PromotionDao;
import com.isepdiamniadio.gestion_isep.Entites.AppDataBase;
import com.isepdiamniadio.gestion_isep.Entites.Promotion;

import java.util.ArrayList;
import java.util.List;

public class AjoutPromo extends AbstractActivityMenu {
    Button annuler;
    Button enregistrer;
    EditText numero, anneeDebut, anneeFin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_promo);

        numero = findViewById(R.id.id_numPromo_editext);
        anneeDebut = findViewById(R.id.id_anneeFin_Edit);
        anneeFin = findViewById(R.id.id_anneeFin_Edit);
        annuler = findViewById(R.id.id_annuler_promo);
        enregistrer = findViewById(R.id.id_enregistrer_promo);

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
                String numPro = ""+numero.getText();
                if (numPro.isEmpty()) {
                    Toast.makeText(AjoutPromo.this, "Numéro obligation",Toast.LENGTH_SHORT).show();
                    return;
                }
                String debut = ""+anneeDebut.getText();
                if (debut.isEmpty()) {
                    Toast.makeText(AjoutPromo.this, "Date de debut obligation",Toast.LENGTH_SHORT).show();
                    return;
                }
                String fin = ""+anneeFin.getText();
                if (fin.isEmpty()) {
                    Toast.makeText(AjoutPromo.this, "Date de fin obligation",Toast.LENGTH_SHORT).show();
                    return;
                }
                int numP = Integer.parseInt(numPro);
                int debutP = Integer.parseInt(debut);
                int finP = Integer.parseInt(fin);
                Promotion p = new Promotion();
                p.numero = numP;
                p.debut = debutP;
                p.fin = finP;

                new Thread(){
                    @Override
                    public void run() {
                        PromotionDao promoDao = AppDataBase.getDataBase(getApplicationContext()).promotionDao();
                        promoDao.ajoutPromo(p);
                        List<Promotion> promotionList = promoDao.findAll();
                        for (Promotion pro: promotionList) {
                            Log.i("ISEPAPP",""+pro);
                        }
                        enregistrer.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(AjoutPromo.this, "Enrgistrer",Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                    }
                }
                .start();

            }
        });

    }
}