package com.example.codepathmail

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.
        val userTextView: TextView
        val subjectTextView: TextView
        val contentTextView: TextView
        val readButton: Button

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            userTextView = itemView.findViewById(R.id.userField)
            subjectTextView = itemView.findViewById(R.id.subjectField)
            contentTextView = itemView.findViewById(R.id.contentField)
            readButton = itemView.findViewById(R.id.readButton)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // TODO("Not yet implemented")
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.email_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        // TODO("Not yet implemented")
        return emails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO("Not yet implemented")
        // Get the data model based on position
        val email = emails.get(position)
        // Set item views based on views and data model
        holder.userTextView.text = email.sender
        holder.subjectTextView.text = email.title
        holder.contentTextView.text = email.summary
    }


}