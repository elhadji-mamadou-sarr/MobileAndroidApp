package com.isepdiamniadio.gestion_isep.Entites;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
import java.util.Objects;

@Entity(tableName = "formations")
public class Formation {
    @PrimaryKey
    @NonNull
    public String code;
    public String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formation formation = (Formation) o;
        return code.equals(formation.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Formation{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
