package com.example.mymaterialuidesign

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.mymaterialuidesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val actionMap = mapOf(
        R.id.action_delete to "Deleted Clicked",
        R.id.action_refresh to "Refresh Clicked",
        R.id.action_settings to "Settings Clicked"
    )

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.floatingActionButton.setOnClickListener { showToast("You Clicked Me Done") }
        binding.btnDialog.setOnClickListener { showDialog() }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val message = actionMap[item.itemId] ?: return super.onOptionsItemSelected(item)
        showToast(message)
        return true
    }

    private fun showDialog(title: String = "Title", message: String = "Message") {
        val dialog = AlertDialog.Builder(this).apply {
            setTitle(title)
            setMessage(message)
            setPositiveButton("Yes") { _, _ -> showToast("Done Positive Button") }
            setPositiveButton("No") { _, _ -> showToast("Done Negative Button") }
        }
        dialog.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}