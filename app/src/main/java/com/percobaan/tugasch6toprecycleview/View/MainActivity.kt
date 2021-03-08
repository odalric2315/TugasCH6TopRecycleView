package com.percobaan.tugasch6toprecycleview.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.percobaan.tugasch6toprecycleview.Adapter.MyAdapter
import com.percobaan.tugasch6toprecycleview.Model.MyNote
import com.percobaan.tugasch6toprecycleview.databinding.ActivityMainBinding
import com.percobaan.tugasch6toprecycleview.databinding.EditDialogBinding

@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listNote = arrayListOf(
            MyNote("Ahmad",23),
            MyNote("Budi",29),
            MyNote("Choki",21),
            MyNote("David",28),
            MyNote("Eci",25),
            MyNote("Farah", 22),
            MyNote("Gilang",23)
        )

        val adapter = MyAdapter(listNote)
        adapter.setOnClickListerner {
            showEditDialog(it)
        }
        adapter.setOnDeleteListerner {
            showConfirmationDeleteDialog()
            binding.rvMynote.visibility = View.GONE
        }
        binding.rvMynote.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        binding.rvMynote.adapter = adapter
    }


    fun showConfirmationDeleteDialog() {
        val dialog = AlertDialog.Builder(this)
        dialog.setPositiveButton("Yes") { dialog, _ ->
            Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        dialog.setNegativeButton("No") { dialog, _ ->
            Toast.makeText(this, "No", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        dialog.create().show()
        }


    private fun showEditDialog(myNote: MyNote) {
        val builder = AlertDialog.Builder(this)
        val view = EditDialogBinding.inflate(layoutInflater)
        builder.setView(view.root)
        val dialog = builder.create()
        view.btnEditCancel.setOnClickListener {
            dialog.dismiss()
        }
        view.btnEditSave.setOnClickListener {
            val nama = view.etEditNama.text.toString()
            val umur = view.etEditUmur.text.toString()
            dialog.dismiss()
        }
        dialog.show()
    }
}