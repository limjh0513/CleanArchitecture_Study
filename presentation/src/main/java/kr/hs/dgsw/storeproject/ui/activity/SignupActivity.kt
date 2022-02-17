package kr.hs.dgsw.storeproject.ui.activity

import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
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
            onSuccessRegister.observe(this@SignupActivity, Observer {
                Toast.makeText(this@SignupActivity, "회원가입 성공! 로그인 해주세요", Toast.LENGTH_SHORT).show()
                finish()
            })

            onErrorRegister.observe(this@SignupActivity, Observer {
                Toast.makeText(this@SignupActivity, "회원가입 실패... 다시 시도해주세요", Toast.LENGTH_SHORT).show()
            })
        }
    }

    fun onClickSignupBtn() {
        val name: String = mBinding.signupEtName.text.toString()
        val email: String = mBinding.signupEtEmail.text.toString()
        val password: String = mBinding.signupEtPassword.text.toString()

        if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
            mViewModel.register(name, email, password)
        } else {
            Toast.makeText(this, "이름, 이메일, 비밀번호 모두 작성해주세요", Toast.LENGTH_SHORT).show()
        }
    }

    fun onClickBackBtn(){
        finish()
    }
}