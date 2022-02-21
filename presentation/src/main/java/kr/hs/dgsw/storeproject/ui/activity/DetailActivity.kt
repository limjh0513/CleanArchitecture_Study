package kr.hs.dgsw.storeproject.ui.activity

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.data.util.SharedPreferenceManager
import kr.hs.dgsw.domain.model.entity.ProductData
import kr.hs.dgsw.storeproject.R
import kr.hs.dgsw.storeproject.databinding.ActivityDetailBinding
import kr.hs.dgsw.storeproject.ui.base.BaseActivity
import kr.hs.dgsw.storeproject.viewModel.DetailViewModel

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {
    override val mViewModel: DetailViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_detail

    private var productId: Int? = null
    private var userId: Int? = null
    private var product: ProductData? = null

    override fun onResume() {
        super.onResume()

        if (product != null) {
            mViewModel.getDetailProduct(product!!.id)
            Log.e("getId", "${product!!.id}")
        }
    }

    override fun observeViewModel() {
        getDetailData()

        with(mViewModel) {
            onSuccessGetDetail.observe(this@DetailActivity, Observer {
                mBinding.product = it
                product = it

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
        productId = intent.getIntExtra("id", -1)
        userId = SharedPreferenceManager.getUserId(this)

        if(userId != null){
            if (productId != -1) {
                mViewModel.getDetailProduct(productId!!)
            } else {
                Toast.makeText(this, "상품 정보 고유번호 오류", Toast.LENGTH_SHORT).show()
            }
        } else{
            Toast.makeText(this, "회원 정보에 문제가 발생했습니다. 다시 로그인 해주세요!", Toast.LENGTH_SHORT).show()
        }
    }

    fun onClickDeleteBtn() {
        if (product != null) {
            if (product?.id != null) {
                mViewModel.deleteProduct(product!!.id)
                Log.e("getId", "${product!!.id}")
            }
        }
    }

    fun onClickChangeBtn() {
        if(product != null){
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("productData", product)
            startActivity(intent)
        }
    }

    fun onClickBackBtn() {
        finish()
    }
}