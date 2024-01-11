package com.isepdiamniadio.gestion_isep;

import android.annotation.SuppressLint;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.isepdiamniadio.gestion_isep.Dao.ApprenantDao;
import com.isepdiamniadio.gestion_isep.Dao.PromotionDao;
import com.isepdiamniadio.gestion_isep.Entites.AppDataBase;
import com.isepdiamniadio.gestion_isep.Entites.Apprenant;
import com.isepdiamniadio.gestion_isep.Entites.Promotion;

import java.util.List;

public class ListApprenants extends AbstractActivityMenu {

    EditText recherche;
    ListView apprenantListView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_apprenants);
        apprenantListView = findViewById(R.id.id_ListViewApprenant);
    }


    @Override
    protected void onResume() {
        super.onResume();
        new Thread(){
            @Override
            public void run() {
                ApprenantDao apprenant = AppDataBase.getDataBase(getApplicationContext()).apprenantDao();
                List<Apprenant> apprenants = apprenant.getAll();
                ApprenantAdapter apprenantAdapter = new ApprenantAdapter(ListApprenants.this, apprenants);
                apprenantListView.post(new Runnable() {
                    @Override
                    public void run() {
                        apprenantListView.setAdapter(apprenantAdapter);
                    }
                });
            }
        }.start();
    }
}