package com.mobiledev.nbascheduler;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class UserRepository
{
    private UserDao userDao;
    private LiveData<List<User>> allusers;

    UserRepository(Application application)
    {
        UserRoomDatabase db = UserRoomDatabase.getDatabase(application);
        userDao = db.userDao();
        allusers = userDao.getAllUsers();
    }

    LiveData<List<User>> getAllusers()
    {
        return allusers;
    }

    public void insert(User user)
    {
        new DataAsyncTask(userDao).execute(user);
    }
}
