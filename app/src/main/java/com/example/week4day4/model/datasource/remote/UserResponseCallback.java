package com.example.week4day4.model.datasource.remote;

import com.example.week4day4.model.user.UserResponse;

public interface UserResponseCallback {
    void OnSuccess(UserResponse userResponse);
}
