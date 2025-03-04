package com.example.tksjji

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        val btnEdit = findViewById<ImageButton>(R.id.btnEdit)
        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvLocation = findViewById<TextView>(R.id.tv_location)

        btnBack.setOnClickListener {
            finish() // Quay lại màn hình trước
        }

        btnEdit.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.dialog_edit_profile, null)
            val editName = dialogView.findViewById<EditText>(R.id.edit_name)
            val editLocation = dialogView.findViewById<EditText>(R.id.edit_location)

            editName.setText(tvName.text)
            editLocation.setText(tvLocation.text)

            AlertDialog.Builder(this)
                .setTitle("Chỉnh sửa thông tin")
                .setView(dialogView)
                .setPositiveButton("Lưu") { _, _ ->
                    tvName.text = editName.text.toString()
                    tvLocation.text = editLocation.text.toString()
                }
                .setNegativeButton("Hủy", null)
                .show()
        }
    }
}
