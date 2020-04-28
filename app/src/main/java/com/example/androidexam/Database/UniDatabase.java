package com.example.androidexam.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.androidexam.Dao.UniListDao;
import com.example.androidexam.Model.UniListModel;
import com.example.androidexam.UniList;

//version is very important, it has to be encreamentet by each change in database
@Database(entities = UniListModel.class, version = 1)
public abstract class UniDatabase extends RoomDatabase {

    // will return this classe to the singleton. it will ensure that we can't create mulitiple database
    private static UniDatabase instance;

    public abstract UniListDao uniListDao();

    //only one treat at the time
    public static synchronized UniDatabase getInstance(Context context) {
        //only instantiate if it is null
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), UniDatabase.class,
                    "University_database").fallbackToDestructiveMigration()
                    .addCallback(roomCallback).build();
        }
        //else return the instance
        return instance;
    }


    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new populateDbAsyncTask(instance).execute();
        }
    };

    private static class populateDbAsyncTask extends AsyncTask< Void, Void, Void > {
        private UniListDao uniListDao;

        //constructor
        private populateDbAsyncTask(UniDatabase db) {
            uniListDao = db.uniListDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            uniListDao.insert(new UniListModel("Via", "University Collage", "Horsens"));
            uniListDao.insert(new UniListModel("Aalborg University ", "University", "Aalborg"));
            uniListDao.insert(new UniListModel("Aarhus University", "University", "Aarhus"));
            uniListDao.insert(new UniListModel("Copenhagen Business School", "University", "Copenhagen"));
            uniListDao.insert(new UniListModel("IT University of Copenhagen ", "University", "Copenhagen"));
            uniListDao.insert(new UniListModel("Roskilde University", "University", "Roskilde"));
            uniListDao.insert(new UniListModel("Technical University of Denmark", "University", "Lyngby"));
            uniListDao.insert(new UniListModel("University of Copenhagen ", "University", "Copenhagen"));
            uniListDao.insert(new UniListModel("University of Southern Denmark", "University", "Odense"));
            uniListDao.insert(new UniListModel("Via", "University Collage", "Aarhus"));
            return null;
        }
    }
}
