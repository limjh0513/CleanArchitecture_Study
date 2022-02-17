package kr.hs.dgsw.storeproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.entity.AuthData
import kr.hs.dgsw.domain.usecase.auth.LoginUseCase
import kr.hs.dgsw.storeproject.viewModel.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val useCase: LoginUseCase) : BaseViewModel() {
    private val _onSuccessLogin = MutableLiveData<AuthData>()
    val onSuccessLogin: LiveData<AuthData> get() = _onSuccessLogin

    private val _onErrorLogin = MutableLiveData<Throwable>()
    val onErrorLogin: LiveData<Throwable> get() = _onErrorLogin

    fun login(email: String, password: String){
        addDisposable(useCase.buildUseCaseObservable(LoginUseCase.Params(email, password)), object : DisposableSingleObserver<AuthData>(){
            override fun onSuccess(t: AuthData) {
                _onSuccessLogin.value = t
            }

            override fun onError(e: Throwable) {
                _onErrorLogin.value = e
            }

        })
    }
}