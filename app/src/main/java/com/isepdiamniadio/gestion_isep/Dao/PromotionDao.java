package com.isepdiamniadio.gestion_isep.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.isepdiamniadio.gestion_isep.Entites.Promotion;

import java.util.List;

@Dao
public interface PromotionDao {

    @Query("SELECT * FROM promo")
    public List<Promotion> findAll();

    @Query("select *from promo where numero = :num")
    public List<Promotion> findByNum(Integer num);

    @Query("select * from promo where debut = :debut")
    public List<Promotion> findByDebut(Integer debut);

    @Query("select * from promo where fin = :fin")
    public List<Promotion> findByFin(Integer fin);

    @Query("select * from promo where debut between :annee1 and :annee2")
    public  List<Promotion> promoDebutEntre(Integer annee1, Integer annee2);

    @Insert
    public void ajoutPromo(Promotion p);

    @Update
    public void udaptePromo(Promotion p);

    @Delete void deletePromo(Promotion p);

}
