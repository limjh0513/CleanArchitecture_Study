package kr.hs.dgsw.storeproject.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.entity.ProductData
import kr.hs.dgsw.domain.usecase.product.PutProductUseCase
import kr.hs.dgsw.storeproject.viewModel.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(private val useCase: PutProductUseCase) : BaseViewModel() {

    private val _onSuccessPutProduct = MutableLiveData<ProductData>()
    val onSuccessPutProduct: LiveData<ProductData> get() = _onSuccessPutProduct

    private val _onErrorPutProduct = MutableLiveData<Throwable>()
    val onErrorPutProduct: LiveData<Throwable> get() = _onErrorPutProduct

    fun putProduct(id: Int, name: String, price: Int) {
        addDisposable(useCase.buildUseCaseObservable(PutProductUseCase.Params(id, name, price)),
            object : DisposableSingleObserver<ProductData>() {
                override fun onSuccess(t: ProductData) {
                    _onSuccessPutProduct.value = t
                }

                override fun onError(e: Throwable) {
                    _onErrorPutProduct.value = e
                    Log.e("error_put", "error - $e")
                }

            })
    }
}