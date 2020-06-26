package irfan.wakir.farmbilloffline.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bills_table")
public class Home {

   @PrimaryKey(autoGenerate = true)
    private int id;

    private String date;
    private String location;
    private String name;
    private String crop;


    private int load;
    private int total_bags;
    private float remain_kg;
    private float weight_mach;
    private float gross_weight;
    private float net_weight;
    private float tare_weight;
    private float labour_cost;
    private float load_transport;
    private float extra;
    private float total_amount;
    private int cost_of_a_bag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost_of_a_bag() {
        return cost_of_a_bag;
    }

    public void setCost_of_a_bag(int cost_of_a_bag) {
        this.cost_of_a_bag = cost_of_a_bag;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public int getTotal_bags() {
        return total_bags;
    }

    public void setTotal_bags(int total_bags) {
        this.total_bags = total_bags;
    }

    public float getRemain_kg() {
        return remain_kg;
    }

    public void setRemain_kg(float remain_kg) {
        this.remain_kg = remain_kg;
    }

    public float getWeight_mach() {
        return weight_mach;
    }

    public void setWeight_mach(float weight_mach) {
        this.weight_mach = weight_mach;
    }

    public float getGross_weight() {
        return gross_weight;
    }

    public void setGross_weight(float gross_weight) {
        this.gross_weight = gross_weight;
    }

    public float getNet_weight() {
        return net_weight;
    }

    public void setNet_weight(float net_weight) {
        this.net_weight = net_weight;
    }

    public float getTare_weight() {
        return tare_weight;
    }

    public void setTare_weight(float tare_weight) {
        this.tare_weight = tare_weight;
    }

    public float getLabour_cost() {
        return labour_cost;
    }

    public void setLabour_cost(float labour_cost) {
        this.labour_cost = labour_cost;
    }

    public float getLoad_transport() {
        return load_transport;
    }

    public void setLoad_transport(float load_transport) {
        this.load_transport = load_transport;
    }

    public float getExtra() {
        return extra;
    }

    public void setExtra(float extra) {
        this.extra = extra;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public Home() {
    }

    public Home( String date, String location, String name,
                 String crop, int load, int total_bags, float remain_kg,
                 float weight_mach, float gross_weight, float net_weight,
                 float tare_weight, float labour_cost, float load_transport,
                 float extra, float total_amount, int cost_of_a_bag) {
        this.date = date;
        this.location = location;
        this.name = name;
        this.crop = crop;
        this.load = load;
        this.total_bags = total_bags;
        this.remain_kg = remain_kg;
        this.weight_mach = weight_mach;
        this.gross_weight = gross_weight;
        this.net_weight = net_weight;
        this.tare_weight = tare_weight;
        this.labour_cost = labour_cost;
        this.load_transport = load_transport;
        this.extra = extra;
        this.total_amount = total_amount;
        this.cost_of_a_bag = cost_of_a_bag;
    }
}
