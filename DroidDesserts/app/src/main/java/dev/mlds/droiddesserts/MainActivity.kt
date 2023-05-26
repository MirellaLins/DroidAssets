package dev.mlds.droiddesserts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.actions.FloatAction
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.core.os.bundleOf
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    @DrawableRes
    private var imageId: Int = 0
    private var imageName: String = ""

    companion object {
        const val KEY_IMAGE = "KEY_IMAGE"
        const val KEY_IMAGE_NAME = "KEY_IMAGE_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image: ImageView = findViewById(R.id.ivDoce1)
        val actionButton = findViewById<FloatingActionButton>(R.id.fabOpenScreen)

        image.setOnClickListener {
            imageId = R.drawable.donut_circle
            imageName = getString(R.string.version_donut)
            Toast.makeText(this, imageName, Toast.LENGTH_LONG).show()
        }

        actionButton.setOnClickListener {
            val openScreentIntent = Intent(this, SecondActivity::class.java)
            openScreentIntent.putExtra(KEY_IMAGE, imageId)
            openScreentIntent.putExtra(KEY_IMAGE_NAME, imageName)

            startActivity(openScreentIntent)
        }
    }
}