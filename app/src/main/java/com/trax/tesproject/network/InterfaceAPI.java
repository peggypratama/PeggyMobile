package com.trax.tesproject.network;

import com.trax.tesproject.model.Base;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InterfaceAPI {
    @POST("/login")
    @FormUrlEncoded
    Call<Base> login(
            @Field("password") String password,
            @Field("username") String username
    );

    @POST("/register")
    @FormUrlEncoded
    Call<Base> register(
            @Field("email") String email,
            @Field("password") String password,
            @Field("username") String username
    );

//    @POST("/checklist")
//    @FormUrlEncoded
//
}
