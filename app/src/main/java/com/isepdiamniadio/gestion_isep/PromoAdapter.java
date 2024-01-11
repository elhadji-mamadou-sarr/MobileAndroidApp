package com.isepdiamniadio.gestion_isep;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.isepdiamniadio.gestion_isep.Entites.Apprenant;
import com.isepdiamniadio.gestion_isep.Entites.Promotion;

import java.util.List;

public class
PromoAdapter extends ArrayAdapter<Promotion> {

    public PromoAdapter(@NonNull Context context, @NonNull List<Promotion> promotions) {
        super(context, R.layout.promo_item, promotions);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.promo_item, parent, false);
        }
            Promotion p = getItem(position);

            TextView titre = convertView.findViewById(R.id.titre);
            titre.setText("PROMO "+p.numero);

            TextView debut = convertView.findViewById(R.id.id_textViewDebut);
            debut.setText(" : "+p.debut);


            TextView fin = convertView.findViewById(R.id.id_textViewDebut);
            fin.setText(" : "+p.fin);

            if (position % 2==0) {
                convertView.setBackgroundColor(convertView.getContext().getColor(R.color.isep_beige));
            }
            return convertView;
    }

}
