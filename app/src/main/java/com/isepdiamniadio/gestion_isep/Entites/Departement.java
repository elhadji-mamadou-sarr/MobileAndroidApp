package com.isepdiamniadio.gestion_isep.Entites;


import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "departements")
public class Departement {
    @PrimaryKey
    @NonNull
    public String code ;
    public String nom;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departement that = (Departement) o;
        return Objects.equals(code, that.code) && Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, nom);
    }
}
