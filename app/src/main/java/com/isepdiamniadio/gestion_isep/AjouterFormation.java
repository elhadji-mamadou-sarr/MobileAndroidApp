package com.isepdiamniadio.gestion_isep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.isepdiamniadio.gestion_isep.Dao.FormationDao;
import com.isepdiamniadio.gestion_isep.Dao.PromotionDao;
import com.isepdiamniadio.gestion_isep.Entites.AppDataBase;
import com.isepdiamniadio.gestion_isep.Entites.Formation;
import com.isepdiamniadio.gestion_isep.Entites.Promotion;

import java.util.List;

public class AjouterFormation extends AbstractActivityMenu {

    Button annuler;
    Button enregistrer;
    EditText code, description;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_formation);

        code = findViewById(R.id.id_codeFor_editext);
        description = findViewById(R.id.id_descFor_Edit);
        annuler = findViewById(R.id.id_annuler_formation);
        enregistrer = findViewById(R.id.id_enregistrer_formation);

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
                String codeF = ""+code.getText();
                if (codeF.isEmpty()) {
                    Toast.makeText(AjouterFormation.this, "code formation obligation",Toast.LENGTH_SHORT).show();
                    return;
                }
                String desc = ""+description.getText();
                if (desc.isEmpty()) {
                    Toast.makeText(AjouterFormation.this, "Description obligation",Toast.LENGTH_SHORT).show();
                    return;
                }

                Formation frmt = new Formation();
                frmt.code = codeF;
                frmt.description = desc;

                new Thread(){
                    @Override
                    public void run() {
                        FormationDao formationDao = AppDataBase.getDataBase(getApplicationContext()).formationDao();
                        formationDao.addFormation(frmt);
                        List<Formation> formationList = formationDao.findAll();
                        for (Formation frmt: formationList) {
                            Log.i("ISEP", ""+frmt);
                        }
                        enregistrer.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(AjouterFormation.this, "Enrgistrer",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }.start();
            }
        });


    }
}