package com.isepdiamniadio.gestion_isep;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.isepdiamniadio.gestion_isep.Entites.Formation;
import com.isepdiamniadio.gestion_isep.Entites.Promotion;

import java.util.List;

public class FormationAdapter extends ArrayAdapter<Formation> {

    public FormationAdapter(@NonNull Context context, @NonNull List<Formation> objects) {
        super(context, R.layout.formation_item, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.formation_item, parent, false);
        }

        Formation p = getItem(position);


        TextView code = convertView.findViewById(R.id.id_textViewFor_Code);
        code.setText(" : "+p.code);


        TextView desc = convertView.findViewById(R.id.id_textViewFor_Desc);
        desc.setText(" : "+p.description);

        if (position % 2==0) {
            convertView.setBackgroundColor(convertView.getContext().getColor(R.color.isep_beige));
        }
        return convertView;
    }


}
