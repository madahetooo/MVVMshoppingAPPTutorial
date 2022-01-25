package com.apps.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.apps.shoppinglist.data.db.entities.ShoppingItem

//Data access object
@Dao
interface ShoppingDao {

    //Update and Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}