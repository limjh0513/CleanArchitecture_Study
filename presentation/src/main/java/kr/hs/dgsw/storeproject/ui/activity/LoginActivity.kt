package kr.hs.dgsw.storeproject.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import kr.hs.dgsw.storeproject.R
import kr.hs.dgsw.storeproject.databinding.ActivityLoginBinding
import kr.hs.dgsw.storeproject.ui.base.BaseActivity
import kr.hs.dgsw.storeproject.viewModel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    override val mViewModel: LoginViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_login

    override fun observeViewModel() {
        with(mViewModel){

        }
    }
}