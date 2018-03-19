package sample.room.com.kotin_with_room_sample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by sumon.chatterjee on 18/03/18.
 */
class PersonAdapter(val userList: List<Person>): RecyclerView.Adapter<PersonAdapter.ViewHolder>() {



    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.txtName?.text =userList.get(position).firstName
        holder?.txtTitle?.text =userList.get(position).lastName
        holder?.age?.text =userList.get(position).age.toString()

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtName = itemView.findViewById<TextView>(R.id.txtName)
        val txtTitle = itemView.findViewById<TextView>(R.id.txtLastName)
        val age = itemView.findViewById<TextView>(R.id.age)

    }
}