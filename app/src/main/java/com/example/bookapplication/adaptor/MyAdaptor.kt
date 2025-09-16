package com.example.bookapplication.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.R
import com.example.bookapplication.activities.DetailActivity
import com.example.bookapplication.models.EntityDetails

class MyAdapter(private val entityList: List<EntityDetails>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val entityTitle: TextView = itemView.findViewById(R.id.entity_title)
        val entityAuthor: TextView = itemView.findViewById(R.id.entity_author)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_entity_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entity = entityList.getOrNull(position)
        holder.entityTitle.text = entity?.title ?: "Unknown Title"
        holder.entityAuthor.text = entity?.author ?: "Unknown Author"

        // In MyAdapter class
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)

            //Pass artwork details
            if (entity != null) {
                intent.putExtra("bookTitle", entity.title)
            }
            if (entity != null) {
                intent.putExtra("author", entity.author)
            }
            if (entity != null) {
                intent.putExtra("genre", entity.genre)
            }
            if (entity != null) {
                intent.putExtra("year", entity. publicationYear)
            }
            if (entity != null) {
                intent.putExtra("description", entity.description)
            }

            // Start DetailActivity
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return entityList.size
    }


}