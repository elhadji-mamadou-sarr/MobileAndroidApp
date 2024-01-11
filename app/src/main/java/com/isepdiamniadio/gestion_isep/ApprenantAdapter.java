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
import org.w3c.dom.Text;

import java.util.List;

public class ApprenantAdapter extends ArrayAdapter<Apprenant> {
    public ApprenantAdapter(@NonNull Context context, @NonNull List<Apprenant> apprenants) {
        super(context, R.layout.apprenant_item, apprenants);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.apprenant_item, parent, false);
        }

        Apprenant p = getItem(position);

        TextView nom = convertView.findViewById(R.id.id_nomAppTextView);
        nom.setText(" : "+p.nom);

        TextView prenom = convertView.findViewById(R.id.id_prenomAppTextView);
        prenom.setText(" : "+p.prenom);

        TextView promo = convertView.findViewById(R.id.id_promoTextView);
        promo.setText(" : "+p.numPromo);

        if (position % 2==0) {
            convertView.setBackgroundColor(convertView.getContext().getColor(R.color.isep_beige));
        }
        return convertView;
    }

}
