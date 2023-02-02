package com.example.codepathmail

import android.annotation.SuppressLint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    lateinit var emails: MutableList<Email>
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailRecyclerView = findViewById<RecyclerView>(R.id.emailRcv)
        emails = EmailFetcher.getEmails()
        val emailAdapter = EmailAdapter(emails)
        emailRecyclerView.adapter = emailAdapter
        emailRecyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.loadButton).setOnClickListener {
            // Fetch next 5 emails and display in RecyclerView
            val nextEmails = EmailFetcher.getNext5Emails()
            emails.addAll(nextEmails)
            emailAdapter.notifyDataSetChanged()
        }
    }


}