package com.mobiledev.nbascheduler;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

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

    private static RoomDatabase.Callback sRoomDatabaseCallback
            = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db)
        {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void>
    {
        private final UserDao mDao;

        PopulateDbAsync(UserRoomDatabase db)
        {
            mDao = db.userDao();
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            //User user = new User(UserSettings.getUsername(), )
            UserSettings s1 = new UserSettings();
            String usern = s1.getUsername();
            String team = s1.getTeam();
            User user = new User(1, usern, team);
            return null;
        }
    }

    public abstract UserDao userDao();
}
