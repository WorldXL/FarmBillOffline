package irfan.wakir.farmbilloffline.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import  irfan.wakir.farmbilloffline.R;
import  irfan.wakir.farmbilloffline.models.Home;

public class BillsAdapter extends ListAdapter<Home, BillsAdapter.BillsHolder> {

    public interface OnBillsClickListener{
        public void onBillsClickListener(Home position);
    }

    private OnBillsClickListener mOnBillsClickListener;

    public BillsAdapter(){
        super(DIFF_CALLBACK);
    }
    private static final DiffUtil.ItemCallback<Home> DIFF_CALLBACK = new DiffUtil.ItemCallback<Home>() {
        @Override
        public boolean areItemsTheSame(@NonNull Home oldItem, @NonNull Home newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Home oldItem, @NonNull Home newItem) {
            return false;
        }
    };
   public Home getBillAt(int position){
       return getItem(position);
    }

  public   void setOnBillClickedListener(OnBillsClickListener listener){
        mOnBillsClickListener = listener;
    }

    @NonNull
    @Override
    public BillsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_bills_list_view, parent, false);
        return new BillsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillsHolder holder, final int position) {
        final Home mHome = getItem(position);
        holder.mName.setText(mHome.getName());
        holder.mState.setText(mHome.getLocation());
        holder.mPrice.setText(String.valueOf(mHome.getTotal_amount()));
        holder.mDate.setText(mHome.getDate());
        holder.mCrop.setText(mHome.getCrop());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnBillsClickListener.onBillsClickListener(getItem(position));
            }
        });
    }

    static class BillsHolder extends RecyclerView.ViewHolder{
        TextView mName, mState, mPrice, mDate, mCrop;
        public BillsHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tv_name);
            mState = itemView.findViewById(R.id.tv_state);
            mPrice = itemView.findViewById(R.id.tv_price);
            mDate = itemView.findViewById(R.id.tv_date);
            mCrop = itemView.findViewById(R.id.tv_crops);
        }
    }
}
