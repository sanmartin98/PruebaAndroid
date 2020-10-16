package com.example.pruebaandroid.userInterface.fragments

import android.os.Bundle
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

    fun setupObservers(){
        userViewModel.fetchUserList.observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading -> {
                    progress_bar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progress_bar.visibility = View.GONE
                    userAdapter = UserAdapter(requireContext(), result.data, this)
                    rv_userList.adapter = userAdapter
                }
                is Resource.Failure -> {
                    progress_bar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Ocurrio un error obteniendo los datos ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })
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