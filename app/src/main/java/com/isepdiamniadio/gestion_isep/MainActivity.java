package com.isepdiamniadio.gestion_isep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.isepdiamniadio.gestion_isep.Entites.AppDataBase;

public class MainActivity extends AbstractActivityMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(){
            @Override
            public void run() {
                Log.i("ISEP","debut chargement de la BD");
                AppDataBase dataBase = AppDataBase.getDataBase(getApplicationContext());
            }
        }.start();

    }
}