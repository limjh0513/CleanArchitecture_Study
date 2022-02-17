package kr.hs.dgsw.storeproject.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kr.hs.dgsw.storeproject.BR
import kr.hs.dgsw.storeproject.viewModel.base.BaseViewModel

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    private lateinit var mBinding: VB
    protected abstract val mViewModel: VM
    protected abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initDataBinding()
        observeViewModel()
    }

    private fun initDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, layoutRes)
        mBinding.setVariable(BR.viewModel, mViewModel)
        mBinding.setVariable(BR.activity, this)
        mBinding.lifecycleOwner = this
        mBinding.executePendingBindings()
    }

    protected abstract fun observeViewModel()

    override fun onDestroy() {
        super.onDestroy()
        if (::mBinding.isInitialized) mBinding.unbind()
    }
}