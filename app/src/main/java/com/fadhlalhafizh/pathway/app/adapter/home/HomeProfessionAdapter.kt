package com.fadhlalhafizh.pathway.app.adapter.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fadhlalhafizh.pathway.R
import com.fadhlalhafizh.pathway.app.ui.detailprofession.detailprofessionhome.DetailProfessionHomeActivity
import com.fadhlalhafizh.pathway.data.model.Job

class HomeProfessionAdapter(private val listJob: ArrayList<Job>) : RecyclerView.Adapter<HomeProfessionAdapter.MyViewHolder>() {
    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item){
        val imgPhoto: ImageView = itemView.findViewById(R.id.iv_workplace)
        val jobPosition: TextView = itemView.findViewById(R.id.tv_position)
        val jobCompany: TextView = itemView.findViewById(R.id.tv_workPlace)
        val jobDomicile: TextView = itemView.findViewById(R.id.tv_domicile)
        val fullOrIntern: TextView = itemView.findViewById(R.id.tv_workDuration)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_profession, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = listJob.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val (photo, pos, company, domicile, fullOrIntern, description, ) = listJob[position]
        holder.imgPhoto.setImageResource(photo)
        holder.jobPosition.text = pos
        holder.jobCompany.text = company
        holder.jobDomicile.text = domicile
        holder.fullOrIntern.text = fullOrIntern


        holder.itemView.setOnClickListener {
            val intentDetail =
                Intent(holder.itemView.context, DetailProfessionHomeActivity::class.java)
            intentDetail.putExtra("key_Job", listJob[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}