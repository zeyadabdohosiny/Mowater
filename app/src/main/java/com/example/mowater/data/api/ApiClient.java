 package com.example.mowater.data.api;

import com.example.mowater.data.models.Sections.Sections;
import com.example.mowater.data.models.SpecialNumbers.SpecialNumbers;
import com.example.mowater.data.models.SpecialNumbersCategories.SpecialNumbersCategories;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String TAG="Api_Client_Class";
    public static final String BASE_URL ="https://mawatery.schemecode.com/api/";
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

    public  Call<SpecialNumbersCategories> getSpecialNumbersCategories(){
        return retrofitHelper.getSpecialNumbersCategories();
    }

    public Call<SpecialNumbers> getSpecialNumbers(Integer categoryId){
        return retrofitHelper.getSpecialNumbers(categoryId);
    }
//    public Call <> reserveSpecialNumber(String specialNumberId,String name,String phone,String adress,String token){
//        return retrofitHelper.reservespecialNumber(specialNumberId,name,phone,adress,token);
//    };


}
