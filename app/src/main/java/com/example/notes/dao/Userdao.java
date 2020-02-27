package com.example.notes.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.notes.entity.User;

import java.util.List;

@Dao
public interface Userdao {

    @Query("SELECT * FROM user")
    List<User> fetchUser();

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Query("SELECT COUNT(mobile) from user where mobile=:mobile and password=:password")
    int total(String mobile,String password);

    @Query("SELECT * FROM user where mobile=:mobile limit 1")
    User getUserDetail(String mobile);
}
