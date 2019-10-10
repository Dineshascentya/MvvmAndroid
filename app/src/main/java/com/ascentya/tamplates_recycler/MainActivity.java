package com.ascentya.tamplates_recycler;


import android.os.Bundle;

import com.ascentya.tamplates_recycler.ViewModels.MainViewModel;
import com.ascentya.tamplates_recycler.adapter.EmployeeDataAdapter;
import com.ascentya.tamplates_recycler.databinding.ActivityMainBinding;
import com.ascentya.tamplates_recycler.model.Test;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

// Created by Dineshkumar 10/10/2019

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    private EmployeeDataAdapter employeeDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Link xml to view using databinding

        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        // bind RecyclerView
        RecyclerView recyclerView = activityMainBinding.viewEmployees;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
// link viewmodel to view
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        employeeDataAdapter = new EmployeeDataAdapter();
        recyclerView.setAdapter(employeeDataAdapter);


        getAllEmployee();
    }

    private void getAllEmployee() {
        // using live data here to get data from retrofit

        mainViewModel.getAllEmployee().observe(this, new Observer<List<Test>>() {
            @Override
            public void onChanged(@Nullable List<Test> employees) {
                employeeDataAdapter.setEmployeeList((ArrayList<Test>) employees);
            }
        });
    }

}
