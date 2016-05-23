package com.zack.enderweather.network;

import com.zack.enderweather.bean.HeWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("weather")
    Call<HeWeather> getHeWeatherData(@Query("cityid") String cityId, @Query("key") String key);
}
