package com.tinoba.template.ui.home

import com.tinoba.template.base.ScopedPresenter

interface HomeContract {

    interface Presenter : ScopedPresenter {

        fun showNews()
    }

    interface View {
        fun render(newsViewModels: List<NewsViewModel>)
    }
}