package ca.hjtaki.fragment_contry_land

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ca.hjtaki.fragment_contry_land.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detail)

        val countryName = intent.getStringExtra("name")

        val titleTV = findViewById<TextView>(R.id.country_name)
        titleTV.setText(countryName.capitalize())

        val descriptionTv = findViewById<TextView>(R.id.country_description)
        descriptionTv.setText("1")
    }
}
