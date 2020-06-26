package irfan.wakir.farmbilloffline;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import irfan.wakir.farmbilloffline.models.Home;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BillFormActivity extends AppCompatActivity {

    private HashMap<TextInputLayout, String> dict;
    private TextInputLayout date;
    private TextInputLayout load;
    private TextInputLayout location;
    private TextInputLayout name, crop;
    private TextInputLayout gross_weight, net_weight, tare_weight;
    private TextInputLayout labour_cost, load_transport, extra, weight_machine;
    private TextInputLayout total_amount, remain_kg, total_bags, cost_of_a_bag;
    private float nett, amount, remain, bags;
    private Home home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_form);

        date = findViewById(R.id.date);
        date.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BillFormActivity.this.showDateDialog();
            }
        });


        load = findViewById(R.id.load);
        location = findViewById(R.id.location);
        crop = findViewById(R.id.crop);
        name = findViewById(R.id.name);
        gross_weight = findViewById(R.id.gross_weight);
        net_weight =  findViewById(R.id.net_weight);
        tare_weight = findViewById(R.id.tare_weight);
        labour_cost = findViewById(R.id.labour);
        load_transport = findViewById(R.id.transport);
        extra = findViewById(R.id.extra);
        weight_machine = findViewById(R.id.weight_machine);
        total_amount = findViewById(R.id.total_amount);
        remain_kg = findViewById(R.id.remain_kgs);
        total_bags = findViewById(R.id.total_bags);
        cost_of_a_bag = findViewById(R.id.cost_of_a_bag);

        dict = new HashMap<>();

    }

    public void showDateDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateOnDateSetListener,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
        datePickerDialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(Color.BLUE);
        datePickerDialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(Color.BLUE);
    }

    private DatePickerDialog.OnDateSetListener dateOnDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
            selectedMonth = selectedMonth + 1;
            Objects.requireNonNull(date.getEditText()).setText(selectedDay +"-"+"0"+selectedMonth+"-"+ selectedYear);
        }
    };

    public void storeData(View view) {

        if (date.getEditText().getText().toString().isEmpty() ||
                location.getEditText().getText().toString().isEmpty() ||
                name.getEditText().getText().toString().isEmpty() ||
                crop.getEditText().getText().toString().isEmpty() ||
                load.getEditText().getText().toString().isEmpty() ||
                total_bags.getEditText().getText().toString().isEmpty() ||
                remain_kg.getEditText().getText().toString().isEmpty() ||
                weight_machine.getEditText().getText().toString().isEmpty() ||
                gross_weight.getEditText().getText().toString().isEmpty() ||
                net_weight.getEditText().getText().toString().isEmpty() ||
                tare_weight.getEditText().getText().toString().isEmpty() ||
                labour_cost.getEditText().getText().toString().isEmpty() ||
                load_transport.getEditText().getText().toString().isEmpty() ||
                extra.getEditText().getText().toString().isEmpty() ||
                total_amount.getEditText().getText().toString().isEmpty() ||
                cost_of_a_bag.getEditText().getText().toString().isEmpty()){
            Toast.makeText(this, "Fields should not be empty", Toast.LENGTH_SHORT).show();
        }else {
            String date_s = date.getEditText().getText().toString();
            String location_s = location.getEditText().getText().toString();
            String name_s = name.getEditText().getText().toString();
            String crop_s = crop.getEditText().getText().toString();
            int load_s = Integer.parseInt(load.getEditText().getText().toString());
            int total_bags_s = Integer.parseInt(total_bags.getEditText().getText().toString());
            float remain_kgs_s = Float.parseFloat(remain_kg.getEditText().getText().toString());
            float weight_mach_s =Float.parseFloat( weight_machine.getEditText().getText().toString());
            float gross_weight_s = Float.parseFloat(gross_weight.getEditText().getText().toString());
            float net_weight_s = Float.parseFloat(net_weight.getEditText().getText().toString());
            float tare_weight_s =Float.parseFloat( tare_weight.getEditText().getText().toString());
            float labour_cost_s = Float.parseFloat(labour_cost.getEditText().getText().toString());
            float load_transport_s = Float.parseFloat(load_transport.getEditText().getText().toString());
            float extra_s = Float.parseFloat(extra.getEditText().getText().toString());
            float total_amount_s = Float.parseFloat(total_amount.getEditText().getText().toString());
            int cost_of_a_bag_s = Integer.parseInt(cost_of_a_bag.getEditText().getText().toString());
            Intent intent = new Intent();
            intent.putExtra(getString(R.string.field_date), date_s);
            intent.putExtra(getString(R.string.field_location), location_s);
            intent.putExtra(getString(R.string.field_name), name_s);
            intent.putExtra(getString(R.string.field_crop), crop_s);
            intent.putExtra(getString(R.string.field_load), load_s);
            intent.putExtra(getString(R.string.field_total_bags), total_bags_s);
            intent.putExtra(getString(R.string.field_remain_kgs), remain_kgs_s);
            intent.putExtra(getString(R.string.field_weight_machine), weight_mach_s);
            intent.putExtra(getString(R.string.field_gross_weight), gross_weight_s);
            intent.putExtra(getString(R.string.field_net_weight), net_weight_s);
            intent.putExtra(getString(R.string.field_tare_weight), tare_weight_s);
            intent.putExtra(getString(R.string.field_labour), labour_cost_s);
            intent.putExtra(getString(R.string.field_transport), load_transport_s);
            intent.putExtra(getString(R.string.field_extra), extra_s);
            intent.putExtra(getString(R.string.field_total_amount), total_amount_s);
            intent.putExtra(getString(R.string.field_cost_of_bags), cost_of_a_bag_s);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    public void calculateB(View view){
        sum();
    }

    public boolean check(HashMap<TextInputLayout, String> dict) {
        boolean str = true;
        for (Map.Entry<TextInputLayout, String> entry : dict.entrySet()) {
            if(entry.getValue().equals("")) {
                if(Objects.equals(entry.getKey().getHint(), "Date")) {
                    Toast.makeText(getApplicationContext(),"Enter Date Please", Toast.LENGTH_LONG).show();
                    str = false;
                } else {
                    entry.getKey().setError("Please enter a value");
                    entry.getKey().setErrorEnabled(true);
                    str = false;
                }
            } else {
                entry.getKey().setErrorEnabled(false);
            }
        }
        return str;
    }

    public void calculateN(){
        nett = Float.parseFloat(Objects.requireNonNull(gross_weight.getEditText()).getText().toString()) - Float.parseFloat(Objects.requireNonNull(tare_weight.getEditText()).getText().toString());
        bags = (int)(nett/78);
        float a = nett/78-bags;
        remain = (int)(((a*100)*78)/100);
        amount = Float.parseFloat(Objects.requireNonNull(labour_cost.getEditText()).getText().toString())*bags +
                Float.parseFloat(Objects.requireNonNull(load_transport.getEditText()).getText().toString())*bags +
                Float.parseFloat(Objects.requireNonNull(extra.getEditText()).getText().toString()) +
                Float.parseFloat(Objects.requireNonNull(weight_machine.getEditText()).getText().toString()) + (bags * Integer.parseInt(cost_of_a_bag.getEditText().getText().toString())) + (remain * (int)(Integer.parseInt(cost_of_a_bag.getEditText().getText().toString())/78));
    }

    public boolean sum(){
        dict.put(date, Objects.requireNonNull(date.getEditText()).getText().toString());
        dict.put(load, Objects.requireNonNull(load.getEditText()).getText().toString());
        dict.put(location, Objects.requireNonNull(location.getEditText()).getText().toString());
        dict.put(name, Objects.requireNonNull(name.getEditText()).getText().toString());
        dict.put(gross_weight, Objects.requireNonNull(gross_weight.getEditText()).getText().toString());
        dict.put(tare_weight, Objects.requireNonNull(tare_weight.getEditText()).getText().toString());
        dict.put(labour_cost, Objects.requireNonNull(labour_cost.getEditText()).getText().toString());
        dict.put(load_transport, Objects.requireNonNull(load_transport.getEditText()).getText().toString());
        dict.put(extra, Objects.requireNonNull(extra.getEditText()).getText().toString());
        dict.put(weight_machine, Objects.requireNonNull(weight_machine.getEditText()).getText().toString());
        dict.put(cost_of_a_bag, Objects.requireNonNull(cost_of_a_bag.getEditText()).getText().toString());


        if(check(dict)){
            calculateN();
            Objects.requireNonNull(net_weight.getEditText()).setText(String.valueOf(nett));
            Objects.requireNonNull(total_bags.getEditText()).setText(String.valueOf((int)bags));
            Objects.requireNonNull(remain_kg.getEditText()).setText(String.valueOf(remain));
            Objects.requireNonNull(total_amount.getEditText()).setText(String.valueOf(amount));
            return true;

        }

        return false;
    }


}