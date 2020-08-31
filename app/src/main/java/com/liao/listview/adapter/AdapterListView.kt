package com.liao.listview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.liao.listview.R
import com.liao.listview.model.News
import kotlinx.android.synthetic.main.new_row.view.*

class AdapterListView(private var context: Context, private var list: ArrayList<News>) :BaseAdapter(){
    private var mlistener:MyAdapterInteration? = null
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.new_row,parent,false)
        var news = list[position]
        view.text_view_title.text = news.title
        view.text_view_des.text = news.des
        view.image_view.setImageResource(news.image)
        view.image_view.setOnClickListener {
            view.image_view2.visibility = View.VISIBLE
            view.image_view2.setImageResource(news.image)
            view.image_view.visibility = View.GONE
            view.image_view2.setOnClickListener {
                view.image_view.visibility = View.VISIBLE
                view.image_view2.visibility = View.GONE
            }
        }
        mlistener?.setOnClick(view,news)
        return view

    }

    interface MyAdapterInteration{
        fun setOnClick(view: View?,news: News)
    }
    fun setInteractionListener(myAdapterInteration:MyAdapterInteration){
        mlistener = myAdapterInteration
    }
}