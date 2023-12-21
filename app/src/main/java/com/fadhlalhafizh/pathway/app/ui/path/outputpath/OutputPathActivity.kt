package com.fadhlalhafizh.pathway.app.ui.path.outputpath

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fadhlalhafizh.pathway.R
import com.fadhlalhafizh.pathway.app.adapter.output.OutputRelatedMajorAdapter
import com.fadhlalhafizh.pathway.app.ui.path.inputpath.InputPathActivity
import com.fadhlalhafizh.pathway.databinding.ActivityOutputPathBinding

class OutputPathActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOutputPathBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: OutputRelatedMajorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputPathBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.rv_relatedMajor)
        adapter = OutputRelatedMajorAdapter()

        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        goBack()
    }

    private fun goBack() {
        binding.ivBackArrowOutputPath.setOnClickListener {
            val intent = Intent(this, InputPathActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}