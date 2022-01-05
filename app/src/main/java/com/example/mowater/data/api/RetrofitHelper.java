package com.example.mowater.data.api;

import com.example.mowater.data.models.Sections.Sections;
import com.example.mowater.data.models.SpecialNumbers.SpecialNumbers;
import com.example.mowater.data.models.SpecialNumbersCategories.SpecialNumbersCategories;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitHelper {
    @GET("sections")
    Call<Sections> getSections();

    @GET("special-numbers-categories")
    Call<SpecialNumbersCategories> getSpecialNumbersCategories();

    @GET("special-numbers")
    Call <SpecialNumbers> getSpecialNumbers(
            @Query("category") Integer categoryId
    );
//    @FormUrlEncoded
//    @POST("create-special-number-reservation")
//    Call<> reservespecialNumber(
//            @Field("special_number_id") String specialNumberId,
//            @Field("name") String name,
//            @Field("phone") String phone,
//            @Field("address") String address,
//            @Header("Authorization") String authHeader);



}
