package a1824jj.jp.ac.aiit.contiress.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import a1824jj.jp.ac.aiit.contiress.R;
import a1824jj.jp.ac.aiit.contiress.model.Result;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryAdapter extends  RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private ArrayList<Result> countriesList;

    public CountryAdapter(ArrayList<Result> countriesList){
        this.countriesList = countriesList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.countryNameTextView.setText(countriesList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return countriesList.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder{
        TextView countryNameTextView;

        public CountryViewHolder(View itemView){
            super(itemView);
            countryNameTextView = itemView.findViewById(R.id.tv_country_name);
        }
    }

}
