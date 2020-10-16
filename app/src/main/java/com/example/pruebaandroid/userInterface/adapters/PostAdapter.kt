package com.example.pruebaandroid.userInterface.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebaandroid.R
import com.example.pruebaandroid.model.Post
import kotlinx.android.synthetic.main.cardview_posts.view.*

class PostAdapter(private val context: Context, private val postList: List<Post>): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview_posts, parent, false))
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.onBindViewHolder(postList[position])
    }

    inner class PostViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun onBindViewHolder(post:Post){
            itemView.cv_tv_title_post.text = post.title
            itemView.cv_tv_description_post.text = post.body
        }
    }
}