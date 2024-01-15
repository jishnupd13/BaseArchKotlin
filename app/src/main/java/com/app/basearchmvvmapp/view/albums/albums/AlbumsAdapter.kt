package com.app.basearchmvvmapp.view.albums.albums

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.basearchmvvmapp.data.models.albums.AlbumsResponseModel
import com.app.basearchmvvmapp.databinding.CellAlbumsBinding
import com.bumptech.glide.Glide

class AlbumsAdapter(
   private var list: List<AlbumsResponseModel>
) : Adapter<AlbumsAdapter.AlbumsViewHolder>() {

    inner class AlbumsViewHolder(private val binding:CellAlbumsBinding):ViewHolder(binding.root){

        @SuppressLint("SetTextI18n")
        fun onBind(item: AlbumsResponseModel) = binding.apply {
            textAlbumId.text = "Id : ${item.albumId}"
            textAlbumName.text = "Title : ${item.title}"
            Glide.with(root.context).load(
               item.url
            ).into(imgAlbums)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
       return AlbumsViewHolder(
           CellAlbumsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(list: List<AlbumsResponseModel>){
        this.list = list
        notifyDataSetChanged()
    }
}