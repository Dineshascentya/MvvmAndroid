package com.ascentya.tamplates_recycler.ViewModels;

// Created by Dineshkumar 10/10/2019

import android.app.Application;

import com.ascentya.tamplates_recycler.model.EmployeeRepository;
import com.ascentya.tamplates_recycler.model.Test;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MainViewModel extends AndroidViewModel {
    private EmployeeRepository employeeRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        // connecting Repo to View model.
        employeeRepository = new EmployeeRepository();
    }

    // livedata
    public LiveData<List<Test>> getAllEmployee() {
        return employeeRepository.getMutableLiveData();
    }
}
