package com.fadhlalhafizh.pathway.app.adapter.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fadhlalhafizh.pathway.R
import com.fadhlalhafizh.pathway.app.ui.detailprofession.DetailProfessionActivity

class HomeProfessionAdapter : RecyclerView.Adapter<HomeProfessionAdapter.MyViewHolder>() {
    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_profession, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val positionName = "Sample Position"
        val workPlace = "Sample Work Place"
        val workDomicile = "Jakarta, Indonesia"
        val fullOrIntern = "full or intern"

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailProfessionActivity::class.java)
            intent.putExtra(DetailProfessionActivity.POSITION, positionName)
            intent.putExtra(DetailProfessionActivity.WORKPLACE, workPlace)
            intent.putExtra(DetailProfessionActivity.DOMICILE, workDomicile)
            intent.putExtra(DetailProfessionActivity.FULL_OR_INTERN, fullOrIntern)
            it.context.startActivity(intent)
        }
    }
}