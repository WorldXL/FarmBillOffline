package irfan.wakir.farmbilloffline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    private Intent intent;
    private Context mContext = HomeActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void billsPanel(View view) {
        intent = new Intent(HomeActivity.this, BillsActivity.class);
        startActivity(intent);
    }

    public void weatherPanel(View view) {
    }

    public void calcPanel(View view) {
        intent = new Intent(HomeActivity.this, Calculator.class);
        startActivity(intent);
    }

    public void statsPanel(View view) {
    }

}