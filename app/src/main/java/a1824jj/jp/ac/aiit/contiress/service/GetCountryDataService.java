package a1824jj.jp.ac.aiit.contiress.service;

import a1824jj.jp.ac.aiit.contiress.model.Info;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryDataService {

    @GET("country/get/all")
    Call<Info> getResults();

}
