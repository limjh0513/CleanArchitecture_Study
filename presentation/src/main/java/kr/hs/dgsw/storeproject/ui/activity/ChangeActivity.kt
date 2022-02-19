package kr.hs.dgsw.storeproject.ui.activity

import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.data.util.SharedPreferenceManager
import kr.hs.dgsw.storeproject.R
import kr.hs.dgsw.storeproject.databinding.ActivityChangeBinding
import kr.hs.dgsw.storeproject.ui.base.BaseActivity
import kr.hs.dgsw.storeproject.viewModel.ChangeViewModel

@AndroidEntryPoint
class ChangeActivity : BaseActivity<ActivityChangeBinding, ChangeViewModel>() {
    override val mViewModel: ChangeViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_change

    override fun observeViewModel() {
        getUserName()
        with(mViewModel) {
            onSuccessChange.observe(this@ChangeActivity, Observer {
                Toast.makeText(this@ChangeActivity, "변경 성공!!!", Toast.LENGTH_SHORT).show()
                finish()
            })

            onErrorChange.observe(this@ChangeActivity, Observer {
                Toast.makeText(this@ChangeActivity, "변경 실패했습니다. ${it.message}", Toast.LENGTH_SHORT).show()
            })
        }
    }

    private fun getUserName() {
        val name: String? = SharedPreferenceManager.getUserName(this)
        if(name != null){
            mBinding.name = name
        }
    }
}