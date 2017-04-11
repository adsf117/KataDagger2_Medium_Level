package com.globant.andresserrano.retrofitdagger2.service.api;


import com.globant.andresserrano.retrofitdagger2.service.response.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiJsonPlaceHolder {
    @GET("/users")
    Call<List<User>> getUsers();
}
