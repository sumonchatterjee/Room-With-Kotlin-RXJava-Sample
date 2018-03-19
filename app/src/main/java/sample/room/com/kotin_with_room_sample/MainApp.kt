package sample.room.com.kotin_with_room_sample

import android.app.Application
import android.arch.persistence.room.Room

/**
 * Created by sumon.chatterjee on 18/03/18.
 */
class MainApp:Application(){

    companion object {
        var database: MyDatabase? = null
    }


    override fun onCreate() {
        super.onCreate()
        MainApp.database =  Room.databaseBuilder(this, MyDatabase::class.java, "we-need-db").build()
    }
}