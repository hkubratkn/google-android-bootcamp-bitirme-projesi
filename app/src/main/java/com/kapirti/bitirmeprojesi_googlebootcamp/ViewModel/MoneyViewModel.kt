package com.kapirti.bitirmeprojesi_googlebootcamp.ViewModel

import androidx.lifecycle.MutableLiveData
import com.kapirti.bitirmeprojesi_googlebootcamp.Model.CurrencyModel
import com.kapirti.bitirmeprojesi_googlebootcamp.Service.MoneyApiServise
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MoneyViewModel {

    val currency= MutableLiveData<List<CurrencyModel>>()
    private val moneyApiServise=MoneyApiServise()
    private val disposable=CompositeDisposable()

    fun refreshData(){
        verileriInternettenAl()

    }
    private fun verileriInternettenAl(){
        disposable.add(
            moneyApiServise.getData()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object:DisposableSingleObserver<List<CurrencyModel>>(){
                        override fun onSuccess(t: List<CurrencyModel>) {

                        }

                        override fun onError(e: Throwable) {
                            e.printStackTrace()
                        }

                    })
        )

    }

}