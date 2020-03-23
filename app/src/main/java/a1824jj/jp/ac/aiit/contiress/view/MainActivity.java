package a1824jj.jp.ac.aiit.contiress.view;

import a1824jj.jp.ac.aiit.contiress.R;
import a1824jj.jp.ac.aiit.contiress.adapter.CountryAdapter;
import a1824jj.jp.ac.aiit.contiress.model.Info;
import a1824jj.jp.ac.aiit.contiress.model.Result;
import a1824jj.jp.ac.aiit.contiress.service.GetCountryDataService;
import a1824jj.jp.ac.aiit.contiress.service.RetrofitInstance;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Result> results;
    private CountryAdapter countryAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCountries();
    }

    private Object getCountries() {

        GetCountryDataService getCountryDataService = RetrofitInstance.getService();
        Call<Info> call = getCountryDataService.getResults();

        call.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                Info info = response.body();
                if(info != null && info.getRestResponse() != null){
                    results = (ArrayList<Result>) info.getRestResponse().getResult();
                    for(Result r: results){
                        Log.e("testing123", "****************************" + r.getName());
                    }
                    viewData();
                }
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {
                Log.e("testing123", "****************************" + t.getMessage());
            }
        });

        return results;
    }

    private void viewData(){
        recyclerView = findViewById(R.id.rv_countries_list);
        countryAdapter = new CountryAdapter(results);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(countryAdapter);
    }

}
