package com.liao.listview.adapter

import android.content.ClipData.Item
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.liao.listview.R
import com.liao.listview.model.News
import kotlinx.android.synthetic.main.new_row.view.*


class AdapterRecyclerView(var context: Context, var list: ArrayList<News>) : RecyclerView.Adapter<AdapterRecyclerView.MyViewHolder>(){
    private var mlistener: MyRecyclerAdapterInteration? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.new_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var news = list[position]
        holder.bind(news)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var viewForeground:ConstraintLayout
        fun bind(news: News){
            itemView.text_view_des.text = news.des
            itemView.text_view_title.text = news.title
            itemView.image_view.setImageResource(news.image)
            viewForeground = itemView.view_foreground

            mlistener?.setOnClick(itemView, news)
        }
    }
    interface MyRecyclerAdapterInteration{
        fun setOnClick(itemView: View, news: News)
    }
    fun setInteractionListener(myAdapterInteration: MyRecyclerAdapterInteration){
        mlistener = myAdapterInteration
    }

    fun removeItem(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)

    }

    fun restoreItem(item: News, position: Int) {
        list[position] = item
        // notify item added by position
        notifyItemInserted(position)
        //notifyDataSetChanged()
    }

}