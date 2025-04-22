package com.example.interviewface

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.interviewface.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val practiceInterviews = listOf(
        PracticeInterview(
            "https://img.freepik.com/free-vector/marketing-concept-illustration_114360-1079.jpg",
            "Entrevista de trabajo de marketing",
            "Prepárate para tu puesto de marketing entrevista"
        ),
        PracticeInterview(
            "https://images.unsplash.com/photo-1519389950473-47ba0277781c",
            "Entrevista de ingeniero de software",
            "Perfecciona tus habilidades para tu entrevista de ingeniería de software"
        ),
        PracticeInterview(
            "https://images.unsplash.com/photo-1504384308090-c894fdcc538d",
            "Entrevista de análisis de datos",
            "Prepárate para tu entrevista de análisis de datos"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupPracticeInterviewsRecyclerView()

        binding.btnStart.setOnClickListener {
            Toast.makeText(this, "Inicio clicked", Toast.LENGTH_SHORT).show()
        }

        binding.ivSettings.setOnClickListener {
            Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
        }

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Inicio selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_interviews -> {
                    Toast.makeText(this, "Entrevistas selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_comments -> {
                    Toast.makeText(this, "Comentarios selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_profile -> {
                    Toast.makeText(this, "Perfil selected", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_more -> {
                    Toast.makeText(this, "Más selected", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    private fun setupPracticeInterviewsRecyclerView() {
        val adapter = PracticeInterviewAdapter(practiceInterviews)
        binding.rvPracticeInterviews.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvPracticeInterviews.adapter = adapter
    }
}

data class PracticeInterview(
    val imageUrl: String,
    val title: String,
    val description: String
)
