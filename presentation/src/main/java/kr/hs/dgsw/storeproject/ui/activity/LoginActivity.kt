package kr.hs.dgsw.storeproject.ui.activity

import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.storeproject.R
import kr.hs.dgsw.storeproject.databinding.ActivityLoginBinding
import kr.hs.dgsw.storeproject.ui.base.BaseActivity
import kr.hs.dgsw.storeproject.viewModel.LoginViewModel

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    override val mViewModel: LoginViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_login

    override fun observeViewModel() {
        with(mViewModel) {

        }
    }
}