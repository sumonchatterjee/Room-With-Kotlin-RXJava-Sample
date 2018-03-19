package sample.room.com.kotin_with_room_sample

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by sumon.chatterjee on 18/03/18.
 */

@Database(entities = arrayOf(Person::class), version = 2)
abstract class MyDatabase:RoomDatabase(){
    abstract fun personDao(): PersonDao
}