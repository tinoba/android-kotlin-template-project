package com.tinoba.template.ui.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.tinoba.template.R
import com.tinoba.template.base.BaseActivity
import com.tinoba.template.base.ScopedPresenter
import com.tinoba.template.dagger.activity.ActivityComponent
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject


class HomeActivity : BaseActivity(), HomeContract.View {

    @Inject
    lateinit var presenter: HomeContract.Presenter

    @Inject
    lateinit var adapter: NewsListAdapter

    lateinit var recyclerView: RecyclerView

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun getPresenter(): ScopedPresenter {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView = activity_home_recycler_view
        initRecyclerView()
        presenter.showNews()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = createLinearLayoutManager()
        recyclerView.adapter = adapter
    }

    private fun createLinearLayoutManager(): LinearLayoutManager {
        return LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun render(newsViewModels: List<NewsViewModel>) {
        adapter.submitList(newsViewModels)
    }
}

