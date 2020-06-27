package irfan.wakir.farmbilloffline;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import irfan.wakir.farmbilloffline.adapters.BillsAdapter;
import irfan.wakir.farmbilloffline.database.BillsViewModel;
import irfan.wakir.farmbilloffline.models.Home;

public class BillsActivity extends AppCompatActivity {

    private static final int ADD_BILL_RESULT = 1;
    private RecyclerView mRecyclerView;
    private Context mContext = BillsActivity.this;
    private BillsAdapter mBillsAdapter;

    private BillsViewModel mBillsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mBillsAdapter = new BillsAdapter();
        mRecyclerView.setAdapter(mBillsAdapter);
        mBillsViewModel = ViewModelProviders.of(this).get(BillsViewModel.class);
        mBillsViewModel.getAllBills().observe(this, new Observer<List<Home>>() {
            @Override
            public void onChanged(List<Home> homes) {
                mBillsAdapter.submitList(homes);
            }
        });

       new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
           @Override
           public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
               return false;
           }

           @Override
           public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int direction) {
               final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
               builder.setTitle("Delete");
               builder.setMessage("Are you sure you want to delete this Bill");
               builder.setCancelable(false);
               builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                        mBillsViewModel.delete(mBillsAdapter.getBillAt(viewHolder.getAdapterPosition()));
                       Toast.makeText(mContext, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                   }
               });
               builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       mRecyclerView.setAdapter(mBillsAdapter);
                       dialog.cancel();
                   }
               });
               builder.show();
           }
       }).attachToRecyclerView(mRecyclerView);
        mBillsAdapter.setOnBillClickedListener(new BillsAdapter.OnBillsClickListener() {
            @Override
            public void onBillsClickListener(Home mHome) {
                Intent intent = new Intent(BillsActivity.this, DetailsActivity.class);
                intent.putExtra(getString(R.string.field_name), mHome.getName());
                intent.putExtra(getString(R.string.field_date), mHome.getDate());
                intent.putExtra(getString(R.string.field_location), mHome.getLocation());
                intent.putExtra(getString(R.string.field_load), mHome.getLoad());
                intent.putExtra(getString(R.string.field_crop), mHome.getCrop());
                intent.putExtra(getString(R.string.field_total_bags), mHome.getTotal_bags());
                intent.putExtra(getString(R.string.field_remain_kgs), mHome.getRemain_kg());
                intent.putExtra(getString(R.string.field_net_weight), mHome.getNet_weight());
                intent.putExtra(getString(R.string.field_gross_weight), mHome.getGross_weight());
                intent.putExtra(getString(R.string.field_tare_weight), mHome.getTare_weight());
                intent.putExtra(getString(R.string.field_labour), mHome.getLabour_cost());
                intent.putExtra(getString(R.string.field_transport), mHome.getLoad_transport());
                intent.putExtra(getString(R.string.field_weight_machine), mHome.getWeight_mach());
                intent.putExtra(getString(R.string.field_cost_of_bags), mHome.getCost_of_a_bag());
                intent.putExtra(getString(R.string.field_total_amount), mHome.getTotal_amount());
                intent.putExtra(getString(R.string.field_extra), mHome.getExtra());
                startActivity(intent);
                Log.i("TAG", "onBillsClickListener: " + mHome.getCost_of_a_bag());
            }
        });

    }
    public void addBill(View view) {
        Intent intent = new Intent(BillsActivity.this, BillFormActivity.class);
        startActivityForResult(intent, ADD_BILL_RESULT);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_BILL_RESULT  && resultCode == RESULT_OK){
            assert data != null;
            String date_s = data.getStringExtra(getString(R.string.field_date));
            String location_s =  data.getStringExtra(getString(R.string.field_location));
            String name_s =  data.getStringExtra(getString(R.string.field_name));
            String crop_s = data.getStringExtra(getString(R.string.field_crop));
            int load_s =  data.getIntExtra(getString(R.string.field_load), 0);
            int total_bags_s = data.getIntExtra(getString(R.string.field_total_bags), 0);
            float remain_kgs_s = data.getFloatExtra(getString(R.string.field_remain_kgs), 0);
            float weight_mach_s =  data.getFloatExtra(getString(R.string.field_weight_machine), 0);
            float gross_weight_s = data.getFloatExtra(getString(R.string.field_gross_weight), 0);
            float net_weight_s = data.getFloatExtra(getString(R.string.field_net_weight), 0);
            float tare_weight_s =  data.getFloatExtra(getString(R.string.field_tare_weight), 0);
            float labour_cost_s =  data.getFloatExtra(getString(R.string.field_labour), 0);
            float load_transport_s =  data.getFloatExtra(getString(R.string.field_transport), 0);
            float extra_s =  data.getFloatExtra(getString(R.string.field_extra), 0);
            float total_amount_s =  data.getFloatExtra(getString(R.string.field_total_amount), 0);
            int cost_of_a_bag_s = data.getIntExtra(getString(R.string.field_cost_of_bags), 0);
            Home home = new Home(date_s, location_s, name_s, crop_s, load_s, total_bags_s, remain_kgs_s,
                    weight_mach_s, gross_weight_s, net_weight_s, tare_weight_s, labour_cost_s, load_transport_s,
                    extra_s, total_amount_s, cost_of_a_bag_s);
            mBillsViewModel.insert(home);
            Toast.makeText(mContext, "Bill saved", Toast.LENGTH_SHORT).show();
        }
    }
}