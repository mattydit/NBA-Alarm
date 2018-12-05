package com.mobiledev.nbascheduler;

import android.os.AsyncTask;

public class DataAsyncTask extends AsyncTask<User, Void, Void>
{
    private UserDao asyncTaskDao;

    DataAsyncTask(UserDao dao)
    {
        asyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(final User... params)
    {
        asyncTaskDao.insert(params[0]);
        return null;
    }
}
