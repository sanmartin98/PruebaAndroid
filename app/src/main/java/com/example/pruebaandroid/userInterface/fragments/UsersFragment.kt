package com.example.pruebaandroid.userInterface.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebaandroid.R
import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.dependenceinjection.DependencyInjectionUser
import com.example.pruebaandroid.model.User
import com.example.pruebaandroid.userInterface.adapters.UserAdapter
import com.example.pruebaandroid.userInterface.viewmodels.UserViewModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_users.*

class UsersFragment : Fragment(), UserAdapter.OnUserClickListener {

    private var repoUser = DependencyInjectionUser().getRepoUser()
    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel = UserViewModel(repoUser)

        setupRecyclerView()
        setupObservers()
        setupSearchView()
    }

    @SuppressLint("CheckResult")
    fun setupObservers(){
        progress_bar.visibility = View.VISIBLE

        userViewModel.getUsers().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    progress_bar.visibility = View.GONE
                    userAdapter = UserAdapter(requireContext(), result, this)
                    rv_userList.adapter = userAdapter
                }, {error ->
                    progress_bar.visibility = View.GONE
                    Toast.makeText(requireContext(),"error obteniendo la lista de usuarios", Toast.LENGTH_SHORT).show()
                }
            )
    }

    fun setupRecyclerView(){
        rv_userList.layoutManager = LinearLayoutManager(requireContext())
    }

    fun setupSearchView(){
        search_view.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                userAdapter.filter.filter(newText)
                return false
            }

        })
    }

    override fun onUserClick(user: User) {
        val bundle = Bundle()
        bundle.putParcelable(R.string.send_message_user.toString(), user)
        findNavController().navigate(R.id.action_usersFragment2_to_userDetailFragment, bundle)
    }
}