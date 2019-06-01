package com.example.iteradmin.bluetoothjune1

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
private val REQUEST_CODE:Int=108
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val active = findViewById<Button>(R.id.button)
        val badp: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        active.setOnClickListener {
            if (badp == null) {
                Toast.makeText(this, "Bluetooth not found", Toast.LENGTH_LONG).show()
            } else {
                if (badp.isEnabled == false) {

                    val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                    startActivityForResult(intent, REQUEST_CODE)
                } else
                    Toast.makeText(this, "Bluetooth already on", Toast.LENGTH_LONG).show()

            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == REQUEST_CODE && resultCode == Activity.RESULT_OK)
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
    else Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
    }

    }

