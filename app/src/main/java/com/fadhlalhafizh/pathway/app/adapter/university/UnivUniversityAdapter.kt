package com.fadhlalhafizh.pathway.app.adapter.university

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fadhlalhafizh.pathway.R
import com.fadhlalhafizh.pathway.app.ui.detailuniversity.DetailUniversityActivity

class UnivUniversityAdapter: RecyclerView.Adapter<UnivUniversityAdapter.MyViewHolder>() {
    class MyViewHolder(item : View): RecyclerView.ViewHolder(item) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_university, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val universityName = "Sample University"
        val universityAddress = "Sample Address"
        val worldRank1 = "World Rank"
        val worldRank2 = "x"

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailUniversityActivity::class.java)
            intent.putExtra(DetailUniversityActivity.UNIVERSITY, universityName)
            intent.putExtra(DetailUniversityActivity.ADDRESS, universityAddress)
            intent.putExtra(DetailUniversityActivity.WORLD_RANK1, worldRank1)
            intent.putExtra(DetailUniversityActivity.WORLD_RANK2, worldRank2)
            it.context.startActivity(intent)
        }
    }
}