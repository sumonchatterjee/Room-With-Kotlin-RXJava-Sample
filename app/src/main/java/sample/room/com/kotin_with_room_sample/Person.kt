package sample.room.com.kotin_with_room_sample

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by sumon.chatterjee on 18/03/18.
 */
@Entity
data class Person(
        @PrimaryKey(autoGenerate = true)
        val uid: Long,
        val firstName: String = "",
        val lastName: String = "",
        val age:Int = 0
)