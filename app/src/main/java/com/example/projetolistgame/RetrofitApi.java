package com.example.projetolistgame;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {
    private static Retrofit retrofitInstance;
    public static Retrofit getInstance(){
        if(retrofitInstance==null){
            retrofitInstance = new Retrofit.Builder()
                    //mesmo não estando na URL,a baseURL termina com /
                    .baseUrl("https://api.rawg.io/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitInstance;
    }
}
