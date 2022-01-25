package com.apps.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.apps.shoppinglist.data.db.entities.ShoppingItem
import org.kodein.di.Volatile

@Database(
    entities = [ShoppingItem::class],//refer to class,
    version = 1
)
abstract class ShoppingDatabase : RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDao

    //Static Keyword in java = Companion object
    companion object {

        // will be visible to other threads, only 1 thread at a time write into instance
        @Volatile
        private var instance: ShoppingDatabase? = null

        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDatabase::class.java, "ShoppingDB.db"
            ).build()
    }
}