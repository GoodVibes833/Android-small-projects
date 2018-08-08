package com.example.tomm.currencyexchange;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tomm on 4/4/16 AD.
 */
public interface CurrencyExchangeService {
    @GET("latest")
    Call<CurrencyExchange> loadCurrencyExchange();
}
