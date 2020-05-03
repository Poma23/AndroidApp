package com.example.androidexam.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.androidexam.Model.UniListModel;

import Interfaces.UniListDao;

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

            uniListDao.insert(new UniListModel("Aalborg University (AAU) ", "Aalborg University (AAU) has been providing students " +
                    "with academic excellence, cultural engagement and personal development since its inception in 1974. It offers education " +
                    "and research within the fields of natural sciences, social sciences, humanities, technical and health sciences"));
            uniListDao.insert(new UniListModel("Aarhus University", "Aarhus University is a young, modern university established " +
                    "in 1928. It has grown to become a leading public research university with international reach covering the entire research spectrum."));
            uniListDao.insert(new UniListModel("Copenhagen Business School", "Copenhagen Business School (CBS) was " +
                    "established in 1917. Today, with over 22,000 students and 1,500 employees, CBS is one of the largest business schools " +
                    "in Europe and one of the 8 Danish universities"));
            uniListDao.insert(new UniListModel("IT University of Copenhagen ", "The IT University of Copenhagen is an " +
                    "independent educational and research institution, dedicated to the digital world. The university works to make " +
                    "Denmark exceptionally good at making value through IT by providing contemporary study programmes and research at " +
                    "the highest academic level."));
            uniListDao.insert(new UniListModel("Roskilde University (RUC)", "Roskilde University (RUC) is a Danish public " +
                    "university founded in 1972 and located in Trekroner in the Eastern part of Roskilde. Roskilde University offers " +
                    "higher education at bachelor-, master, and Ph.D. levels within four main areas: humanities, humanistic technologies, " +
                    "social science and science."));
            uniListDao.insert(new UniListModel("Technical University of Denmark", "The Technical University of Denmark (DTU) is a " +
                    "leading technical university with a world-class reputation. One fifth of DTU's scientific staff is recruited internationally " +
                    "and an increasing number of the students are also from abroad. DTU has contributed to Denmark achieving a leading position within " +
                    "Technical Design, Wind Energy, Biotechnology, Electronics and Telecommunication."));
            uniListDao.insert(new UniListModel("University of Copenhagen ", "With over 38,000 students and more than 9,000 employees, " +
                    "the University of Copenhagen is one of the largest institutions of research and education in the Nordic countries. The University " +
                    "offers more than 200 study programmes in health sciences, humanities, law, life sciences, pharmaceutical sciences, natural sciences, " +
                    "social sciences, and theology."));
            uniListDao.insert(new UniListModel("University of Southern Denmark", "The University of Southern Denmark (SDU) offers " +
                    "world class education and is committed to an international perspective, at all levels. The largest campus is located in the " +
                    "city of Odense (Funen) and other campuses are located in the cities of Kolding, Esbjerg, Sønderborg (Jutland) and Slagelse (Zealand)."));

            return null;
        }
    }
}
