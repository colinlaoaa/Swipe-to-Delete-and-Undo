package com.liao.listview.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import com.google.android.material.snackbar.Snackbar
import com.liao.listview.R
import com.liao.listview.adapter.AdapterRecyclerView
import com.liao.listview.helpers.RecyclerItemTouchHelper
import com.liao.listview.model.News
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.new_row.view.*


class RecyclerViewActivity : AppCompatActivity(), AdapterRecyclerView.MyRecyclerAdapterInteration, RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {
    var mList: ArrayList<News> = ArrayList()
    var flag = true
    lateinit var adapterRecyclerView:AdapterRecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        mList = getData()
        init()
    }

    private fun init() {

        val itemTouchHelperCallback =
            RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT)
        itemTouchHelperCallback.setListener(this)

        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recycler_view);

        change_button.setOnClickListener {
            if (flag) {
                recycler_view.layoutManager = GridLayoutManager(this, 2)
                flag = false
                change_button.text = "To Linear"
            } else {
                recycler_view.layoutManager = LinearLayoutManager(this)
                flag = true
                change_button.text = "To Grid"
            }
        }
        recycler_view.layoutManager = LinearLayoutManager(this)
        adapterRecyclerView = AdapterRecyclerView(this, mList)
        adapterRecyclerView.setInteractionListener(this)
        recycler_view.adapter = adapterRecyclerView
        recycler_view.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        recycler_view.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.HORIZONTAL
            )
        )
    }

    private fun getData(): ArrayList<News> {
        var newsList: ArrayList<News> = ArrayList()
        newsList.add(News("news 1", "1111111", R.drawable.ic_android_black_24dp))
        newsList.add(News("news 2", "2222222", R.drawable.ic_baseline_access_time_24))
        newsList.add(News("news 3", "3333333", R.drawable.ic_launcher_background))
        newsList.add(News("news 4", "4444444", R.drawable.ic_launcher_foreground))
        newsList.add(News("news 5", "5555555", R.drawable.ic_baseline_accessibility_new_24))
        newsList.add(News("news 6", "6666666", R.drawable.ic_android_black_24dp))
        newsList.add(News("news 1", "1111111", R.drawable.ic_android_black_24dp))
        newsList.add(News("news 2", "2222222", R.drawable.ic_baseline_access_time_24))
        newsList.add(News("news 3", "3333333", R.drawable.ic_launcher_background))
        newsList.add(News("news 4", "4444444", R.drawable.ic_launcher_foreground))
        newsList.add(News("news 5", "5555555", R.drawable.ic_baseline_accessibility_new_24))
        newsList.add(News("news 6", "6666666", R.drawable.ic_android_black_24dp))
        newsList.add(News("news 1", "1111111", R.drawable.ic_android_black_24dp))
        newsList.add(News("news 2", "2222222", R.drawable.ic_baseline_access_time_24))
        newsList.add(News("news 3", "3333333", R.drawable.ic_launcher_background))
        newsList.add(News("news 4", "4444444", R.drawable.ic_launcher_foreground))
        newsList.add(News("news 5", "5555555", R.drawable.ic_baseline_accessibility_new_24))
        newsList.add(News("news 6", "6666666", R.drawable.ic_android_black_24dp))
        newsList.add(News("news 1", "1111111", R.drawable.ic_android_black_24dp))
        newsList.add(News("news 2", "2222222", R.drawable.ic_baseline_access_time_24))
        newsList.add(News("news 3", "3333333", R.drawable.ic_launcher_background))
        newsList.add(News("news 4", "4444444", R.drawable.ic_launcher_foreground))
        newsList.add(News("news 5", "5555555", R.drawable.ic_baseline_accessibility_new_24))
        newsList.add(News("news 6", "6666666", R.drawable.ic_android_black_24dp))
        return newsList
    }

    override fun setOnClick(itemView: View, news: News) {
        itemView.setOnClickListener {
            var myIntent = Intent(this, DetailActivity::class.java)
            myIntent.putExtra("title", news.title)
            myIntent.putExtra("des", news.des)
            myIntent.putExtra("image", news.image)
            startActivity(myIntent)
        }
        itemView.image_view.setOnClickListener {
            itemView.image_view2.visibility = View.VISIBLE
            itemView.image_view2.setImageResource(news.image)
            itemView.image_view.visibility = View.GONE
            itemView.image_view2.setOnClickListener {
                itemView.image_view.visibility = View.VISIBLE
                itemView.image_view2.visibility = View.GONE
            }
        }
    }



    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int, position: Int) {
        if (viewHolder is AdapterRecyclerView.MyViewHolder) {
            val title: String = mList[viewHolder.getAdapterPosition()].title
            val deletedItem: News = mList[viewHolder.getAdapterPosition()]
            val deletedIndex = viewHolder.getAdapterPosition()
            adapterRecyclerView.removeItem(viewHolder!!.adapterPosition)
            var snackbar = Snackbar
                    .make(coordinatorLayout, title + " removed from cart!", Snackbar.LENGTH_LONG);
            snackbar.setAction("UNDO", View.OnClickListener() {
                adapterRecyclerView.restoreItem(deletedItem, deletedIndex)
            })
            snackbar.setActionTextColor(Color.YELLOW)
            snackbar.show()
        }
    }
}