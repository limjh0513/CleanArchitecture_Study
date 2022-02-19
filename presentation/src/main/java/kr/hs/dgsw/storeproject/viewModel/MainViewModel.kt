package kr.hs.dgsw.storeproject.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.entity.ProductData
import kr.hs.dgsw.domain.usecase.product.GetAllProductUseCase
import kr.hs.dgsw.storeproject.viewModel.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getAllUseCase: GetAllProductUseCase) : BaseViewModel() {

    private val _onSuccessGetAllProduct = MutableLiveData<List<ProductData>>()
    val onSuccessGetAllProduct: LiveData<List<ProductData>> get() = _onSuccessGetAllProduct

    private val _onErrorGetAllProduct = MutableLiveData<Throwable>()
    val onErrorGetAllProduct: LiveData<Throwable> get() = _onErrorGetAllProduct

    init {
        getAllProduct()
    }

    fun getAllProduct(){
        addDisposable(getAllUseCase.buildUseCaseObservable(), object : DisposableSingleObserver<List<ProductData>>(){
            override fun onSuccess(t: List<ProductData>) {
                _onSuccessGetAllProduct.value = t
            }

            override fun onError(e: Throwable) {
                _onErrorGetAllProduct.value = e
                Log.e("Error_getAll", "$e")
                e.printStackTrace()
            }

        })
    }
}