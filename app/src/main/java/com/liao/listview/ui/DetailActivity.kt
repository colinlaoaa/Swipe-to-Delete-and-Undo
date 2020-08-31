package com.liao.listview.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.liao.listview.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        init()
    }

    private fun init() {
        var i = intent
        textView.text = i.getStringExtra("title")
        textView2.text =i.getStringExtra("des")
        imageView.setImageResource(i.getIntExtra("image",0))

    }
}