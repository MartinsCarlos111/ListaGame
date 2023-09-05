package com.example.projetolistgame;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GameAPIService {
    final String KEY = "games?key=eff3225a572d4b8b974c0e212560841f";
    @GET(KEY)
    Call<Results> getGameByName(@Query("search") String name);
    @GET(KEY)
    Call<Results> getGameByGender(@Query("gender") String gender);
}
