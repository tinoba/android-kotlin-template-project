package com.tinoba.template.ui.home

import com.tinoba.domain.interactor.GetNewsUseCase
import com.tinoba.template.base.BasePresenter
import javax.inject.Inject

class HomePresenter(view: HomeContract.View) : BasePresenter<HomeContract.View>(view), HomeContract.Presenter {

    @Inject
    lateinit var getNewsUseCase: GetNewsUseCase

    override fun showNews() {
        addDisposable(getNewsUseCase.run()
                .subscribeOn(backgroundScheduler)
                .map { it.map { NewsViewModel(it.title, it.description, it.author, it.imgUrl) } }
                .observeOn(mainThreadScheduler)
                .subscribe(this::onGetNewsSuccess, Throwable::printStackTrace))
    }

    private fun onGetNewsSuccess(articles: List<NewsViewModel>) {
        getView()?.render(articles)
    }

}