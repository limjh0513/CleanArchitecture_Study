package kr.hs.dgsw.storeproject.ui.activity

import androidx.activity.viewModels
import kr.hs.dgsw.storeproject.R
import kr.hs.dgsw.storeproject.databinding.ActivitySignupBinding
import kr.hs.dgsw.storeproject.ui.base.BaseActivity
import kr.hs.dgsw.storeproject.viewModel.SignupViewModel

class SignupActivity : BaseActivity<ActivitySignupBinding, SignupViewModel>() {
    override val mViewModel: SignupViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_signup

    override fun observeViewModel() {
        with(mViewModel) {

        }
    }
}