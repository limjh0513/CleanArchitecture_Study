package kr.hs.dgsw.storeproject.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.entity.ProductData
import kr.hs.dgsw.domain.usecase.product.DeleteProductUseCase
import kr.hs.dgsw.domain.usecase.product.GetDetailProductUseCase
import kr.hs.dgsw.storeproject.util.SingleLiveEvent
import kr.hs.dgsw.storeproject.viewModel.base.BaseViewModel
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val detailUseCase: GetDetailProductUseCase,
    private val deleteUseCase: DeleteProductUseCase,
) : BaseViewModel() {

    private val _onSuccessGetDetail = MutableLiveData<ProductData>()
    val onSuccessGetDetail: LiveData<ProductData> get() = _onSuccessGetDetail

    private val _onErrorGetDetail = MutableLiveData<Throwable>()
    val onErrorGetDetail: LiveData<Throwable> get() = _onErrorGetDetail

    private val _onSuccessDelete = SingleLiveEvent<Any>()
    val onSuccessDelete: LiveData<Any> get() = _onSuccessDelete

    private val _onErrorDelete = MutableLiveData<Throwable>()
    val onErrorDelete: LiveData<Throwable> get() = _onErrorDelete

    fun getDetailProduct(id: Int) {
        addDisposable(detailUseCase.buildUseCaseObservable(GetDetailProductUseCase.Params(id)),
            object : DisposableSingleObserver<ProductData>() {
                override fun onSuccess(t: ProductData) {
                    _onSuccessGetDetail.value = t
                }

                override fun onError(e: Throwable) {
                    _onErrorGetDetail.value = e
                    Log.e("error_getDetail", "상세 정보 오류 - $e")
                }

            })
    }

    fun deleteProduct(id: Int) {
        addDisposable(deleteUseCase.buildUseCaseObservable(DeleteProductUseCase.Params(id)),
            object : DisposableCompletableObserver() {
                override fun onComplete() {
                    _onSuccessDelete.call()
                }

                override fun onError(e: Throwable) {
                    _onErrorDelete.value = e
                    Log.e("error_Delete", "에러발생 - $e")
                }

            })
    }
}