package com.tinoba.template.util

import android.support.v7.util.DiffUtil
import com.tinoba.template.ui.home.NewsViewModel

class DiffUtilCallback : DiffUtil.ItemCallback<NewsViewModel>() {
    override fun areItemsTheSame(oldItem: NewsViewModel?, newItem: NewsViewModel?): Boolean {
        return oldItem?.title == newItem?.title
    }

    override fun areContentsTheSame(oldItem: NewsViewModel?, newItem: NewsViewModel?): Boolean {
        return oldItem == newItem
    }
}

