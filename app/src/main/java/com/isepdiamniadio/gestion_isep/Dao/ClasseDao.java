package com.isepdiamniadio.gestion_isep.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.isepdiamniadio.gestion_isep.Entites.Classe;

import java.util.List;

@Dao
public interface ClasseDao {

    @Query("SELECT * FROM classe")
    public List<Classe> findAll();


    @Query("select * from classe where responsable = :resp")
    public Classe findByResp(String resp);



    @Insert
    public void addClasse(Classe c);

    @Update
    public  void updateClasse(Classe c);

    @Delete
    public void deleteClasse(Classe c);


}
