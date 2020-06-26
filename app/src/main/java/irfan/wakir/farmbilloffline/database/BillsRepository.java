package irfan.wakir.farmbilloffline.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import irfan.wakir.farmbilloffline.models.Home;

public class BillsRepository {
    private BillsDao mBillsDao;
    private LiveData<List<Home>> mAllBills;

    public BillsRepository(Application application) {
        BillsDatabase database = BillsDatabase.getInstance(application);
        mBillsDao = database.billsDao();
        mAllBills = mBillsDao.getAllBills();
    }

    public void insert(Home home){
        new InsertBillsAsyncTask(mBillsDao).execute(home);
    }

    public void delete(Home home){
        new DeleteBillsAsyncTask(mBillsDao).execute(home);
    }

    LiveData<List<Home>> getAllBills(){
        return mAllBills;
    }

    private static class InsertBillsAsyncTask extends AsyncTask<Home, Void, Void> {

        private BillsDao mBillsDao;

        private InsertBillsAsyncTask(BillsDao billsDao) {
            mBillsDao = billsDao;
        }

        @Override
        protected Void doInBackground(Home... homes) {
            mBillsDao.insert(homes[0]);
            return null;
        }
    }

    private static class DeleteBillsAsyncTask extends AsyncTask<Home, Void, Void> {

        private BillsDao mBillsDao;

        private DeleteBillsAsyncTask(BillsDao billsDao) {
            mBillsDao = billsDao;
        }

        @Override
        protected Void doInBackground(Home... homes) {
            mBillsDao.delete(homes[0]);
            return null;
        }
    }

}
