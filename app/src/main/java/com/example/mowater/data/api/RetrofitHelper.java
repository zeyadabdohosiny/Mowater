package com.example.mowater.data.api;

import com.example.mowater.data.models.BookRentalCar.BookRentalCar;
import com.example.mowater.data.models.Brands.BrandsResponse;
import com.example.mowater.data.models.CarShowRoom.CarShowRoomResponse;
import com.example.mowater.data.models.CarShowRoomDetails.CarShowRoomDetailsResponse;
import com.example.mowater.data.models.CarsForSale.CarsForSaleResponse;
import com.example.mowater.data.models.RentalOffices.RentalOffices;
import com.example.mowater.data.models.RentalOffiecesCategories.RentalOfficesCategories;
import com.example.mowater.data.models.Sections.Sections;
import com.example.mowater.data.models.SpecialNumberReservation.SpecialNumberReservation;
import com.example.mowater.data.models.SpecialNumbers.SpecialNumbers;
import com.example.mowater.data.models.SpecialNumbersCategories.SpecialNumbersCategories;
import com.example.mowater.data.models.Time.AvailableTimeResponse;
import com.example.mowater.data.models.agencyCategories.AgencyCategories;
import com.example.mowater.data.models.agencyDetails.AgencyDetails;
import com.example.mowater.data.models.register.Register;
import com.example.mowater.data.models.resrveVhicle.ReserveVehicle;
import com.example.mowater.data.models.vehicle.Vehicle;
import com.example.mowater.data.models.vehicles.Vehicles;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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

    @GET("show-vehicle")
    Call<Vehicle> getVehicle(
            @Query("id") Integer vehicleId
    );
//    @FormUrlEncoded
//    @POST("reserve-vehicle")
//    Call<ReserveVehicle> reserveVehicle(
//            @Field("vehicle_id") String vehicleId,
//            @Field("name") String name,
//            @Field("phone") String phone,
//            @Field("address") String adress,
//            @Field("driving_license_front") String drivingLicenseFront,
//            @Field("driving_license_back")String driving_license_back,
//            @Field("personal_ID_front")String personal_ID_front,
//            @Field("personal_ID_back")String personal_ID_back,
//            @Header("Authorization") String authHeader
//    );

    @Multipart
    @POST("reserve-vehicle")
    Call<ReserveVehicle> reserveVehicle(
            @Part("vehicle_id") RequestBody vehicleId,
            @Part("name") RequestBody name,
            @Part("phone") RequestBody phone,
            @Part("address") RequestBody adress,
            @Part List<MultipartBody.Part> one,
            @Header("Authorization") String authHeader
    );

    @FormUrlEncoded
    @POST("register")
    Call<Register> registerByMailAndPassword(
            @Field("name") String name,
            @Field("password") String password,
            @Field("email") String mail,
            @Field("phone") String phone,
            @Field("date_of_birth") String dateOfBirth,
            @Field("gender") String gender
    );

    @GET("agency-available-times")
    Call<AvailableTimeResponse> getVehicaleAvailaleTime(
            @Query("id") Integer id,
            @Query("date") String date
    );

    @GET("car-show-room")
    Call<CarShowRoomResponse> getCarShowRoomsCategories();

    @GET("show-car-show-room")
    Call<CarShowRoomDetailsResponse> getCarShowRoom(
            @Query("id") Integer carShowRoomId
    );

    @GET("sell-cars")
    Call<CarsForSaleResponse> getCarsForSale();

    @GET("brands")
    Call<BrandsResponse> getAllCarsBrands();
}
