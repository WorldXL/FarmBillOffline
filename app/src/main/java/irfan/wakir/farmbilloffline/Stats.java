package irfan.wakir.farmbilloffline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import irfan.wakir.farmbilloffline.database.BillsViewModel;
import irfan.wakir.farmbilloffline.models.Home;


public class Stats extends AppCompatActivity {

    private BillsViewModel mBillsViewModel;
    private TextView ta, tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        ta = findViewById(R.id.totalamount);
        tb = findViewById(R.id.totalbags);
        mBillsViewModel = ViewModelProviders.of(this).get(BillsViewModel.class);
        mBillsViewModel.getAllBills().observe(this, new Observer<List<Home>>() {
            @Override
            public void onChanged(List<Home> homes) {
                float total_amount = 0f;
                int total_bags = 0;
                for (int i = 0 ; i < homes.size(); i++){
                    Home home = homes.get(i);
                    total_amount = total_amount + home.getTotal_amount();
                    total_bags = total_bags + home.getTotal_bags();
                    Log.i("TAG", "getTotalAmount: "+home.getTotal_amount());
                    Log.i("TAG", "getTotalBags: "+home.getTotal_bags());
                }
                Log.i("TAG", "TotalAmount :" +total_amount);
                Log.i("TAG", "TotalBags :" +total_bags);
                ta.setText(String.valueOf(total_amount));
                tb.setText(String.valueOf(total_bags));
            }
        });
    }
}
