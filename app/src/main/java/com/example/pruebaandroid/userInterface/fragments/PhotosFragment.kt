package com.example.pruebaandroid.userInterface.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebaandroid.R
import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.dependenceinjection.DependenceInjectionPhoto
import com.example.pruebaandroid.repositories.photo.RepoPhotoImpl
import com.example.pruebaandroid.userInterface.adapters.PhotoAdapter
import com.example.pruebaandroid.userInterface.viewmodels.PhotoViewModel
import kotlinx.android.synthetic.main.fragment_photos.*

class PhotosFragment : Fragment() {

    private var albumId:Int? = null
    private lateinit var photoViewModel:PhotoViewModel
    private var repoPhoto:RepoPhotoImpl = DependenceInjectionPhoto().getRepoPhoto()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            albumId = it.getInt(R.string.send_message_album_id.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        photoViewModel = PhotoViewModel(repoPhoto)
        rv_photos.layoutManager = LinearLayoutManager(requireContext())

        setupObservers()
    }

    fun setupObservers(){
        albumId.let {
            photoViewModel.fetchPhotosUserList(it!!).observe(viewLifecycleOwner, Observer { result ->
                when(result){
                    is Resource.Loading -> {
                        progress_bar_user_photo.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        progress_bar_user_photo.visibility = View.GONE
                        rv_photos.adapter = PhotoAdapter(requireContext(), result.data)
                    }
                    is Resource.Failure -> {
                        progress_bar_user_photo.visibility = View.GONE
                        Toast.makeText(requireContext(), "Error obteniendo las fotos del album", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }

}