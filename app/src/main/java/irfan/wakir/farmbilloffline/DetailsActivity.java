package irfan.wakir.farmbilloffline;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class DetailsActivity extends AppCompatActivity {

    //Widgets
    private TextView mName, mDate, mLocation, mLoad, mCrop, mTotalBags,
                    mRemainKg, mNetWeight, mGrossWeight, mTareWeight, mLabour,
                    mTransport, mWeightMachine, mCostOfBag, mTotalAmount, mExtra;




    //Variables
    private Context mContext = DetailsActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mName = findViewById(R.id.name_text);
        mDate = findViewById(R.id.date_text);
        mLocation = findViewById(R.id.location_text);
        mLoad = findViewById(R.id.load_value);
        mCrop = findViewById(R.id.crop_value);
        mTotalBags = findViewById(R.id.total_bags_value);
        mRemainKg = findViewById(R.id.remain_kgs_value);
        mNetWeight = findViewById(R.id.net_weight_value);
        mGrossWeight = findViewById(R.id.gross_weight_value);
        mTareWeight = findViewById(R.id.tare_weight_value);
        mLabour = findViewById(R.id.labour_value);
        mTransport = findViewById(R.id.transport_value);
        mWeightMachine = findViewById(R.id.weight_machine_value);
        mCostOfBag = findViewById(R.id.cob_value);
        mTotalAmount = findViewById(R.id.total_amount_value);
        mExtra = findViewById(R.id.extra_value);
        getData();
    }
    private void getData(){
        Intent intent = getIntent();
        mName.setText(intent.getStringExtra(getString(R.string.field_name)));
        mDate.setText(intent.getStringExtra(getString(R.string.field_date)));
        mLocation.setText(intent.getStringExtra(getString(R.string.field_location)));
        mLoad.setText(intent.getIntExtra(getString(R.string.field_load), 0)+"");
        mCrop.setText(intent.getStringExtra(getString(R.string.field_crop)));
        mTotalBags.setText(intent.getIntExtra(getString(R.string.field_total_bags), 0)+"");
        mExtra.setText(String.valueOf(intent.getFloatExtra(getString(R.string.field_extra), 0)));
        mRemainKg.setText(String.valueOf( intent.getFloatExtra(getString(R.string.field_remain_kgs), 0f)));
        mNetWeight.setText(String.valueOf( intent.getFloatExtra(getString(R.string.field_net_weight), 0f)));
        mGrossWeight.setText(String.valueOf( intent.getFloatExtra(getString(R.string.field_net_weight), 0f)));
        mTareWeight.setText(String.valueOf( intent.getFloatExtra(getString(R.string.field_tare_weight), 0f)));
        mLabour.setText(String.valueOf( intent.getFloatExtra(getString(R.string.field_labour), 0f)));
        mTransport.setText(String.valueOf( intent.getFloatExtra(getString(R.string.field_transport), 0f)));
        mWeightMachine.setText(String.valueOf( intent.getFloatExtra(getString(R.string.field_weight_machine), 0f)));
        mCostOfBag.setText( intent.getIntExtra(getString(R.string.field_cost_of_bags), 0)+"");
        mTotalAmount.setText(String.valueOf( intent.getFloatExtra(getString(R.string.field_total_amount), 0f)));
    }
}
