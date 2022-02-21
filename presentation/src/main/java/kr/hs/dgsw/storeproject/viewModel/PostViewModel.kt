package kr.hs.dgsw.storeproject.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.entity.ProductData
import kr.hs.dgsw.domain.usecase.product.PostProductUseCase
import kr.hs.dgsw.storeproject.viewModel.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val useCase: PostProductUseCase) : BaseViewModel() {

    private val _onSuccessPostProduct = MutableLiveData<ProductData>()
    val onSuccessPostProduct: LiveData<ProductData> get() = _onSuccessPostProduct

    private val _onErrorPostProduct = MutableLiveData<Throwable>()
    val onErrorPostProduct: LiveData<Throwable> get() = _onErrorPostProduct


    fun postProduct(name: String, price: Int) {
        addDisposable(useCase.buildUseCaseObservable(PostProductUseCase.Params(name, price)),
            object : DisposableSingleObserver<ProductData>() {
                override fun onSuccess(t: ProductData) {
                    _onSuccessPostProduct.value = t
                }

                override fun onError(e: Throwable) {
                    _onErrorPostProduct.value = e
                    Log.e("error_post", "에러 발생 - $e")
                }

            })
    }
}