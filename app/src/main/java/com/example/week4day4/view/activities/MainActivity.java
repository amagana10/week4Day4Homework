package com.example.week4day4.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.week4day4.R;
import com.example.week4day4.model.datasource.remote.UserResponseCallback;
import com.example.week4day4.model.datasource.remote.UserResponseRepository;
import com.example.week4day4.model.user.UserResponse;
import com.example.week4day4.view.activities.adapters.MyRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements UserResponseCallback {
    RecyclerView rvUserList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserResponseRepository userResponseRepository = new UserResponseRepository();
        userResponseRepository.getUserResponse(this);
    }

    @Override
    public void OnSuccess(UserResponse userResponse) {
        initializeRecyclerView(userResponse);

    }

    private void initializeRecyclerView(UserResponse userResponse){
        rvUserList = findViewById(R.id.rvRecyclerView);
        rvUserList.setLayoutManager(new LinearLayoutManager(this));
        rvUserList.setAdapter(new MyRecyclerViewAdapter(userResponse));


    }
}
