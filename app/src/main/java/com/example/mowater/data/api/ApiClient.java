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
import com.example.mowater.ui.activities.VehicleReservation.VehicleReservation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String TAG="Api_Client_Class";
    public static final String BASE_URL ="https://mawatery.schemecode.com/api/";
  //  public static final String BASE_URL ="https://a8a5-41-46-153-248.ngrok.io/api/";

    static ApiClient client;
    static RetrofitHelper retrofitHelper;
    private static Retrofit retrofit;

    public  ApiClient() {

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
            retrofitHelper=retrofit.create(RetrofitHelper.class);
    }

    public static ApiClient getInstance(){
        if (retrofit==null)
            client=new ApiClient();
        return client;
    }

    public  Call<Sections> getSections(){
        return retrofitHelper.getSections();
    }

    public Call<SpecialNumbersCategories> getSpecialNumbersCategories() {
        return retrofitHelper.getSpecialNumbersCategories();
    }

    public Call<SpecialNumbers> getSpecialNumbers(Integer categoryId) {
        return retrofitHelper.getSpecialNumbers(categoryId);
    }

    public Call<SpecialNumberReservation> reserveSpecialNumber(String specialNumberId, String name, String phone, String adress, String token) {
        return retrofitHelper.reservespecialNumber(specialNumberId, name, phone, adress, token);
    }

    public Call<RentalOfficesCategories> getRentalOfficesCategories() {
        return retrofitHelper.getRentalOfficesCategories();
    }

    public Call<RentalOffices> getRentalOffice(int rentalOfficeId) {
        return retrofitHelper.getRentalOfficeCars(rentalOfficeId);
    }

    public Call<BookRentalCar> bookRentalCar(
            String rentalOfficeCarId, String name, String phone, String address, String startTime,
            String rentalType, String paymentMethodId, String token) {

        return retrofitHelper.bookRentalCar(rentalOfficeCarId, name, phone, address, startTime, rentalType, paymentMethodId, token);
    }

    public Call<AgencyCategories> getAgentCategories() {
        return retrofitHelper.getAgentCategories();
    }

    public Call<AgencyDetails> getAgencyDetails(int agencyId) {
        return retrofitHelper.getAgencyDetails(agencyId);
    }

    public Call<Vehicles> getVehicles(Integer modelId, String modelType, Integer carModelId, Integer carClassId) {
        return retrofitHelper.getVehicles(modelId, modelType, carModelId, carClassId);
    }

    public Call<Vehicle> getVehicle(int id) {
        return retrofitHelper.getVehicle(id);

    }
//
//    public Call<ReserveVehicle> reserveVehicle(String vehicleId, String name, String phone, String adress
//            , String drivingLicenseFront, String driving_license_back, String personal_ID_front, String personal_ID_back){
//        return retrofitHelper.reserveVehicle(vehicleId,name,phone,adress,drivingLicenseFront,driving_license_back,personal_ID_front,personal_ID_back,"bearer" + "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvbWF3YXRlcnkuc2NoZW1lY29kZS5jb21cL2FwaVwvbG9naW4iLCJpYXQiOjE2NDE4MTIwNTQsIm5iZiI6MTY0MTgxMjA1NCwianRpIjoieXZQOEo0UzY0cWdzODB0SSIsInN1YiI6MTIsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.tyGL8EG2L22-I-aPIRg31Jc-HbqmMwooCkcPmU-OBwE");
//    }
    public Call<ReserveVehicle> reserveVehicle(RequestBody vehicleId, RequestBody name, RequestBody phone, RequestBody adress,
                                                List<MultipartBody.Part> file){
        return retrofitHelper.reserveVehicle(vehicleId,name,phone,adress,file,"bearer" + "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvbWF3YXRlcnkuc2NoZW1lY29kZS5jb21cL2FwaVwvbG9naW4iLCJpYXQiOjE2NDI1ODk3MTcsIm5iZiI6MTY0MjU4OTcxNywianRpIjoiMFI1UTZNMkVZcmx6TUx5ayIsInN1YiI6MTMsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.zqhIeJj3Ou2x1ZmeNFjYGkpbM9czSQn3k1jTeca8nqY");
    }
    public Call<Register> registerByMailAndPassword(String name,String password,String mail,
                                                    String phone ,String dateOfbirth,String gender){
        return retrofitHelper.registerByMailAndPassword(name,password,mail,phone,dateOfbirth,gender);
    }
    public Call<AvailableTimeResponse> getVehicleAvailableTime(int id, String date){
        return retrofitHelper.getVehicaleAvailaleTime(id,date);
    }
    public Call<CarShowRoomResponse> getCarShowRoomCategories(){
        return retrofitHelper.getCarShowRoomsCategories();
    }
    public Call<CarShowRoomDetailsResponse> getCarShowRoom(int carShowRoomId){
        return retrofitHelper.getCarShowRoom(carShowRoomId);
    }
    public Call <CarsForSaleResponse> getCarsForSale(){
        return retrofitHelper.getCarsForSale();
    }
    public Call<BrandsResponse> getCarsBrands(){
        return retrofitHelper.getAllCarsBrands();
    }
}
