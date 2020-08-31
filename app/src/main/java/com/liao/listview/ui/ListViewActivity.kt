package com.liao.listview.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.liao.listview.R
import com.liao.listview.adapter.AdapterListView
import com.liao.listview.model.News
import kotlinx.android.synthetic.main.activity_main.*

class ListViewActivity : AppCompatActivity(), AdapterListView.MyAdapterInteration {
    var mList: ArrayList<News> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mList = getData()
        init()
    }

    private fun getData(): ArrayList<News>{
        var newsList: ArrayList<News> = ArrayList()
        newsList.add(News("news 1","1111111",R.drawable.ic_android_black_24dp))
        newsList.add(News("news 2","2222222",R.drawable.ic_baseline_access_time_24))
        newsList.add(News("news 3","3333333",R.drawable.ic_launcher_background))
        newsList.add(News("news 4","4444444",R.drawable.ic_launcher_foreground))
        newsList.add(News("news 5","5555555",R.drawable.ic_baseline_accessibility_new_24))
        newsList.add(News("news 6","6666666",R.drawable.ic_android_black_24dp))
        newsList.add(News("news 1","1111111",R.drawable.ic_android_black_24dp))
        newsList.add(News("news 2","2222222",R.drawable.ic_baseline_access_time_24))
        newsList.add(News("news 3","3333333",R.drawable.ic_launcher_background))
        newsList.add(News("news 4","4444444",R.drawable.ic_launcher_foreground))
        newsList.add(News("news 5","5555555",R.drawable.ic_baseline_accessibility_new_24))
        newsList.add(News("news 6","6666666",R.drawable.ic_android_black_24dp))
        return newsList
    }

    private fun init() {
        to_rec.setOnClickListener {
            startActivity(Intent(this,RecyclerViewActivity::class.java))
        }

        var adapterListView = AdapterListView(this,mList)
        adapterListView.setInteractionListener(this)
        list_view.adapter = adapterListView
    }

    override fun setOnClick(view: View?,news: News) {
        view?.setOnClickListener {
            var myIntent = Intent(this,DetailActivity::class.java)
            myIntent.putExtra("title",news.title)
            myIntent.putExtra("des",news.des)
            myIntent.putExtra("image",news.image)
            startActivity(myIntent)
        }
    }
}