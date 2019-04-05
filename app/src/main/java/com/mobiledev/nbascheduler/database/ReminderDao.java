package com.mobiledev.nbascheduler.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ReminderDao
{
   @Insert
   void insertGame (ReminderDataModel reminders);

   @Query("SELECT * FROM reminderDB ORDER BY time")
   List<ReminderDataModel> getAllreminders();

   @Query("DELETE FROM reminderDB")
    void deleteAll();
}
