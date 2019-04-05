package com.mobiledev.nbascheduler.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {ReminderDataModel.class}, version = 1)
public abstract class ReminderDatabase extends RoomDatabase
{
    public abstract ReminderDao daoAccess();

    private static ReminderDatabase INSTANCE;

    public static ReminderDatabase getDatabase(final Context context)
    {
        if (INSTANCE == null)
        {
            synchronized (ReminderDatabase.class)
            {
                if (INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ReminderDatabase.class, "reminderDB").allowMainThreadQueries().build();
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
