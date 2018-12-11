package com.mobiledev.nbascheduler;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ReminderDao
{
   @Insert
   void insertGame (ReminderDataModel reminders);

   @Query("SELECT * FROM reminder_table ORDER BY time")
   List<ReminderDataModel> getAllreminders();

   @Query("DELETE FROM reminder_table")
    void deleteAll();
}
