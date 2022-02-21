package kr.hs.dgsw.storeproject.ui.activity

import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.data.util.SharedPreferenceManager
import kr.hs.dgsw.storeproject.R
import kr.hs.dgsw.storeproject.databinding.ActivityDetailBinding
import kr.hs.dgsw.storeproject.ui.base.BaseActivity
import kr.hs.dgsw.storeproject.viewModel.DetailViewModel

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {
    override val mViewModel: DetailViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_detail

    private var userId: Int? = null
    private var productId: Int? = null

    override fun observeViewModel() {
        getDetailData()

        with(mViewModel) {
            onSuccessGetDetail.observe(this@DetailActivity, Observer {
                mBinding.product = it
                productId = it.id

                if (userId == it.user.id) {
                    mBinding.detailChangeBtn.visibility = View.VISIBLE
                    mBinding.detailDeleteBtn.visibility = View.VISIBLE
                }
            })

            onErrorGetDetail.observe(this@DetailActivity, Observer {
                Toast.makeText(this@DetailActivity, "상세 정보를 가져오는 중 문제가 발생했습니다.", Toast.LENGTH_SHORT)
                    .show()
            })

            onSuccessDelete.observe(this@DetailActivity, Observer {
                Toast.makeText(this@DetailActivity, "삭제 성공!", Toast.LENGTH_SHORT)
                    .show()
                finish()
            })

            onErrorDelete.observe(this@DetailActivity, Observer {
                Toast.makeText(this@DetailActivity, "삭제 중 문제가 발생했습니다.", Toast.LENGTH_SHORT)
                    .show()
            })
        }
    }

    private fun getDetailData() {
        userId = SharedPreferenceManager.getUserId(this)
        val id = intent.getIntExtra("id", -1)

        if (userId != -1) {
            if (id != -1) {
                mViewModel.getDetailProduct(id)
            }
        } else {
            Toast.makeText(this, "유저 정보가 저장되지 않았습니다. 다시 로그인해주세요", Toast.LENGTH_SHORT).show()
        }
    }

    fun onClickDeleteBtn() {
        if (productId != null) {
            mViewModel.deleteProduct(productId!!)
        }
    }

    fun onClickChangeBtn() {

    }

    fun onClickBackBtn(){
        finish()
    }
}