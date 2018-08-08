package ca.hjtaki.dailygoals;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CurrencyExchangeService {
    @GET("/latest?access_key=b712e0895f805deacca815de2d03d5f8&format=1")
    Call<CurrencyExchange> loadCurrencyExchange();
}


