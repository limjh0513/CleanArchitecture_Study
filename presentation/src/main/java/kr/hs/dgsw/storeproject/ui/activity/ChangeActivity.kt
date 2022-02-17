package kr.hs.dgsw.storeproject.ui.activity

import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
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
        with(mViewModel) {

        }
    }
}