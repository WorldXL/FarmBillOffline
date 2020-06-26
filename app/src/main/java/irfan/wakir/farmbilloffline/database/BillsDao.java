package irfan.wakir.farmbilloffline.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

import irfan.wakir.farmbilloffline.models.Home;

@Dao
public interface BillsDao {
    @Insert
    public void insert(Home home);
    @Delete
    public void delete(Home home);

    @Query("SELECT * FROM bills_table")
    public LiveData<List<Home>> getAllBills();
}
