package com.example.mymaterialuidesign

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.mymaterialuidesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener{
            Toast.makeText(this,"You Clicked Me Done", Toast.LENGTH_SHORT).show()
        }


        binding.btnDialog.setOnClickListener{
            showMeDialog()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_menu,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_delete -> {
                Toast.makeText(this, "Deleted Clicked", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.action_refresh -> {
                Toast.makeText(this, "Refresh Clicked", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.action_settings -> {
                Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }






    private fun showMeDialog(){
        var builder = AlertDialog.Builder(this)
        builder.apply {
            setTitle("Title")
            setMessage("Message")
            setPositiveButton("Yes",DialogInterface.OnClickListener{dialogInterface, i ->
                Toast.makeText(this@MainActivity, "Done Positive Button", Toast.LENGTH_SHORT).show()
            })


            setPositiveButton("No",DialogInterface.OnClickListener{dialogInterface, i ->
                Toast.makeText(this@MainActivity, "Done Negative Button", Toast.LENGTH_SHORT).show()
            })
        }
        val dialog = builder.create()
        dialog.show()
    }


}