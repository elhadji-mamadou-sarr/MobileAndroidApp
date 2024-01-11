package com.isepdiamniadio.gestion_isep.Dao;

import androidx.room.*;

import com.isepdiamniadio.gestion_isep.Entites.Departement;

import java.util.List;

@Dao
public interface DepartementDao {

    @Query("SELECT * FROM departements")
    public List<Departement> findAll();

   @Query("select * from departements where code like :text || '%' or nom like :text || '%'")
    public Departement searchAll(String text);

    @Query("SELECT * FROM departements where code = :codeDept")
    public Departement findByCode(String codeDept);

    @Insert
    public void ajoutDepartement(Departement departement);

    @Delete
    public void suppDepartement(Departement departement);

    @Update
    public void modifiertDepartement(Departement departement);

}
