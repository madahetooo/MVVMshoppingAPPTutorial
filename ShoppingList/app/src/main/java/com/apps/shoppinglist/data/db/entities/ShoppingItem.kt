package com.apps.shoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int
) {
    //Not Need to set it Manually, so we didn't added it to constructor
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}