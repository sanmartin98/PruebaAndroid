package com.example.pruebaandroid.userInterface.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebaandroid.R
import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.dependenceinjection.DependenceInjectionPost
import com.example.pruebaandroid.model.User
import com.example.pruebaandroid.repositories.post.RepoPostImpl
import com.example.pruebaandroid.userInterface.adapters.PostAdapter
import com.example.pruebaandroid.userInterface.viewmodels.PostViewModel
import kotlinx.android.synthetic.main.fragment_user_detail.*

class UserDetailFragment : Fragment() {

    private lateinit var user:User
    private var repoPostImpl = DependenceInjectionPost().getRepoPost()
    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            user = it.getParcelable(R.string.send_message_user.toString())!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postViewModel = PostViewModel(repoPostImpl)
        recycler_posts_user.layoutManager = LinearLayoutManager(requireContext())

        setupView()
        setupObservers()
        btn_albums.setOnClickListener{
            val bundle = Bundle()
            user.id?.let { bundle.putInt(R.string.send_message_user_id.toString(), it) }
            findNavController().navigate(R.id.action_userDetailFragment_to_albumsFragment, bundle)
        }
    }

    fun setupView(){
        tv_user_name.text = user.name
        tv_user_tel.text = user.tel
        tv_user_email.text = user.email
    }

    fun setupObservers(){
        user.id?.let {
            postViewModel.fetchPostUserList(it).observe(viewLifecycleOwner, Observer { result ->
                when(result){
                    is Resource.Loading -> {
                       progress_bar_user_detail.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        progress_bar_user_detail.visibility = View.GONE
                        recycler_posts_user.adapter = PostAdapter(requireContext(), result.data)
                        recycler_posts_user.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
                    }
                    is Resource.Failure -> {
                        progress_bar_user_detail.visibility = View.GONE
                        Toast.makeText(requireContext(), "Error obteniendo los post del usuario", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}