package com.isepdiamniadio.gestion_isep;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public abstract class AbstractActivityMenu extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.all_menu_use_case, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      int itemId = item.getItemId();
        Intent i;
      switch (itemId){
          case R.id.itemListApprenant:
              Log.i("ISEPAPP", "click sur liste Apprenant");
               i = new Intent(this, ListApprenants.class);
              startActivity(i);
              break;
          case R.id.itemAddApp:
              Log.i("ISEPAPP", "Click sur Ajouter un Apprenat");
               i = new Intent(this, AjouterApprenant.class);
              startActivity(i);
              break;
          case R.id.itemajoutFormateur:
              Log.i("ISEPAPP", "click sur Ajouter une formation");
              i = new Intent(this, AjouterFormation.class);
              startActivity(i);
              break;
          case R.id.itemListformateur:
              //Lister les promotion
              i = new Intent(this, ListFormation.class);
              startActivity(i);
              break;
          case R.id.itemajoutPromotion:
                //Ajouter une promtion
              i = new Intent(this, AjoutPromo.class);
              startActivity(i);
              break;
          case R.id.itemListPromotion:
              //Lister les promotion
              i = new Intent(this, ListPromo.class);
              startActivity(i);
              break;
          case R.id.itemajoutDepartement:
              //Lister les promotion
              i = new Intent(this, AjouterDepartement.class);
              startActivity(i);
              break;
          case R.id.itemListDepartement:
              //Lister les promotion
              i = new Intent(this, ListDepartement.class);
              startActivity(i);
              break;



          default:
              String titre = ""+item.getTitle();
              Toast.makeText(this, titre+" nom implementer", Toast.LENGTH_SHORT).show();
      }
        return  true;
    }
}
