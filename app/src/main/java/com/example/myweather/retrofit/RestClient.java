package com.example.myweather.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
        private static final String BASE_URL = "http://api.openweathermap.org/";

        private static Retrofit retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        public static WeatherService weatherService = retrofit.create(WeatherService.class);
}
