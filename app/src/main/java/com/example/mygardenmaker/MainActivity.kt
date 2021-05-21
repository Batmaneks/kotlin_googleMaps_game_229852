package com.example.mygardenmaker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mygardenmaker.data.Garden
import com.example.mygardenmaker.models.Building

private fun generateSampleData(): List<Garden> {
    return listOf(
        Garden(
            name = "My Garden next to home", latitude = 51.176537, longitude = 16.88481,
            gardenBuildings = listOf(
                Building(Name = "birchTree", x = 100, y = 200),
                Building(Name = "oakTree", x = 50, y = 12),
                Building(Name = "bench", x = 44, y = 89)
            )
        ),
        Garden(
            name = "My Garden next to work", latitude = 51.45, longitude = 16.50,
            gardenBuildings = listOf(
                Building(Name = "birchTree", x = 100, y = 200),
                Building(Name = "oakTree", x = 50, y = 12),
                Building(Name = "bench", x = 44, y = 89)
            )
        ),
        Garden(
            name = "Test Garden", latitude = 51.18, longitude = 16.90,
            gardenBuildings = listOf(
                Building(Name = "birchTree", x = 100, y = 200),
                Building(Name = "oakTree", x = 50, y = 12),
                Building(Name = "bench", x = 44, y = 89)
            )
        )
    )
}
var userGardens = generateSampleData()
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val goToMapBtn = findViewById<Button>(R.id.goToMapButton)
        goToMapBtn.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            //intent.putStringArrayListExtra(userGardens)
            intent.putParcelableArrayListExtra("Gardens", ArrayList(userGardens))
            //startActivity(intent)
        }
        val addGardenBtn = findViewById<Button>(R.id.addGardenButton)
        addGardenBtn.setOnClickListener {
            val intent=Intent(this,GardenSetupActivity::class.java)
            startActivity(intent)
        }

        val gardensListRV :RecyclerView= findViewById(R.id.gardensListRecView)
        gardensListRV.layoutManager = LinearLayoutManager(this)
        gardensListRV.adapter = MapsAdapter(this, userGardens, object: MapsAdapter.OnClickListener{
            override fun onItemClick(position: Int) {

            }
        })
    }

}