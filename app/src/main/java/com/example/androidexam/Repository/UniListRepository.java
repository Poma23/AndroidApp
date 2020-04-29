package com.example.androidexam.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import Interfaces.UniListDao;

import com.example.androidexam.Database.UniDatabase;
import com.example.androidexam.Model.UniListModel;

import java.util.List;

public class UniListRepository {

    private UniListDao uniListDao;
    private LiveData< List< UniListModel > > allUni;

    public UniListRepository(Application application) {
        UniDatabase database = UniDatabase.getInstance(application); // Room needs application
        uniListDao = database.uniListDao();
        allUni = uniListDao.getAllUni();
    }

    // the API that the repository exposes to the outside

    public void insert(UniListModel uniListModel) {
        new InsertUniAsyncTask(uniListDao).execute(uniListModel);

    }

    public void update(UniListModel uniListModel) {
        new UpdateUniAsyncTask(uniListDao).execute(uniListModel);
    }

    public void delete(UniListModel uniListModel) {
        new deleteUniAsyncTask(uniListDao).execute(uniListModel);
    }

    public void deleteAll() {
        new deleteAllUniAsyncTask(uniListDao).execute();
    }

    public LiveData< List< UniListModel > > getAllUni() {
        return allUni;
    }

    private static class InsertUniAsyncTask extends AsyncTask< UniListModel, Void, Void > {
        private UniListDao uniListDao;

        private InsertUniAsyncTask(UniListDao uniListDao) {
            this.uniListDao = uniListDao;
        }

        @Override
        protected Void doInBackground(UniListModel... uniListModels) {
            uniListDao.insert(uniListModels[0]);
            return null;
        }
    }


    private static class UpdateUniAsyncTask extends AsyncTask< UniListModel, Void, Void > {
        private UniListDao uniListDao;

        private UpdateUniAsyncTask(UniListDao uniListDao) {
            this.uniListDao = uniListDao;
        }

        @Override
        protected Void doInBackground(UniListModel... uniListModels) {
            uniListDao.update(uniListModels[0]);
            return null;
        }
    }


    private static class deleteUniAsyncTask extends AsyncTask< UniListModel, Void, Void > {
        private UniListDao uniListDao;

        private deleteUniAsyncTask(UniListDao uniListDao) {
            this.uniListDao = uniListDao;
        }

        @Override
        protected Void doInBackground(UniListModel... uniListModels) {
            uniListDao.delete(uniListModels[0]);
            return null;
        }
    }


    private static class deleteAllUniAsyncTask extends AsyncTask< Void, Void, Void > {
        private UniListDao uniListDao;

        private deleteAllUniAsyncTask(UniListDao uniListDao) {
            this.uniListDao = uniListDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            uniListDao.deleteAllUnis();
            return null;
        }
    }


}
