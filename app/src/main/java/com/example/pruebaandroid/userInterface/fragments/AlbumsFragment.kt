package com.example.pruebaandroid.userInterface.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebaandroid.R
import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.dependenceinjection.DependencyInjectionAlbum
import com.example.pruebaandroid.model.Album
import com.example.pruebaandroid.repositories.album.RepoAlbumImpl
import com.example.pruebaandroid.userInterface.adapters.AlbumAdapter
import com.example.pruebaandroid.userInterface.viewmodels.AlbumViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_albums.*
import kotlin.properties.Delegates

class AlbumsFragment : Fragment(), AlbumAdapter.OnAlbumClickListener {

    private var userId: Int? = null
    private lateinit var albumViewModel: AlbumViewModel
    private var repoAlbum:RepoAlbumImpl = DependencyInjectionAlbum().getRepoAlbum()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            userId = it.getInt(R.string.send_message_user_id.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_albums, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        albumViewModel = AlbumViewModel(repoAlbum)
        rv_albums.layoutManager = LinearLayoutManager(requireContext())

        setupObservers()
    }

    private fun setupObservers(){
        progress_bar_user_album.visibility = View.VISIBLE
        Log.d("id user", "$userId")
        userId.let {
            //Toast.makeText(requireContext(), "$it", Toast.LENGTH_LONG).show()
            albumViewModel.getAlbumByUserId(it!!).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        progress_bar_user_album.visibility = View.GONE
                        rv_albums.adapter = AlbumAdapter(requireContext(), result, this)
                    },{ error ->
                        Log.e("el error", "$error")
                        progress_bar_user_album.visibility = View.GONE
                        Toast.makeText(requireContext(), "Error obteniendo los albums del usuario $error", Toast.LENGTH_SHORT).show()
                    }
                )
        }
    }

    /*
    fun setupObservers() {
        userId.let {
            albumViewModel.fetchAlbumsUserList(it!!).observe(viewLifecycleOwner, Observer { result ->
                when(result){
                    is Resource.Loading -> {
                        progress_bar_user_album.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        progress_bar_user_album.visibility = View.GONE
                        rv_albums.adapter = AlbumAdapter(requireContext(), result.data, this)
                    }
                    is Resource.Failure -> {
                        progress_bar_user_album.visibility = View.GONE
                        Toast.makeText(requireContext(), "Error obteniendo los albums del usuario", Toast.LENGTH_SHORT).show()
                    }
                }

            })
        }
    }
    */

    override fun onAlbumClick(album: Album) {
        val bundle = Bundle()
        album.albumId?.let { bundle.putInt(R.string.send_message_album_id.toString(), it) }
        findNavController().navigate(R.id.action_albumsFragment_to_photosFragment, bundle)
    }


}