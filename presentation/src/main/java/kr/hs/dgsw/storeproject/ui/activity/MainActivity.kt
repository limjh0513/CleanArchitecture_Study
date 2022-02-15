package kr.hs.dgsw.storeproject.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.storeproject.R
import kr.hs.dgsw.storeproject.databinding.ActivityMainBinding
import kr.hs.dgsw.storeproject.ui.base.BaseActivity
import kr.hs.dgsw.storeproject.viewModel.MainViewModel

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val mViewModel: MainViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun observeViewModel() {
        with(mViewModel){

        }
    }
}