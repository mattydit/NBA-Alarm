package com.mobiledev.nbascheduler;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel
{
    private UserRepository repo;
    private LiveData<List<User>> allusers;

    public UserViewModel(Application application)
    {
        super(application);
        repo = new UserRepository(application);
        allusers = repo.getAllusers();
    }

    public LiveData<List<User>> getAllusers()
    {
        return allusers;
    }

    public void insert(User user)
    {
        repo.insert(user);
    }
}
