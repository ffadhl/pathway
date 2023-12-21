package com.fadhlalhafizh.pathway.app.ui.path.inputpath

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.fadhlalhafizh.pathway.app.ui.path.outputpath.OutputPathActivity
import com.fadhlalhafizh.pathway.databinding.ActivityInputPathBinding

class InputPathActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputPathBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputPathBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setSoftInputMode(android.view.WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        submit()
    }

    private fun submit() {
        binding.btnSubmit.setOnClickListener {
            // Create an AlertDialog
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setMessage("Done")

            // Set positive button
            alertDialogBuilder.setPositiveButton("OK",
                DialogInterface.OnClickListener { dialog, which ->
                    // User clicked OK button
                    navigateToOutputPathActivity()
                })

            // Create and show the alert dialog
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }

    private fun navigateToOutputPathActivity() {
        val intent = Intent(this, OutputPathActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}