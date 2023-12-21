package com.fadhlalhafizh.pathway.app.adapter.university

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fadhlalhafizh.pathway.R
import com.fadhlalhafizh.pathway.app.ui.detailuniversity.DetailUniversityActivity
import com.fadhlalhafizh.pathway.data.model.University

class UnivUniversityAdapter(private val listUniversity: ArrayList<University>) :
    RecyclerView.Adapter<UnivUniversityAdapter.MyViewHolder>() {
    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.iv_university)
        val imgPhotoBackground: ImageView = itemView.findViewById(R.id.iv_background_university)
        val universityName: TextView = itemView.findViewById(R.id.tv_universityNames)
        val universityAddress: TextView = itemView.findViewById(R.id.tv_universityAddress)
        val universityWorldRank: TextView = itemView.findViewById(R.id.tv_worldRank2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_university, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = listUniversity.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val (name, address, description, worldRank, universityPhoto, backgroundPhoto) = listUniversity[position]
        holder.imgPhoto.setImageResource(universityPhoto)
        holder.imgPhotoBackground.setImageResource(backgroundPhoto)
        holder.universityName.text = name
        holder.universityAddress.text = address
        holder.universityWorldRank.text = worldRank

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailUniversityActivity::class.java)
            intentDetail.putExtra("key_University", listUniversity[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}