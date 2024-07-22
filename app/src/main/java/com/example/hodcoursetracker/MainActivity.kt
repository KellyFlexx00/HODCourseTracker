package com.example.hodcoursetracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val courseRef = database.getReference("courses")

        submitButton.setOnClickListener {
            val courseName = courseName.text.toString()
            val courseStartDate = courseStartDate.text.toString()
            // Get other field values

            val course = Course(courseName, courseStartDate)
            courseRef.push().setValue(course)
        }
    }
}
