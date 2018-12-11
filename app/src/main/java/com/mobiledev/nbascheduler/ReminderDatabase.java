package com.mobiledev.nbascheduler;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {ReminderDataModel.class}, version = 1)
public abstract class ReminderDatabase extends RoomDatabase
{
    public abstract ReminderDao daoAccess();

    private static volatile ReminderDatabase INSTANCE;

    static ReminderDatabase getDatabase(final Context context)
    {
        if (INSTANCE == null)
        {
            synchronized (ReminderDatabase.class)
            {
                if (INSTANCE == null)
                {
                    INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(),
                            ReminderDatabase.class).allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }

    public static ReminderDatabase getINSTANCE() {
        return INSTANCE;
    }

    public static void setINSTANCE(ReminderDatabase INSTANCE) {
        ReminderDatabase.INSTANCE = INSTANCE;
    }

}
