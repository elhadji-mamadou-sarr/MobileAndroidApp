package com.isepdiamniadio.gestion_isep.Entites;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "classe")
public class Classe {

    @PrimaryKey
    @NonNull
    public Integer numeroClasse;

    public String numFormation;

    public Integer numPromotion;

    public String responsable;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classe classe = (Classe) o;
        return numeroClasse.equals(classe.numeroClasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroClasse);
    }

}
