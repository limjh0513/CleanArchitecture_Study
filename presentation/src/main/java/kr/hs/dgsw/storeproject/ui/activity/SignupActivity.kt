package kr.hs.dgsw.storeproject.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.storeproject.R
import kr.hs.dgsw.storeproject.databinding.ActivitySignupBinding
import kr.hs.dgsw.storeproject.ui.base.BaseActivity
import kr.hs.dgsw.storeproject.viewModel.SignupViewModel

@AndroidEntryPoint
class SignupActivity : BaseActivity<ActivitySignupBinding, SignupViewModel>() {
    override val mViewModel: SignupViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_signup

    override fun observeViewModel() {
        with(mViewModel) {

        }
    }
}