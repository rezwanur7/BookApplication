package com.example.bookapplication.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bookapplication.R
import com.example.bookapplication.activities.LoginActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        //Getting values from my adapter
        val bookTitle = intent.getStringExtra("bookTitle")
        val author = intent.getStringExtra("author")
        val genre = intent.getStringExtra("genre")
        val publicationYear = intent.getStringExtra("year")
        val description = intent.getStringExtra("description")

        // Find views and set data
        val titleTextView: TextView = findViewById(R.id.book_title)
        val authorTextView: TextView = findViewById(R.id.book_author)
        val genreTextView: TextView = findViewById(R.id.book_genre)
        val yearTextView: TextView = findViewById(R.id.publication_year)
        val descriptionTextView: TextView = findViewById(R.id.book_description)
        val backButton: Button = findViewById(R.id.back_button)


        //Setting the values to their corresponding views
        titleTextView.text = bookTitle
        authorTextView.text = "Author: $author"
        genreTextView.text = "Genre: $genre"
        yearTextView.text = "Year: $publicationYear"
        descriptionTextView.text = "Description: $description"

        backButton.setOnClickListener {
            val intent = Intent (this@DetailActivity, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}