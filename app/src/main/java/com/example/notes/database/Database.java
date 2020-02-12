package com.example.notes.database;


import android.content.Context;

import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.notes.dao.Userdao;
import com.example.notes.entity.User;

@androidx.room.Database(entities = {User.class,},version = 1,exportSchema = false)
public abstract class Database extends RoomDatabase {
    private static Database database;
    public abstract Userdao userdao();
    public static Database getInstance(Context context)
    {
        if(database==null)
        {
            synchronized (Database.class) {
                if (database == null) {
                    database = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "todo")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return database;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen (SupportSQLiteDatabase db){
            super.onOpen(db);
        }
    };
}
