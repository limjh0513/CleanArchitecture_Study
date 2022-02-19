package kr.hs.dgsw.storeproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.entity.UserData
import kr.hs.dgsw.domain.usecase.user.UpdateUserUseCase
import kr.hs.dgsw.storeproject.viewModel.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class ChangeViewModel @Inject constructor(private val updateUseCase: UpdateUserUseCase) : BaseViewModel() {
    private val _onSuccessChange = MutableLiveData<UserData>()
    val onSuccessChange: LiveData<UserData> get() = _onSuccessChange

    private val _onErrorChange = MutableLiveData<Throwable>()
    val onErrorChange: LiveData<Throwable> get() = _onErrorChange

    fun updateUser(name: String, email: String){
        addDisposable(updateUseCase.buildUseCaseObservable(UpdateUserUseCase.Params(name, email)), object : DisposableSingleObserver<UserData>(){
            override fun onSuccess(t: UserData) {
                _onSuccessChange.value = t
            }

            override fun onError(e: Throwable) {
                _onErrorChange.value = e
                e.printStackTrace()
            }

        })
    }
}