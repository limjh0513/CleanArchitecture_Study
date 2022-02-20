package kr.hs.dgsw.storeproject.ui.activity

import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.storeproject.R
import kr.hs.dgsw.storeproject.databinding.ActivityMainBinding
import kr.hs.dgsw.storeproject.ui.adapter.ProductListAdapter
import kr.hs.dgsw.storeproject.ui.base.BaseActivity
import kr.hs.dgsw.storeproject.viewModel.MainViewModel

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val mViewModel: MainViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_main

    private var adapter: ProductListAdapter? = null

    override fun observeViewModel() {
        setAdapter()

        with(mViewModel) {
            onSuccessGetAllProduct.observe(this@MainActivity, Observer {
                adapter!!.submitList(it)
            })

            onErrorGetAllProduct.observe(this@MainActivity, Observer {
                Toast.makeText(this@MainActivity, "오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
            })
        }
    }

    private fun setAdapter() {
        adapter = ProductListAdapter()
        adapter!!.context = this

        mBinding.mainRecyclerView.adapter = adapter
    }
}