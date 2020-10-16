package com.example.pruebaandroid.userInterface.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebaandroid.R
import com.example.pruebaandroid.model.User
import kotlinx.android.synthetic.main.cardview_user.view.*
import java.util.*
import kotlin.collections.ArrayList

class UserAdapter(private val context: Context, private val listUser: List<User>,
                    private val itemClickListener: OnUserClickListener):RecyclerView.Adapter<UserAdapter.UserViewHolder>(), Filterable{
    private var userFilterList:ArrayList<User> = ArrayList<User>()

    init {
        userFilterList.addAll(listUser as ArrayList<User>)
    }

    interface OnUserClickListener{
        fun onUserClick(user: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview_user, parent, false))
    }

    override fun getItemCount(): Int {
        return userFilterList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBindViewHolder(userFilterList[position])
    }


    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun onBindViewHolder(user: User){
            itemView.cv_tv_user_name.text = user.name
            itemView.cv_tv_user_tel.text = user.tel
            itemView.cv_tv_user_email.text = user.email
            itemView.setOnClickListener{itemClickListener.onUserClick(user)}
        }
    }

    override fun getFilter(): Filter {
        return object: Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    userFilterList = listUser as ArrayList<User>
                } else {
                    val resultList = ArrayList<User>()
                    for (row in listUser) {
                        if (row.name?.toLowerCase(Locale.ROOT)?.contains(charSearch.toLowerCase(Locale.ROOT))!!) {
                            resultList.add(row)
                        }
                    }
                    userFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = userFilterList
                return filterResults
            }


            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                userFilterList = results?.values as ArrayList<User>
                notifyDataSetChanged()
            }

        }
    }
}