package com.mobiledev.nbascheduler;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {User.class}, version = 1)
public abstract class UserRoomDatabase extends RoomDatabase
{
    private static volatile UserRoomDatabase INSTANCE;

    static UserRoomDatabase getDatabase(final Context context)
    {
        if (INSTANCE == null)
        {
            synchronized (UserRoomDatabase.class)
            {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        UserRoomDatabase.class, "user").build();
            }
        }

        return INSTANCE;
    }

    public abstract UserDao userDao();
}
