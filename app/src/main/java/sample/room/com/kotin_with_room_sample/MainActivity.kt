package sample.room.com.kotin_with_room_sample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeValues();

    }


    fun initializeValues(){
        btn.setOnClickListener(clickListener)
        show_users.setOnClickListener(clickListener)

    }


    //insert user
    fun addPerson(firstName: String, lastName: String, age: Int) {
        val person = Person(0, firstName, lastName,age)

        Single.fromObservable<Unit> {
            MainApp.database?.personDao()?.insert(person)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }

    private val clickListener = View.OnClickListener {view ->


        when (view.getId()) {

            R.id.btn -> addPerson(first_name.text.toString(),last_name.text.toString(),age.text.toString().toInt())
            R.id.show_users -> startDetailActivity()

        }
    }



    fun startDetailActivity(){
        val intent = Intent(this, GetDetailsOfInsertedUser::class.java)
        startActivity(intent)
    }


}
