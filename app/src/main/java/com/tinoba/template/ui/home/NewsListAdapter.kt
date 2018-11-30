package com.tinoba.template.ui.home

import android.content.Context
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.tinoba.template.R
import com.tinoba.template.util.DiffUtilCallback
import kotlinx.android.synthetic.main.news_list_item.view.*


class NewsListAdapter(private val inflater: LayoutInflater, private val context: Context) : ListAdapter<NewsViewModel, NewsListAdapter.ItemViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ItemViewHolder(inflater.inflate(R.layout.news_list_item, parent, false))


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.fillViews(getItem(position), context)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title = itemView.news_list_item_title
        val description = itemView.news_list_item_description
        val image = itemView.news_list_item_image

        fun fillViews(newsViewModel: NewsViewModel, context: Context) =
                newsViewModel.let {
                    title.text = it.title
                    description.text = it.description
                    if (it.url.isNotEmpty()) {
                        Glide.with(context)
                                .load(it.url)
                                .into(image)
                    }
                }
    }
}