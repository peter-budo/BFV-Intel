package com.ninetwozero.bf5intel.repository.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ninetwozero.bf5intel.repository.storage.dao.SettingsDao
import com.ninetwozero.bf5intel.repository.storage.entity.Settings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = arrayOf(Settings::class),
    version = 1
)
public abstract class BfVDatabase : RoomDatabase() {

    abstract fun settingsDao(): SettingsDao

    companion object {
        @Volatile
        private var INSTANCE: BfVDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): BfVDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BfVDatabase::class.java,
                    "bfv_database"
                ).addCallback(BfVDatabaseCallback(scope)).build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class BfVDatabaseCallback(
        private val scope: CoroutineScope
    ): RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {database ->
                scope.launch {
                    populateDatabase(database.settingsDao())
                }
            }
        }

        suspend fun populateDatabase(settingsDao: SettingsDao) {
            var settings = Settings(1, "", false, "")
            settingsDao.insert(settings)
        }
    }
}