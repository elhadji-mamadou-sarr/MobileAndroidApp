package com.isepdiamniadio.gestion_isep.Entites;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.isepdiamniadio.gestion_isep.Dao.ApprenantDao;
import com.isepdiamniadio.gestion_isep.Dao.ClasseDao;
import com.isepdiamniadio.gestion_isep.Dao.DepartementDao;
import com.isepdiamniadio.gestion_isep.Dao.FormationDao;
import com.isepdiamniadio.gestion_isep.Dao.PromotionDao;


@Database(version = 2,  exportSchema = false, entities = {Departement.class, Promotion.class, Apprenant.class, Formation.class, Classe.class})
public abstract class AppDataBase extends RoomDatabase {

    private static final String DB_NAME = "gestion_ispe";

    private  static volatile AppDataBase dataBase;


    public static AppDataBase getDataBase(Context context) {
        if (dataBase == null) {
            synchronized (AppDataBase.class) {
                if (dataBase == null) {
                    dataBase = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDataBase.class, "app_database")
                            .fallbackToDestructiveMigration().build();
                }
            }
        }
        return dataBase;
    }

    public abstract DepartementDao departementDao();

    public  abstract PromotionDao promotionDao();

    public abstract ApprenantDao apprenantDao();

    public abstract FormationDao formationDao();

    public abstract ClasseDao classeDao();
}
