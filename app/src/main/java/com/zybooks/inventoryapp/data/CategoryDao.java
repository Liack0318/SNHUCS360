package com.zybooks.inventoryapp.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CategoryDao {

    @Insert
    void insert(Category category);

    @Update
    void update(Category category);

    @Delete
    void delete(Category category);

    @Query("SELECT * FROM categories")
    LiveData<List<Category>> getAllCategories();

    @Query("SELECT * FROM categories WHERE id = :id")
    Category getCategoryById(int id);

    @Query("UPDATE items SET categoryId = 0 WHERE categoryId = :categoryId")
    void updateItemsToNoCategory(int categoryId);
}
