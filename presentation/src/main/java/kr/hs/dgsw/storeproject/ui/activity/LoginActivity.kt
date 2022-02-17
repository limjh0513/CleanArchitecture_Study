package kr.hs.dgsw.storeproject.ui.activity

import android.content.Intent
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.data.util.SharedPreferenceManager
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
            onSuccessLogin.observe(this@LoginActivity, Observer {

                SharedPreferenceManager.setToken(this@LoginActivity, it.token)
                SharedPreferenceManager.setUserName(this@LoginActivity, it.name)

                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            })

            onErrorLogin.observe(this@LoginActivity, Observer {
                Toast.makeText(this@LoginActivity, "로그인 실패... 다시 시도해주세요.", Toast.LENGTH_SHORT).show()
            })
        }
    }

    fun onClickLoginBtn() {
        val email: String = mBinding.loginEtEmail.text.toString()
        val password: String = mBinding.loginEtPassword.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty()){
            mViewModel.login(email, password)
        } else {
            Toast.makeText(this, "이메일, 비밀번호 모두 작성해주세요", Toast.LENGTH_SHORT).show()
        }
    }

    fun onClickSignupText() {
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }
}