package com.isepdiamniadio.gestion_isep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.isepdiamniadio.gestion_isep.Dao.PromotionDao;
import com.isepdiamniadio.gestion_isep.Entites.AppDataBase;
import com.isepdiamniadio.gestion_isep.Entites.Promotion;

import java.util.List;

public class ListPromo extends AbstractActivityMenu {

    EditText recherche;
    ListView  promoListView;
    TextView chargementTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_promo);

        recherche=findViewById(R.id.id_recherche);
       promoListView = findViewById(R.id.id_ListViewPromo);
       chargementTextView = findViewById(R.id.id_chargementPromo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        chargementTextView.setText("Chargement des promos");
        chargementTextView.setVisibility(View.VISIBLE);
        new Thread(){
            @Override
            public void run() {
                PromotionDao promotion = AppDataBase.getDataBase(getApplicationContext()).promotionDao();
                List<Promotion> promotions = promotion.findAll();
                //ArrayAdapter<Promotion> adapter = new ArrayAdapter<>(ListPromo.this, android.R.layout.simple_list_item_1, promotions);
                PromoAdapter promoAdapter = new PromoAdapter(ListPromo.this, promotions);
           promoListView.post(new Runnable() {
               @Override
               public void run() {
                   promoListView.setAdapter(promoAdapter);
                   promoAdapter.notifyDataSetChanged();
                   chargementTextView.setVisibility(View.GONE);
               }
           });
            }
        }.start();
    }
}