package com.ascentya.tamplates_recycler.network;

// Created by Dineshkumar 10/10/2019

import com.ascentya.tamplates_recycler.model.Test;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeDataService {
    @GET("v2/list")
    Call<List<Test>> getEmployees();
}
