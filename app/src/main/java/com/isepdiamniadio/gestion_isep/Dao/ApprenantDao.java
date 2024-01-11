package com.isepdiamniadio.gestion_isep.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.isepdiamniadio.gestion_isep.Entites.Apprenant;
import com.isepdiamniadio.gestion_isep.Entites.Departement;
import com.isepdiamniadio.gestion_isep.Entites.Promotion;

import java.util.List;

@Dao
public interface ApprenantDao {

    @Query("select * from apprenants")
    public List<Apprenant> getAll();

    @Query("select * from apprenants where nom like :text || '%' or prenom like :text || '%'")
    public List<Apprenant> searchApp(String text);

    @Query("select * from apprenants where numPromo = :p")
    public List<Apprenant> findByPromo(Integer p);

    @Query("select * from apprenants where codeDept = :dept")
    public List<Apprenant> findByDept(Integer dept);

    @Insert
    public void addApp(Apprenant app);

    @Delete
    public void deleteApp(Apprenant app);

    @Update
    public void updateApp(Apprenant app);


}
