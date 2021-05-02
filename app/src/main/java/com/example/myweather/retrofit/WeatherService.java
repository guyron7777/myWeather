package com.example.myweather.retrofit;

import com.example.myweather.models.WeatherObj;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    // http://api.openweathermap.org/data/2.5/weather?q=haifa&appid=32f1f41c2961e8741f6ce3e6bd3a214a
    @GET("data/2.5/weather")
    Call<WeatherObj> getWeatherInCity(@Query("appid") String Id, @Query("q") String city);

}
