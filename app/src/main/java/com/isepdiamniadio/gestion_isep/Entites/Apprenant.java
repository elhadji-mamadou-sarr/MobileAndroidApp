package com.isepdiamniadio.gestion_isep.Entites;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "apprenants")
public class Apprenant {
    @PrimaryKey
    @NonNull
    public Integer matricule;

    public String nom;
    public String prenom;
    public String dateNaiss;
    public String adresse;
    public Integer numPromo;
    public Integer codeDept;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apprenant apprenant = (Apprenant) o;
        return Objects.equals(matricule, apprenant.matricule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule);
    }


}
