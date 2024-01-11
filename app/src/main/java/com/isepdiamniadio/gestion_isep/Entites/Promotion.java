package com.isepdiamniadio.gestion_isep.Entites;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;


@Entity(tableName = "promo")
public class Promotion {
    @PrimaryKey
    @NonNull
    public Integer numero;
    public Integer debut;
    public Integer fin;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Promotion promotion = (Promotion) o;
        return numero.equals(promotion.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "numero=" + numero +
                ", debut=" + debut +
                ", fin=" + fin +
                '}';
    }
}

