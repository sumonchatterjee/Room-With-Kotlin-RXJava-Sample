package sample.room.com.kotin_with_room_sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.layout_details.*

/**
 * Created by sumon.chatterjee on 18/03/18.
 */
 class GetDetailsOfInsertedUser:AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_details)
        initializeValues()
      //  getAllInsertedUsersDetails()
        getDetailsOfPersons()
    }

   // initialize values
    fun initializeValues(){
        recycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
    }


    // getting details of all the inserted user from database
    fun getAllInsertedUsersDetails() {
        MainApp.database?.personDao()?.getAllPeople()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { listOfPeople ->
                    personTableUpdated(listOfPeople)

                }
    }


    // put value in recycler view
    fun personTableUpdated(userList: List<Person>){
        recycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        var adapter = PersonAdapter(userList)
        recycler.adapter = adapter
    }


    fun getDetailsOfPersons(){
        MainApp.database?.personDao()?.getAllPeopleWithAgeAboveFifteen()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { listOfPeople ->
                    personTableUpdated(listOfPeople)

                }
    }
}