package com.isepdiamniadio.gestion_isep.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.isepdiamniadio.gestion_isep.Entites.Formation;

import java.util.List;

@Dao
public interface FormationDao {

    @Query("select * from formations")
    public List<Formation> findAll();

    @Query("select * from formations where code =:codeF")
    public  List<Formation> findByCode(String codeF);

    @Insert
    public void addFormation(Formation ft);

    @Delete
    public void deleteFormation(Formation ft);

    @Update
    public  void updateFormation(Formation ft);


}
