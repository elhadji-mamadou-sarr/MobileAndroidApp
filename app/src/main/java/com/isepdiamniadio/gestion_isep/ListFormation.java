package com.isepdiamniadio.gestion_isep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.isepdiamniadio.gestion_isep.Dao.FormationDao;
import com.isepdiamniadio.gestion_isep.Dao.PromotionDao;
import com.isepdiamniadio.gestion_isep.Entites.AppDataBase;
import com.isepdiamniadio.gestion_isep.Entites.Formation;
import com.isepdiamniadio.gestion_isep.Entites.Promotion;

import java.util.List;

public class ListFormation extends AbstractActivityMenu {

    ListView formationListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_formation);
        formationListView=findViewById(R.id.id_ListViewFormation);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Thread(){
            @Override
            public void run() {
                FormationDao formation = AppDataBase.getDataBase(getApplicationContext()).formationDao();
                List<Formation> promotions = formation.findAll();
                //ArrayAdapter<Promotion> adapter = new ArrayAdapter<>(ListPromo.this, android.R.layout.simple_list_item_1, promotions);
                FormationAdapter formationAdapter = new FormationAdapter(ListFormation.this, promotions);
                formationListView.post(new Runnable() {
                    @Override
                    public void run() {
                        formationListView.setAdapter(formationAdapter);
                        formationAdapter.notifyDataSetChanged();

                    }
                });
            }
        }.start();

    }
}