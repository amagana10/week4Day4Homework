package com.example.week4day4.model.datasource.remote;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserResponseRepository {
    private RetrofitHelper retrofitHelper;

    //Instantiate retrofit helper
    public UserResponseRepository() {
        this.retrofitHelper = new RetrofitHelper();
    }

    //Subscribe to observable and schedule the threads
    public  void getUserResponse(UserResponseCallback userResponseCallback){
        retrofitHelper.getResponseObservable()
                .subscribeOn(Schedulers.io())//thread that the observable will process request
                .observeOn(AndroidSchedulers.mainThread())//thread the results will be posted on
                .subscribe(new UserResponseObserver(userResponseCallback));// the observer that is subscribing to the observable
    }
}
