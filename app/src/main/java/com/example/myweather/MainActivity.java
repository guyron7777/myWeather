package com.example.myweather;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myweather.models.WeatherObj;
import com.example.myweather.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    TextView weatherText;
    Button weatherButton;
    String city = "haifa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        weatherText = findViewById(R.id.weather_text);
        weatherButton = findViewById(R.id.weather_button);
        weatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeather();
            }
        });
    }

    private void getWeather() {
        Call<WeatherObj> call = RestClient.weatherService.getWeatherInCity("32f1f41c2961e8741f6ce3e6bd3a214a", city);
        call.enqueue(new Callback<WeatherObj>() {
            @Override
            public void onResponse(Call<WeatherObj> call, Response<WeatherObj> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.v("response", "" + response.toString());
                    weatherText.setText(response.body().getCurrentWeather() + " celcius in "+city);
                }
            }

            @Override
            public void onFailure(Call<WeatherObj> call, Throwable t) {
                Log.v("response fails", "" + t.getMessage());
            }
        });
    }
}