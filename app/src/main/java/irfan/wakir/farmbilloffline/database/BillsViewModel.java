package irfan.wakir.farmbilloffline.database;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import irfan.wakir.farmbilloffline.models.Home;

public class BillsViewModel extends AndroidViewModel {

    private BillsRepository mRepository;
    private LiveData<List<Home>> mAllBills;

    public BillsViewModel(@NonNull Application application) {
        super(application);
        mRepository = new BillsRepository(application);
        mAllBills= mRepository.getAllBills();
    }
    public void insert(Home home){
        mRepository.insert(home);
    }
    public void delete(Home home){
        mRepository.delete(home);
    }
    public LiveData<List<Home>> getAllBills(){
        return mAllBills;
    }
}
