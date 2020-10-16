package com.example.pruebaandroid.userInterface.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebaandroid.R
import com.example.pruebaandroid.model.Album
import com.example.pruebaandroid.model.User
import kotlinx.android.synthetic.main.cardview_albums.view.*

class AlbumAdapter(private val context: Context, private val albumList: List<Album>,
                    private val itemClickListener: OnAlbumClickListener):RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    interface OnAlbumClickListener{
        fun onAlbumClick(album: Album)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview_albums, parent, false))
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.onBindViewHolder(albumList[position])
    }

    inner class AlbumViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun onBindViewHolder(album:Album){
            itemView.cv_tv_title_album.text = album.title
            itemView.setOnClickListener{itemClickListener.onAlbumClick(album)}
        }
    }
}