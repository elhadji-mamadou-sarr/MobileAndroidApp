package com.isepdiamniadio.gestion_isep;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.isepdiamniadio.gestion_isep.Entites.Departement;
import com.isepdiamniadio.gestion_isep.Entites.Promotion;

import java.util.List;

public class DepartementAdapter extends ArrayAdapter<Departement> {
    public DepartementAdapter(@NonNull Context context, @NonNull List<Departement> objects) {
        super(context, R.layout.departement_item, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.departement_item, parent, false);
        }

        Departement dept = getItem(position);

        TextView code = convertView.findViewById(R.id.id_textViewDepart_code);
        code.setText(" : "+dept.code);

        TextView nom = convertView.findViewById(R.id.id_textViewDepart_nom);
        nom.setText(" : "+dept.nom);

        if (position % 2==0) {
            convertView.setBackgroundColor(convertView.getContext().getColor(R.color.isep_beige));
        }
        return  convertView;

    }
}
