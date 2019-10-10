package com.ascentya.tamplates_recycler.model;

// Created by Dineshkumar 10/10/2019

import com.ascentya.tamplates_recycler.network.EmployeeDataService;
import com.ascentya.tamplates_recycler.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// repo

public class EmployeeRepository {
    private static final String TAG = "EmployeeRepository";
    private ArrayList<Test> employees = new ArrayList<>();
    private MutableLiveData<List<Test>> mutableLiveData = new MutableLiveData<>();

    public EmployeeRepository() {
    }

    public MutableLiveData<List<Test>> getMutableLiveData() {


        final EmployeeDataService userDataService = RetrofitClient.getService();

        Call<List<Test>> call = userDataService.getEmployees();
        call.enqueue(new Callback<List<Test>>() {
            @Override
            public void onResponse(Call<List<Test>> call, Response<List<Test>> response) {
                List<Test> employeeDBResponse = response.body();


                mutableLiveData.setValue(employeeDBResponse);

            }

            @Override
            public void onFailure(Call<List<Test>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

        return mutableLiveData;
    }
}
