package sample.room.com.kotin_with_room_sample

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable

/**
 * Created by sumon.chatterjee on 18/03/18.
 */
@Dao
interface PersonDao{
    @Query("SELECT * FROM person")
    fun getAllPeople(): Flowable<List<Person>>

    @Insert
    fun insert(person: Person)

    @Query("SELECT * FROM person where age > '15'")
    fun getAllPeopleWithAgeAboveFifteen(): Flowable<List<Person>>


}