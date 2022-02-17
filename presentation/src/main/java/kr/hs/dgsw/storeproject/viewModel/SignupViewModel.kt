package kr.hs.dgsw.storeproject.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.entity.AuthData
import kr.hs.dgsw.domain.usecase.auth.RegisterUseCase
import kr.hs.dgsw.storeproject.viewModel.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val useCase: RegisterUseCase) : BaseViewModel() {

    private val _onSuccessRegister = MutableLiveData<AuthData>()
    val onSuccessRegister: LiveData<AuthData> get() = _onSuccessRegister

    private val _onErrorRegister = MutableLiveData<Throwable>()
    val onErrorRegister: LiveData<Throwable> get() = _onErrorRegister


    fun register(name: String, email: String, password: String) {
        addDisposable(useCase.buildUseCaseObservable(RegisterUseCase.Params(name, email, password)),
            object : DisposableSingleObserver<AuthData>() {
                override fun onSuccess(t: AuthData) {
                    _onSuccessRegister.value = t
                }

                override fun onError(e: Throwable) {
                    _onErrorRegister.value = e
                    e.printStackTrace()
                    Log.e("error - signup", "Error $e")
                }
            })
    }
}