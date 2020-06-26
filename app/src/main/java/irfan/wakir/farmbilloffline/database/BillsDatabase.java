package irfan.wakir.farmbilloffline.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import irfan.wakir.farmbilloffline.models.Home;

@Database(entities = Home.class, version = 1, exportSchema = false)
public abstract class BillsDatabase extends RoomDatabase {
    public static BillsDatabase instance;

    public abstract BillsDao billsDao();

    static synchronized BillsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    BillsDatabase.class, "note_database")
                    .build();
        }
        return instance;
    }

}
