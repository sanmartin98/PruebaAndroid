package com.example.pruebaandroid.userInterface.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pruebaandroid.R
import com.example.pruebaandroid.model.Photo
import kotlinx.android.synthetic.main.cardview_photos.view.*
import java.util.*


class PhotoAdapter(private val context: Context, private val listPhoto:List<Photo>): RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview_photos, parent, false))
    }

    override fun getItemCount(): Int {
        return listPhoto.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.onBindViewHolder(listPhoto[position])
    }

    inner class PhotoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        val urlImgList: List<String> = listOf(
            "https://img.ecologiahoy.com/2017/06/paisajes-naturales-26-1280x720.jpeg",
            "https://img.ecologiahoy.com/2017/06/paisajes-naturales-26-1280x720.jpeg",
            "https://www.nationalgeographic.com.es/medio/2018/02/27/playa-de-isuntza-lekeitio__1280x720.jpg",
            "https://www.tiposde.top/wp-content/uploads/2019/08/1.-Paisaje-f%C3%ADsico.jpg",
            "https://i.ytimg.com/vi/9QNUXxuwt1Y/maxresdefault.jpg"
        )

        fun onBindViewHolder(photo: Photo){
            Glide.with(context).load(urlImgList[Random().nextInt(4)]).into(itemView.cv_iv_photo)
            itemView.cv_tv_title_photo.text = photo.title
        }

    }
}