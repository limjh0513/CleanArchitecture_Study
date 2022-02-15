package kr.hs.dgsw.storeproject.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import kr.hs.dgsw.storeproject.R
import kr.hs.dgsw.storeproject.databinding.ActivityChangeBinding
import kr.hs.dgsw.storeproject.ui.base.BaseActivity
import kr.hs.dgsw.storeproject.viewModel.ChangeViewModel

class ChangeActivity : BaseActivity<ActivityChangeBinding, ChangeViewModel>() {
    override val mViewModel: ChangeViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_change

    override fun observeViewModel() {
        with(mViewModel){

        }
    }
}