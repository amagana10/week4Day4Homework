package com.example.week4day4.model.datasource.remote;

import android.util.Log;

//use the i.o.reactive observer
import com.example.week4day4.model.user.UserResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UserResponseObserver implements Observer<UserResponse> {

    UserResponse returnUserResponse;
    UserResponseCallback userResponseCallback;

    //Constructor for the observer


    public UserResponseObserver(UserResponseCallback userResponseCallback) {
        this.userResponseCallback = userResponseCallback;
    }

    @Override
    public void onSubscribe(Disposable d) {
        //when the observer subscribes to the observer, do anything
        // needed to set up for the response once it is received
        Log.d("TAG_OBSERVER", "onSubscribe: SUBSCRIBED TO OBSERVABLE");
    }

    @Override
    public void onNext(UserResponse userResponse) {
        //this is where our responses will be received
        Log.d("TAG_OBSERVER", "onNext: RESPONSE RECEIVED");
        returnUserResponse = userResponse;

    }

    @Override
    public void onError(Throwable e) {
        //Something went wrong, take some action
        Log.e("TAG_OBSERVER", "onError: ERROR RETURNED", e);

    }

    @Override
    public void onComplete() {
        Log.d("TAG_OBSERVER", "onComplete: TASK IS COMPLETE RETURNING USER RESPONSE");
        //pass the user response that was received back along the callback
        userResponseCallback.OnSuccess(returnUserResponse);

    }
}
