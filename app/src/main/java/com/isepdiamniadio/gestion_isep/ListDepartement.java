
package com.isepdiamniadio.gestion_isep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.isepdiamniadio.gestion_isep.Dao.DepartementDao;
import com.isepdiamniadio.gestion_isep.Dao.PromotionDao;
import com.isepdiamniadio.gestion_isep.Entites.AppDataBase;
import com.isepdiamniadio.gestion_isep.Entites.Departement;
import com.isepdiamniadio.gestion_isep.Entites.Promotion;

import java.util.List;

public class ListDepartement extends AbstractActivityMenu {

    ListView departementListView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_departement);
        departementListView = findViewById(R.id.id_ListViewDepartement) ;
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Thread(){
            @Override
            public void run() {
                DepartementDao departement = AppDataBase.getDataBase(getApplicationContext()).departementDao();
                List<Departement> departementList = departement.findAll();
                //ArrayAdapter<Promotion> adapter = new ArrayAdapter<>(ListPromo.this, android.R.layout.simple_list_item_1, promotions);
                DepartementAdapter promoAdapter = new DepartementAdapter(ListDepartement.this, departementList);
                departementListView.post(new Runnable() {
                    @Override
                    public void run() {
                        departementListView.setAdapter(promoAdapter);
                        promoAdapter.notifyDataSetChanged();
                    }
                });
            }
        }.start();
    }


}