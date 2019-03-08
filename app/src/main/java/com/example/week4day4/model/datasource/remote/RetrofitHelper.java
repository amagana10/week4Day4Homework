package com.example.week4day4.model.datasource.remote;

import com.example.week4day4.model.user.UserResponse;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.week4day4.model.datasource.remote.ApiConstants.*;

public class RetrofitHelper {
    private static OkHttpClient getOkHttpClientWithInterceptor(){
        //Declare Interceptor for http logging
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        //set http logging level
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //return new okHttp client with interceptor attached
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }

    private static Retrofit getRetrofit(){
        //Build retrofit instance
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)//Base URL of the api source
                .client(getOkHttpClientWithInterceptor())//add new okhttp client with interceptor
                .addConverterFactory(GsonConverterFactory.create())// add object converter factory
                .build();//build the instance
    }
    //create the interface instance in retrofit
    private ObservableInterface createUserResponceInterface(){
        return  getRetrofit().create(ObservableInterface.class);
    }

    //Execute rest call
    public Observable<UserResponse> getResponseObservable(){
        return createUserResponceInterface().getUserResponseObservable();
    }


    // Create interface for the observable
    public interface ObservableInterface{
        @GET(PATH_API)
        Observable<UserResponse> getUserResponseObservable();
    }
}
