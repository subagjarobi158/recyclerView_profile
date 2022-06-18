package com.robisubagja.robisubagja

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.robisubagja.robisubagja.databinding.ListCharacterBinding


class Adapterpemain(private val context : Context,
                    private var data : List<pemain>?,
                    private val itemClick : OnClickListener)
    : RecyclerView.Adapter<Adapterpemain.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListCharacterBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text = item?.nama

        holder.itemView.setOnClickListener {
            itemClick.detailData(item)
        }
    }

    override fun getItemCount(): Int = data?.size ?:0

    inner class ViewHolder( val  binding : ListCharacterBinding): RecyclerView.ViewHolder(binding.root)    {
        var foto = binding.image
        var nama = binding.txtnama
    }

    interface OnClickListener {
        fun detailData(item : pemain?)
    }

}