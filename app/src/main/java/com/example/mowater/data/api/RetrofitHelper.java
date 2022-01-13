package com.example.mowater.data.api;

import com.example.mowater.data.models.BookRentalCar.BookRentalCar;
import com.example.mowater.data.models.RentalOffices.RentalOffices;
import com.example.mowater.data.models.RentalOffiecesCategories.RentalOfficesCategories;
import com.example.mowater.data.models.Sections.Sections;
import com.example.mowater.data.models.SpecialNumberReservation.SpecialNumberReservation;
import com.example.mowater.data.models.SpecialNumbers.SpecialNumbers;
import com.example.mowater.data.models.SpecialNumbersCategories.SpecialNumbersCategories;
import com.example.mowater.data.models.agencyCategories.AgencyCategories;
import com.example.mowater.data.models.agencyDetails.AgencyDetails;
import com.example.mowater.data.models.vehicles.Vehicles;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitHelper {
    @GET("sections")
    Call<Sections> getSections();

    @GET("special-numbers-categories")
    Call<SpecialNumbersCategories> getSpecialNumbersCategories();

    @GET("special-numbers")
    Call<SpecialNumbers> getSpecialNumbers(
            @Query("category") Integer categoryId
    );

    @FormUrlEncoded
    @POST("create-special-number-reservation")
    Call<SpecialNumberReservation> reservespecialNumber(
            @Field("special_number_id") String specialNumberId,
            @Field("name") String name,
            @Field("phone") String phone,
            @Field("address") String address,
            @Header("Authorization") String authHeader);

    @GET("rental-office")
    Call<RentalOfficesCategories> getRentalOfficesCategories();

    @GET("show-rental-office")
    Call<RentalOffices> getRentalOfficeCars(
            @Query("id") Integer rentalOfficeId);

    @FormUrlEncoded
    @POST("rental-office-reservation")
    Call<BookRentalCar> bookRentalCar(
            @Field("rental_office_car_id") String rentalOfficeCarId,
            @Field("name") String name,
            @Field("phone") String phone,
            @Field("address") String address,
            @Field("start_date") String startTime,
            @Field("rental_type") String rentalType,
            @Field("payment_method_id") String PaymentMethodId,
            @Header("Authorization") String authHeader
    );

    @GET("agencies")
    Call<AgencyCategories> getAgentCategories();

    @GET("show-agency")
    Call<AgencyDetails> getAgencyDetails(
            @Query("id") Integer agencyId
    );

    @GET("vehicles")
    Call<Vehicles> getVehicles(
            // 3shan Afra2 ben Lw hast5dm El Call Dah 3shan ageb Agency car / aw grash
            @Query("model_id") Integer model_id,
            @Query("model_type") String modleType, // Agency or CarShowRoom
            @Query("car_model_id") Integer carModelId,
            @Query("car_class_id") Integer carClassId
    );

}
