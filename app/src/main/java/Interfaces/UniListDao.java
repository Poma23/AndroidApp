package Interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidexam.Model.UniListModel;

import java.util.List;

@Dao
public interface UniListDao // here we dont provide any method, Room will generate all the nessesary
{
    @Insert
    void insert(UniListModel uni);

    @Update
    void update(UniListModel uni);

    @Delete
    void delete(UniListModel uni);

    @Query("DELETE FROM University")
    void deleteAllUnis();

    @Query("SELECT * FROM University")
        //uni list will be updated by liveData,observers
    LiveData< List< UniListModel > > getAllUni();


}
